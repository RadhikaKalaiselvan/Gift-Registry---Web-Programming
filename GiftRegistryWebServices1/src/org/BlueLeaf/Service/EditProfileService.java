package org.BlueLeaf.Service;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;

import blueleaf.giftregistry.model.AllUserinfo;
import blueleaf.giftregistry.model.Status;
import blueleaf.giftregistry.model.UserInfo;

public class EditProfileService {
	
public UserInfo  UpdateUser(AllUserinfo u) {
		
		Client client=ClientBuilder.newClient();
		
		Response r=client.target("http://localhost:9080/GiftRegistryWebServices_AppServ2/rest/usermanagementservice/updateUserProfileInfo/").request().post(Entity.json(u));
		UserInfo s=r.readEntity(UserInfo.class);
		
		return s;
		
	}

}
