package org.BlueLeaf.Service;

import java.util.LinkedList;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

import blueleaf.giftregistry.model.Product;
import blueleaf.giftregistry.model.Registry;

public class ProductList {

	
public List<Product>  getProduct() {
		
		Client client=ClientBuilder.newClient();
		
		Response r=client.target("http://localhost:9080/GiftRegistryWebServices_AppServ2/rest/productmangement/getallproducts/").request().get();
		
		List<Product> list =r.readEntity(new GenericType<List<Product>>() {
        });
		List<Product> lr=new LinkedList<Product>();
		for(Product rg:list)
		{
			lr.add(rg);
		}
        return lr;
		
	}

public List<Product>  getProductofSharedID(String u) {
	
	Client client=ClientBuilder.newClient();
	
	Response r=client.target("http://localhost:9080/GiftRegistryWebServices_AppServ2/rest/productregistrymangement/getProductsFromRegistry/"+u).request().get();
	
	List<Product> list =r.readEntity(new GenericType<List<Product>>() {
    });
	List<Product> lr=new LinkedList<Product>();
	for(Product rg:list)
	{
		lr.add(rg);
	}
    return lr;
	
}

public List<Product>  getuserProduct(String rid) {
	
	Client client=ClientBuilder.newClient();
	
	Response r=client.target("http://localhost:9080/GiftRegistryWebServices_AppServ2/rest/productregistrymangement/getProductsFromRegistry/"+rid).request().get();
	
	List<Product> list =r.readEntity(new GenericType<List<Product>>() {
    });
	List<Product> lr=new LinkedList<Product>();
	for(Product rg:list)
	{
		lr.add(rg);
	}
    return lr;
	
}
}
