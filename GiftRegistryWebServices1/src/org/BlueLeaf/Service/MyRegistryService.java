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

public class MyRegistryService {
	
public List<Registry>  getregistries(long userID) {
		
		Client client=ClientBuilder.newClient();
		
		Response r=client.target("http://localhost:9080/GiftRegistryWebServices_AppServ2/rest/registrymanagement/getallregistry/"+userID).request().get();
		
		List<Registry> list =r.readEntity(new GenericType<List<Registry>>() {
        });
		List<Registry> lr=new LinkedList<Registry>();
		for(Registry rg:list)
		{
			lr.add(rg);
		}
        return lr;
		
	}

public List<Registry>  getSharedregistries(long userID) {
	
	Client client=ClientBuilder.newClient();
	
	Response r=client.target("http://localhost:9080/GiftRegistryWebServices_AppServ2/rest/registrymanagement/getallsharedregistry/" +userID).request().get();
	
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
