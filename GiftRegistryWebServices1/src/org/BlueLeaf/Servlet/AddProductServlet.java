package org.BlueLeaf.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.BlueLeaf.Service.AddProduct;

import blueleaf.giftregistry.model.Product;
import blueleaf.giftregistry.model.Status;

/**
 * Servlet implementation class AddProductServlet
 */
@WebServlet("/AddProductServlet")
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int productID=Integer.parseInt( request.getParameter("ProductID"));
		int RegisterID=Integer.parseInt( request.getParameter("RegisterID"));
		
		AddProduct addtoregi = new AddProduct();
		Status s= addtoregi.AddtoRegistry(RegisterID, productID);
		
		
		
		if(s.getCode()==100){
			
			request.setAttribute("message", "Added");
			request.getRequestDispatcher("result.jsp").forward(request, response);
			//response.sendRedirect("NewSignUp.jsp");
			return;
			
		}else{
			
			request.setAttribute("message", "Error: Most likly the Product already add or invalid REGISter ID");
			request.getRequestDispatcher("result.jsp").forward(request, response);
			//response.sendRedirect("NewSignUp.jsp");
			return;
			
		}
			
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		long productID=0;
		String productName;
		float price;
		String imageURL;
		int rating;
		int certification;
		int brandID=1;
		int categoryID=1;
		String brandName="";
		String categoryName="";
		
		
		productName= request.getParameter("productName");
		price= Integer.parseInt(request.getParameter("price"));
		imageURL=  request.getParameter("imageURL");
		rating= Integer.parseInt(request.getParameter("rating"));
		certification= Integer.parseInt(request.getParameter("certification"));
		brandName= request.getParameter("brandname");
		categoryName= request.getParameter("category");
		
		Product pro = new Product( productID, productName,  price,  imageURL,  rating,  certification,
					 brandID,  categoryID,  brandName,  categoryName);
		
		AddProduct addProduct = new AddProduct();
		
		Status s =addProduct.addProduct(pro);
		
		if(s.getCode()== 100) {
			
			request.setAttribute("message", "Added");
			request.getRequestDispatcher("AddProduct.jsp").forward(request, response);
			return;
			}else
			{
				request.setAttribute("message", "Failed");
				request.getRequestDispatcher("AddProduct.jsp").forward(request, response);
				return;
				
			}	
		
		
	}

}
