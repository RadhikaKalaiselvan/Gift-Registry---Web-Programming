package org.BlueLeaf.Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.BlueLeaf.Service.MyRegistryService;

import blueleaf.giftregistry.model.Registry;

/**
 * Servlet implementation class myRegistryServlet
 */
@WebServlet("/myRegistryServlet")
public class myRegistryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public myRegistryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		long userID;
		
		userID= (long) request.getSession().getAttribute("SuserID");
		
		MyRegistryService myregistries = new MyRegistryService();
		
		List<Registry> lr=myregistries.getregistries(userID);
		
		request.setAttribute("myregistries", lr);
		RequestDispatcher dispacter = request.getRequestDispatcher("MyRegistry.jsp");
		dispacter.forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
	}

}
