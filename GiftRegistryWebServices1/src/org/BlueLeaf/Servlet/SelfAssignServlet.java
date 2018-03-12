package org.BlueLeaf.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.BlueLeaf.Service.AddProduct;

import blueleaf.giftregistry.model.Status;

/**
 * Servlet implementation class SelfAssignServlet
 */
@WebServlet("/SelfAssign")
public class SelfAssignServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelfAssignServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String RegistryID,ProductID;
		long  BuyerUserID;
		RegistryID = request.getParameter("RegisterID");
		ProductID =	request.getParameter("ProductID");
		HttpSession session = request.getSession();
		BuyerUserID = (long)	session.getAttribute("SuserID");
		
		AddProduct selfassign= new AddProduct(); 
		Status s=selfassign.SelfAssignProduct(RegistryID, ProductID, BuyerUserID);
		
		 if(s.getCode()==100)
		 {
			 request.setAttribute("message", "Product Self Assigned");
				request.getRequestDispatcher("ExistingRegistry.jsp").forward(request, response);
				return;
//					response.sendRedirect("ExistingRegistry.jsp");
//					return;
				
		 }else
		 {
			 request.setAttribute("message", "Error occured, Likly that product already added");
				request.getRequestDispatcher("ExistingRegistry.jsp").forward(request, response);
				return;
//			 	response.sendRedirect("ExistingRegistry.jsp");
//				return;
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
