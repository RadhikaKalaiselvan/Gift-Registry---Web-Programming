package org.BlueLeaf.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.BlueLeaf.Service.AddProduct;

import blueleaf.giftregistry.model.Status;

/**
 * Servlet implementation class MakeRegPublis
 */
@WebServlet(name = "MakeRegPublic", urlPatterns = { "/MakeRegPublic" })
public class MakeRegPublis extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MakeRegPublis() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int RegID=Integer.parseInt( request.getParameter("RegID"));
AddProduct addusertoreg = new AddProduct();
		
		Status s=addusertoreg.makePublic(RegID);
		
			if(s.getCode()==100){
			
			request.setAttribute("message", "Registry is public now");
			request.getRequestDispatcher("makeRegistryPublic.jsp").forward(request, response);
			//response.sendRedirect("NewSignUp.jsp");
			return;
			
		}else {
			
			request.setAttribute("message", "Error: UNABLE TO ADD ENTRY TO DB");
			request.getRequestDispatcher("makeRegistryPublic.jsp").forward(request, response);
			//response.sendRedirect("NewSignUp.jsp");
			return;
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
