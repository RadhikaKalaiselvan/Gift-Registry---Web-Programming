package org.BlueLeaf.Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.BlueLeaf.Service.ProductList;

import blueleaf.giftregistry.model.Product;

/**
 * Servlet implementation class ProductsofSharedRegistry
 */
@WebServlet("/ProductsofSharedRegistry")
public class ProductsofSharedRegistry extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductsofSharedRegistry() {
        super();
        // TODO Auto-generated constructor stub
    }
    String SharedRegistryIDmain;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String SharedRegistryID = request.getParameter("Rid");
		
		ProductList myProduct = new ProductList();
	
		List<Product> lr= myProduct.getProductofSharedID(SharedRegistryID);
		

		request.setAttribute("SharedRegistryID", SharedRegistryID);
		request.setAttribute("sharedRegistryProduct", lr);
		RequestDispatcher dispacter = request.getRequestDispatcher("productsofSharedRegistry.jsp");
		dispacter.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
