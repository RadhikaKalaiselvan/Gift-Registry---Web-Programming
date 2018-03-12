package blueleaf.giftregistry.services;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
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
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import blueleaf.giftregistry.model.Registry;
import blueleaf.giftregistry.model.Status;
import blueleaf.giftregistry.model.UserInfo;

@Path("/registrymanagement")
public class RegistryManagementService {

	private final static Logger logger = Logger.getLogger(RegistryManagementService.class.getName());
	
	
	@Path("/getallregistry/{userID}")
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	public List<Registry> getUser(@PathParam("userID") String userID) {
		logger.info("Application Server 2 : get all registries of called userID:"+userID);
		Client client=ClientBuilder.newClient();
		Response r=client.target("http://localhost:8085/GiftRegistryDBWeb/rest/registrymanagement/getallregistry/"+userID).request(MediaType.APPLICATION_JSON).header("authorization","WPLblueleaf2991").header("userkey",new StringBuilder(userID).reverse().toString()).get(Response.class);
		
		List<Registry> list =r.readEntity(new GenericType<List<Registry>>() {
        });
		List<Registry> lr=new LinkedList<Registry>();
		for(Registry rg:list)
		{
			lr.add(rg);
		}
        return lr;
	}
	
	
	@Path("/createRegistry/")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Status createNewRegistry(Registry newR){
		logger.info("Application Server 2 : create new registry called. Registry name:"+newR.getRegistryName());
		
		Status s=new Status();
		Client client=ClientBuilder.newClient();
		Response r=client.target("http://localhost:8085/GiftRegistryDBWeb/rest/registrymanagement/getallregistry/"+newR.getUserID()).request(MediaType.APPLICATION_JSON).header("authorization","WPLblueleaf2991").header("userkey",new StringBuilder(newR.getUserID()+"").reverse().toString()).get(Response.class);
		List<Registry> list =r.readEntity(new GenericType<List<Registry>>() {
        });
		HashSet<String> h=new HashSet<String>();
		if(list!=null){
		for(Registry registry: list){
			h.add(registry.getRegistryName());
		}
		if(h.contains(newR.getRegistryName())){
			s.setCode(102);
			s.setMessage("Registry already exits");
            return s;
		}
		}
		Response r1=client.target("http://localhost:8085/GiftRegistryDBWeb/rest/registrymanagement/add").request().header("authorization","WPLblueleaf2991").header("userkey",new StringBuilder(newR.getUserID()+"").reverse().toString()).post(Entity.json(newR));
		Registry updatedR=r1.readEntity(Registry.class);
		if(updatedR.getRegistryID()!=0){
			s.setCode(100);
			s.setMessage("SUCCESS");
		}
		return s;
}
	
	@Path("/delete/{registryID}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Status deleteRegistry(@PathParam("registryID") String registryID){
		logger.info("Application Server 2 : delete registry called :"+registryID);
		Client client=ClientBuilder.newClient();
		Response r=client.target("http://localhost:8085/GiftRegistryDBWeb/rest/registrymanagement/delete/"+registryID).request(MediaType.APPLICATION_JSON).header("authorization","WPLblueleaf2991").get(Response.class);		
		Status s=r.readEntity(Status.class);
        return s;
	}
	
	
	@Path("/makepublic/{registryID}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Status makeRegistryPublic(@PathParam("registryID") String registryID){
		logger.info("Application Server 2 : mark registry as public called for :"+registryID);
		Status final_s=new Status();
		Client client=ClientBuilder.newClient();
		Response r=client.target("http://localhost:8085/GiftRegistryDBWeb/rest/registryproductmapper/markregistrypublic/"+registryID).request(MediaType.APPLICATION_JSON).header("authorization","WPLblueleaf2991").get(Response.class);		
		Status s=r.readEntity(Status.class);
		final_s.setCode(101);
		final_s.setMessage("Marked registry as public");
		if(s.getCode()==100){
			
			Response r1=client.target("http://localhost:8085/GiftRegistryDBWeb/rest/registryproductmapper/deleteallprivateregistrymapping/"+registryID).request(MediaType.APPLICATION_JSON).header("authorization","WPLblueleaf2991").get(Response.class);		
			Status s1=r1.readEntity(Status.class);
			if(s1.getCode()==100){
				final_s.setCode(100);
				final_s.setMessage("SUCCESS");
			}
			
		}	
        return final_s;
	}
	
	
	@Path("/getallsharedregistry/{userID}")
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	public List<Registry> getAllSharedRegistries(@PathParam("userID") String userID) {
		logger.info("Application Server 2 : get all shared registries of called userID:"+userID);
		Client client=ClientBuilder.newClient();
		Response r=client.target("http://localhost:8085/GiftRegistryDBWeb/rest/registryproductmapper/getallsharedregistries/"+userID).request(MediaType.APPLICATION_JSON).header("authorization","WPLblueleaf2991").header("userkey",new StringBuilder(userID).reverse().toString()).get(Response.class);
		
		List<Registry> list =r.readEntity(new GenericType<List<Registry>>() {
        });
		List<Registry> lr=new LinkedList<Registry>();
		for(Registry rg:list)
		{
			lr.add(rg);
		}
        return lr;
	}
	

}
