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
import blueleaf.giftregistry.model.Product;


@Path("/selfassignedproductsservice")
public class SelfAssignedProductsService {
	@Path("/getassignedproducts/{registryID}/{buyerUserID}")
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	public List<Product> getAssignedProducts(@Context HttpHeaders httpHeader,@PathParam("registryID") int regID,@PathParam("buyerUserID") String buyerUserID) {
		String apiKey = (httpHeader.getRequestHeader("authorization")==null)?null:httpHeader.getRequestHeader("authorization").get(0);
		String authKey=(httpHeader.getRequestHeader("userkey")==null)?null:httpHeader.getRequestHeader("userkey").get(0);
		if("WPLblueleaf2991".equals(apiKey)  && authKey!=null && authKey.equals(new StringBuilder(buyerUserID).reverse().toString())){
		DBConnector db=new DBConnector();
		Connection con=db.getConnection();
		List<Product> lp=db.getAssignedProduct(con,regID,buyerUserID);
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return lp;	
		}else{
			return null;
		}
	}
}
