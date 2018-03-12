package org.BlueLeaf.Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.BlueLeaf.Service.ProductList;

import blueleaf.giftregistry.model.Product;

/**
 * Servlet implementation class userProductlist
 */
@WebServlet("/userProductlist")
public class userProductlist extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public userProductlist() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String RegisterID= request.getParameter("Rid");
		
		ProductList prolist = new ProductList();
		
		List<Product> lr=prolist.getuserProduct(RegisterID);
		
		request.setAttribute("myProduct", lr);
		RequestDispatcher dispacter = request.getRequestDispatcher("userRegProductList.jsp");
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