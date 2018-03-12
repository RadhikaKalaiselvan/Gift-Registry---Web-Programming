package org.BlueLeaf.Service;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;

import blueleaf.giftregistry.model.Product;
import blueleaf.giftregistry.model.Status;


public class AddProduct {
	
	
public Status  addProduct(Product u) {
		
		Client client=ClientBuilder.newClient();
		
		Response r=client.target("http://localhost:9080/GiftRegistryWebServices_AppServ2/rest/productmangement/addProduct/").request().post(Entity.json(u));
		Status s=r.readEntity(Status.class);
		
		return s;
		
	}
public Status  SelfAssignProduct(String RegistryID, String ProductID,long BuyerUserID) {
	
	Client client=ClientBuilder.newClient();
	
	Response r=client.target("http://localhost:9080/GiftRegistryWebServices_AppServ2/rest/productregistrymangement/buyerMapping/"+RegistryID+"/"+ProductID+"/"+BuyerUserID).request().get();
	Status s=r.readEntity(Status.class);
	
	return s;
	
}

public Status  AddtoRegistry(int RegistryID, int ProductID) {
	
	Client client=ClientBuilder.newClient();
	
	Response r=client.target("http://localhost:9080/GiftRegistryWebServices_AppServ2/rest/productregistrymangement/addProductToRegistry/"+RegistryID+"/"+ProductID).request().get();
	Status s=r.readEntity(Status.class);
	
	return s;
	
}

public Status  addusertoPrivsteReg(int OwneruserID, int RegID,String buyeremailID) {
	
	Client client=ClientBuilder.newClient();
	
	Response r=client.target("http://localhost:9080/GiftRegistryWebServices_AppServ2/rest/registrysharingservice/shareprivateregistry/"+RegID+"/"+OwneruserID+"/"+buyeremailID).request().get();
	Status s=r.readEntity(Status.class);
	
	return s;
	
}

public Status  makePublic(int RegID) {
	
	Client client=ClientBuilder.newClient();
	
	Response r=client.target("http://localhost:9080/GiftRegistryWebServices_AppServ2/rest/registrymanagement/makepublic/"+RegID).request().get();
	Status s=r.readEntity(Status.class);
	
	return s;
	
}

}
