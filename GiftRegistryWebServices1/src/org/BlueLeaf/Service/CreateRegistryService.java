package org.BlueLeaf.Service;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;

import blueleaf.giftregistry.model.Registry;
import blueleaf.giftregistry.model.Status;
import blueleaf.giftregistry.model.UserInfo;

public class CreateRegistryService {
public Status  createregistry(Registry u) {
		
		Client client=ClientBuilder.newClient();
		
		Response r=client.target("http://localhost:9080/GiftRegistryWebServices_AppServ2/rest/registrymanagement/createRegistry").request().post(Entity.json(u));
		Status s=r.readEntity(Status.class);
		
		return s;
		
	}

}
