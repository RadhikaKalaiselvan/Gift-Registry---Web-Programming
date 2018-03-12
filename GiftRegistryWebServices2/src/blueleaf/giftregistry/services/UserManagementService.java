package blueleaf.giftregistry.services;
import java.util.Random;
import java.util.logging.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.whalin.MemCached.MemCachedClient;
import com.whalin.MemCached.SockIOPool;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;


import blueleaf.giftregistry.model.Status;
import blueleaf.giftregistry.model.UserInfo;

@Path("/usermanagementservice")

public class UserManagementService {
	
	public static final String ACCOUNT_SID = "AC4f439526da40584ec706ac7984cc625b";
	public static final String AUTH_TOKEN = "efcaeae4386322aab5efba07189146a0";
	private final static Logger logger = Logger.getLogger(UserManagementService.class.getName());	
	  
	@Path("/authenticateUser/")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Status authenticateUser(UserInfo u){
		logger.info("Application Server 2 : authenticate user called :"+u.getEmail());
		Client client=ClientBuilder.newClient();
		Status s=new Status();
		Response r=client.target("http://localhost:8085/GiftRegistryDBWeb/rest/customerdetails/"+u.getEmail()).request().header("authorization","WPLblueleaf2991").get();
		UserInfo validUserInfo=r.readEntity(UserInfo.class);
		if(validUserInfo.getUserID()==0){
			s.setCode(103);
			s.setMessage("User doesnot exits");
		}else{
			if(!u.getPassword().equals(validUserInfo.getPassword())){
				s.setCode(104);
				s.setMessage("Invalid Password");
			}else{
				if(validUserInfo.getUserType()==1){
					s.setCode(110);
				}else{
				s.setCode(100);
				}
				s.setMessage("Authentication Success");
			}
		}
		return s;
	}
	
	@Path("/updateUserProfileInfo/")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public UserInfo updateUserProfileInfo(UserInfo newInfo){
		logger.info("Application Server 2 : update user info called :"+newInfo.getEmail());
		Client client=ClientBuilder.newClient();
		Response r=client.target("http://localhost:8085/GiftRegistryDBWeb/rest/customerdetails/updateInfo").request().header("authorization","WPLblueleaf2991").header("userkey",new StringBuilder(newInfo.getUserID()+"").reverse().toString()).post(Entity.json(newInfo));
		UserInfo updatedUserInfo=r.readEntity(UserInfo.class);
		String[] servers = {"localhost:11211"};
		SockIOPool pool = SockIOPool.getInstance("Test1");
		pool.setServers( servers );
		pool.setFailover( true );
		pool.setInitConn( 10 );
		pool.setMaxConn( 250 );
		pool.setMaintSleep( 30 );
		pool.setNagle( false );
		pool.setSocketTO( 3000 );
		pool.setAliveCheck( true );
		pool.initialize();
		
		MemCachedClient mcc = new MemCachedClient("Test1");
		boolean output=mcc.set(newInfo.getUserID()+"",newInfo.getUsername()+","+newInfo.getPassword()+","+newInfo.getEmail()+","+newInfo.getUserType()+","+newInfo.getPhoneNum());
		logger.info("Application Server 2 : Adding the updated value of userID "+newInfo.getUserID()+" to memcached. STATUS: "+output);
		return updatedUserInfo;
}
	
	@Path("/createNewUser/")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public UserInfo createNewUser(UserInfo newInfo){
		logger.info("Application Server 2 : create new user called "+newInfo.getEmail());
		Client client=ClientBuilder.newClient();
		Response r=client.target("http://localhost:8085/GiftRegistryDBWeb/rest/registeruser").request().header("authorization","WPLblueleaf2991").post(Entity.json(newInfo));
		UserInfo newUserInfo=r.readEntity(UserInfo.class);
		return newUserInfo;
}
	
	@Path("/getprofileinformation/{userID}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public UserInfo getProfileInformation(@PathParam("userID") String userID){
		logger.info("Application Server 2 : get profile information called "+userID);
		
		String[] servers = {"localhost:11211"};
		SockIOPool pool = SockIOPool.getInstance("Test1");
		pool.setServers( servers );
		pool.setFailover( true );
		pool.setInitConn( 10 );
		pool.setMaxConn( 250 );
		pool.setMaintSleep( 30 );
		pool.setNagle( false );
		pool.setSocketTO( 3000 );
		pool.setAliveCheck( true );
		pool.initialize();
		
		MemCachedClient mcc = new MemCachedClient("Test1");
		String output=(String)mcc.get(userID);
		UserInfo uI=null;
		if(output!=null){
			String[] userInfo=output.split(",");
			uI=new UserInfo(Integer.valueOf(userID).intValue(),userInfo[0],userInfo[1],userInfo[2],Integer.valueOf(userInfo[3]).intValue(),Integer.valueOf(userInfo[4]).intValue());
		   logger.info("Cache Hit: Found the profile information of user with ID "+userID);
		}else{
		logger.info("Cache Miss: Cannot find the profile information of user with ID "+userID+" in memcached. Fetching from DB");
			
		Client client=ClientBuilder.newClient();
		Response r=client.target("http://localhost:8085/GiftRegistryDBWeb/rest/customerdetails/userID/"+userID).request().header("authorization","WPLblueleaf2991").header("userkey",new StringBuilder(userID).reverse().toString()).get();
		 uI=r.readEntity(UserInfo.class);
			boolean out=mcc.set(uI.getUserID()+"",uI.getUsername()+","+uI.getPassword()+","+uI.getEmail()+","+uI.getUserType()+","+uI.getPhoneNum());
			logger.info("Adding the value of userID "+uI.getUserID()+" to memcached. STATUS:"+out);
		}
	   return uI;
	}	
	
	@Path("/getUserInfo/{emailID}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public UserInfo getUserInfo(@PathParam("emailID") String emailID){
		logger.info("Application Server 2 : get user info called "+emailID);
		Client client=ClientBuilder.newClient();
		Response r=client.target("http://localhost:8085/GiftRegistryDBWeb/rest/customerdetails/"+emailID).request().header("authorization","WPLblueleaf2991").get();
		UserInfo validUserInfo=r.readEntity(UserInfo.class);
     return validUserInfo;
	}
	
	@Path("/forgotPassword/{emailID}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Status forgotPassword(@PathParam("emailID") String emailID){
		logger.info("Application Server 2 : forgot password called "+emailID);
		Client client=ClientBuilder.newClient();
		Response r=client.target("http://localhost:8085/GiftRegistryDBWeb/rest/customerdetails/"+emailID).request().header("authorization","WPLblueleaf2991").get();
		UserInfo validUserInfo=r.readEntity(UserInfo.class);
		Status s= new Status();
		Long phNum=validUserInfo.getPhoneNum();
		if(phNum!=0L){
		String phoneNumS="+14699703250";
		Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
		int randPassword = (new Random()).nextInt(900000) + 100000;
		validUserInfo.setPassword(randPassword+"BlueLeaf");
		
		logger.info("New password for user "+emailID+" :"+randPassword);
		
		Client client1=ClientBuilder.newClient();
		Response r1=client1.target("http://localhost:8085/GiftRegistryDBWeb/rest/customerdetails/updateInfo").request().header("authorization","WPLblueleaf2991").header("userkey", new StringBuilder(validUserInfo.getUserID()+"").reverse().toString()).post(Entity.json(validUserInfo));
		UserInfo updatedUserInfo=r1.readEntity(UserInfo.class);
		
		String[] servers = {"localhost:11211"};
		SockIOPool pool = SockIOPool.getInstance("Test1");
		pool.setServers( servers );
		pool.setFailover( true );
		pool.setInitConn( 10 );
		pool.setMaxConn( 250 );
		pool.setMaintSleep( 30 );
		pool.setNagle( false );
		pool.setSocketTO( 3000 );
		pool.setAliveCheck( true );
		pool.initialize();
		
		MemCachedClient mcc = new MemCachedClient("Test1");
		boolean output=mcc.set(updatedUserInfo.getUserID()+"",updatedUserInfo.getUsername()+","+updatedUserInfo.getPassword()+","+updatedUserInfo.getEmail()+","+updatedUserInfo.getUserType()+","+updatedUserInfo.getPhoneNum());
		logger.info("Adding the updated value of userID "+updatedUserInfo.getUserID()+" to memcached. STATUS: "+output);
		
		
	    Message message = Message.creator(new PhoneNumber(phoneNumS),
	    new PhoneNumber("+19124212920"), "Blue Leaf Gift Registry: Your new password is "+validUserInfo.getPassword()).create();
		logger.info(" Sent text message status:"+message.getErrorCode());
		s.setCode(100);
		s.setMessage("SUCCESS");
		}else{
			logger.info("Invalid user or invalid phone number, unable to reset password ");
		}
		return s;
	}
	
}
