package blueleaf.giftregistry.webservice;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

import blueleaf.giftregistry.DbAccess.DBConnector;
import blueleaf.giftregistry.model.Status;

@Path("/buyerproductmapper")
public class BuyerProductMappingSerive {
	
	@Path("/assignproduct/{registryID}/{productID}/{buyerUserID}")
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	public Status assignProduct(@Context HttpHeaders httpHeader,@PathParam("registryID") int regID,@PathParam("productID") int productID,@PathParam("buyerUserID") String buyerUserID) {
		Status s=new Status();
		String apiKey = (httpHeader.getRequestHeader("authorization")==null)?null:httpHeader.getRequestHeader("authorization").get(0);
		String authKey=(httpHeader.getRequestHeader("userkey")==null)?null:httpHeader.getRequestHeader("userkey").get(0);
		if("WPLblueleaf2991".equals(apiKey) && authKey!=null && authKey.equals(new StringBuilder(buyerUserID).reverse().toString())){
		DBConnector db=new DBConnector();
		Connection con=db.getConnection();
		boolean b=db.assignProduct(con,regID,productID,buyerUserID);
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(b){
			s.setCode(100);
			s.setMessage("SUCCESS");
		}}
		else{
			s.setMessage("Invalid Key");
		}
		return s;		
	}
	
	
	@Path("/isproductassigned/{registryID}/{productID}")
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	public Status checkProductAssigned(@Context HttpHeaders httpHeader,@PathParam("registryID") int regID,@PathParam("productID") int productID) {
		Status s=new Status();
		String apiKey = (httpHeader.getRequestHeader("authorization")==null)?null:httpHeader.getRequestHeader("authorization").get(0);
		if("WPLblueleaf2991".equals(apiKey)){
		DBConnector db=new DBConnector();
		Connection con=db.getConnection();
		boolean b=db.isProductAssigned(con,regID,productID);
		System.out.println("Is product assigned ?"+b);
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(b){
			s.setCode(333);
			s.setMessage("Product Assigned");
		}
		}else{
			s.setMessage("Invalid Key");
		}
		return s;
		
	}
	
	
	
}
