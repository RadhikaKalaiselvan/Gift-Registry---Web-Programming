package org.BlueLeaf.Service;

import java.util.Objects;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;

import blueleaf.giftregistry.model.AllUserinfo;
import blueleaf.giftregistry.model.Status;
import blueleaf.giftregistry.model.UserInfo;

public class NewSignUpService {
	
public AllUserinfo  Vaidate(UserInfo u) {
		
	Client client=ClientBuilder.newClient();
	
	Response r=client.target("http://localhost:9080/GiftRegistryWebServices_AppServ2/rest/usermanagementservice/createNewUser").request().post(Entity.json(u));
	AllUserinfo s=r.readEntity(AllUserinfo.class);
	
	return s;
			
		
	}

}
