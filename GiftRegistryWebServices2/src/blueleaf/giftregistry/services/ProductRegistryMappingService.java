package blueleaf.giftregistry.services;

import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import blueleaf.giftregistry.model.Product;
import blueleaf.giftregistry.model.Status;

@Path("/productregistrymangement")
public class ProductRegistryMappingService {

	private final static Logger logger = Logger.getLogger(ProductRegistryMappingService.class.getName());
	
	@Path("/addProductToRegistry/{registryID}/{productID}")
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	public Status addProductToRegistry(@PathParam("registryID") String registryID,@PathParam("productID") String productID) {
		logger.info("Application Server 2 : add product to registry called rID:"+registryID+" pID:"+productID);
		Client client=ClientBuilder.newClient();
		Response r=client.target("http://localhost:8085/GiftRegistryDBWeb/rest/registryproductmapper/addproduct/"+registryID+"/"+productID).request(MediaType.APPLICATION_JSON).header("authorization","WPLblueleaf2991").header("userkey",registryID+""+productID).get(Response.class);		
		Status s=r.readEntity(Status.class);
        return s;
	}
	
	@Path("/deleteProductFromRegistry/{registryID}/{productID}")
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	public Status deleteProductFromRegistry(@PathParam("registryID") String registryID,@PathParam("productID") String productID) {
		logger.info("Application Server 2 : delete product from registry called rID:"+registryID+" pID:"+productID);
		Client client=ClientBuilder.newClient();
		Response r=client.target("http://localhost:8085/GiftRegistryDBWeb/rest/registryproductmapper/deleteproduct/"+registryID+"/"+productID).request(MediaType.APPLICATION_JSON).header("authorization","WPLblueleaf2991").header("userkey",registryID+""+productID).get(Response.class);		
		Status s=r.readEntity(Status.class);
        return s;
	}
	
	@Path("/getProductsFromRegistry/{registryID}")
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	public List<Product> getProductsFromRegistry(@PathParam("registryID") String registryID) {
		logger.info("Application Server 2 : get products from registry called rID:"+registryID);
		Client client=ClientBuilder.newClient();
		Response r=client.target("http://localhost:8085/GiftRegistryDBWeb/rest/registryproductmapper/allproducts/"+registryID).request(MediaType.APPLICATION_JSON).header("authorization","WPLblueleaf2991").header("userkey",new StringBuilder(registryID+"").reverse().toString()).get(Response.class);	
		List<Product> list =r.readEntity(new GenericType<List<Product>>() {
        });
		List<Product> lp=new LinkedList<Product>();
		for(Product p:list)
		{
			lp.add(p);
		}
        return lp;
	}
	
	@Path("/buyerMapping/{registryID}/{productID}/{buyerUserID}")
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	public Status addBuyerMapping(@PathParam("registryID") int regID,@PathParam("productID") int productID,@PathParam("buyerUserID") String buyerUserID) {
		logger.info("Application Server 2 : self assign product from registry called rID:"+regID+" pID:"+productID);
		Client client=ClientBuilder.newClient();
		Status s=new Status();
		Response r1=client.target("http://localhost:8085/GiftRegistryDBWeb/rest/buyerproductmapper/isproductassigned/"+regID+"/"+productID).request(MediaType.APPLICATION_JSON).header("authorization","WPLblueleaf2991").get(Response.class);		
		Status s1=r1.readEntity(Status.class);
		logger.info("Is product already assigned "+s1.getMessage()+" "+s1.getCode());
		if(s1.getCode()!=333){
		Response r=client.target("http://localhost:8085/GiftRegistryDBWeb/rest/buyerproductmapper/assignproduct/"+regID+"/"+productID+"/"+buyerUserID).request(MediaType.APPLICATION_JSON).header("authorization","WPLblueleaf2991").header("userkey",new StringBuilder(buyerUserID).reverse().toString()).get(Response.class);		
		 s=r.readEntity(Status.class);
		}else{
			s.setCode(200);
            s.setMessage("Product already assigned");
		}
        return s;
	}
	
	@Path("/getProductsAssignedToSelf/{registryID}/{buyerUserID}")
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	public List<Product> getProductsFromRegistry(@PathParam("registryID") String registryID,@PathParam("buyerUserID") String buyerUserID) {
		Client client=ClientBuilder.newClient();
		logger.info("Application Server 2 : get products from registry called rID:"+registryID);
		Response r=client.target("http://localhost:8085/GiftRegistryDBWeb/rest/selfassignedproductsservice/getassignedproducts/"+registryID+"/"+buyerUserID).request(MediaType.APPLICATION_JSON).header("authorization","WPLblueleaf2991").header("userkey",new StringBuilder(buyerUserID).reverse().toString()).get(Response.class);	
		List<Product> list =r.readEntity(new GenericType<List<Product>>() {
        });
		List<Product> lp=new LinkedList<Product>();
		for(Product p:list)
		{
			lp.add(p);
		}
        return lp;
	}
	
}
