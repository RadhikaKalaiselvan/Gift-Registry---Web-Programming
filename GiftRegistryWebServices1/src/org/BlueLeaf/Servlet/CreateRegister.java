package org.BlueLeaf.Servlet;

import java.io.IOException;
import blueleaf.giftregistry.model.Status;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.BlueLeaf.Service.CreateRegistryService;

import blueleaf.giftregistry.model.Registry;

/**
 * Servlet implementation class CreateRegister
 */
@WebServlet("/RegisterCreate")
public class CreateRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateRegister() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  
		int registryType=2; //0-private 1-public registry
	    int userID;
		int registryID=0;
		String registryName;
		
		registryName= request.getParameter("registryName");
		userID=Integer.parseInt( request.getParameter("userID"));
		//registryType= Integer.parseInt(request.getParameter("Private"));
		
		
		if(request.getParameter("Private")== null) 
			
			registryType= Integer.parseInt(request.getParameter("Public"));
		else
			registryType= Integer.parseInt(request.getParameter("Private"));
		
		
		Registry register = new Registry(registryID,registryType,userID,registryName);
		
		CreateRegistryService creaateRegister = new CreateRegistryService();
		
		Status s=creaateRegister.createregistry(register);
		
		if(s.getCode()== 100) {
			request.setAttribute("message", "Registry Created");
			request.getRequestDispatcher("CreateRegistry.jsp").forward(request, response);
			return;
			//response.sendRedirect("success.jsp");
		}
		if(s.getCode()==102) {
			
			request.setAttribute("message", "Registry Already Exists");
			request.getRequestDispatcher("CreateRegistry.jsp").forward(request, response);
			return;
			//response.sendRedirect("CreateRegistry.jsp");
		}
		
	}

}
