package org.BlueLeaf.Service;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;

import blueleaf.giftregistry.model.Status;

public class ChangePasswordService {
	
	public Status  CheckEmailID(String userEmail) {
		
		
		Client client=ClientBuilder.newClient();
		
		Response r=client.target("http://localhost:9080/GiftRegistryWebServices_AppServ2/rest/usermanagementservice/forgotPassword/"+userEmail).request().get();
		Status s=r.readEntity(Status.class);
		
		return s;

	
}

}
