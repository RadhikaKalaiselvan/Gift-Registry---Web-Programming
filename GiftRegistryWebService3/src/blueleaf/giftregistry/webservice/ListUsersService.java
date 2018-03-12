package blueleaf.giftregistry.webservice;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

import blueleaf.giftregistry.model.UserInfo;
import blueleaf.giftregistry.services.UserInfoService;

@Path("/listusersservice")
public class ListUsersService {
UserInfoService us=new UserInfoService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<UserInfo> getAllUsers(@Context HttpHeaders httpHeader,@QueryParam("name") String name)
	{
		String apiKey = (httpHeader.getRequestHeader("authorization")==null)?null:httpHeader.getRequestHeader("authorization").get(0);
		if("WPLblueleaf2991".equals(apiKey)){
	   return us.getAllUsers();
		}
		return null;
	}
}
