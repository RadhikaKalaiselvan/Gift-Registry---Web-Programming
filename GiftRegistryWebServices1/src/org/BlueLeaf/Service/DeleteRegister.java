package org.BlueLeaf.Service;

import java.util.LinkedList;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

import blueleaf.giftregistry.model.Registry;
import blueleaf.giftregistry.model.Status;
import blueleaf.giftregistry.model.UserInfo;

public class DeleteRegister {

		
		public Status  del(int u) {
			
			Client client=ClientBuilder.newClient();
			
			Response r=client.target("http://localhost:9080/GiftRegistryWebServices_AppServ2/rest/registrymanagement/delete/"+u).request().get();
			Status s=r.readEntity(Status.class);
			
			return s;
			
		}
}

