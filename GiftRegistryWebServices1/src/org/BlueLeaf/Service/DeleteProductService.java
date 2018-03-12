package org.BlueLeaf.Service;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;

import blueleaf.giftregistry.model.Status;

public class DeleteProductService {
	
	public Status  del(int u) {
		
		Client client=ClientBuilder.newClient();
		
		Response r=client.target("http://localhost:9080/GiftRegistryWebServices_AppServ2/rest/productmangement/deleteProduct/"+u).request().get();
		Status s=r.readEntity(Status.class);
		
		return s;
		
	}

}
