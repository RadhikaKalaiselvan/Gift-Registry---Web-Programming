package org.BlueLeaf.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.BlueLeaf.Service.DeleteProductService;
import org.BlueLeaf.Service.DeleteRegister;

import blueleaf.giftregistry.model.Status;

/**
 * Servlet implementation class DeleteProductServlet
 */
@WebServlet("/DeleteProduct")
public class DeleteProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int productID;
		productID= Integer.parseInt(request.getParameter("Pid"));
		
		DeleteProductService del = new DeleteProductService();
		Status s =    del.del(productID);
		
		if(s.getCode()==100) {
			
//			request.setAttribute("message", "Deleted");
//			request.getRequestDispatcher("/Wpl-Final-Project/WebContent/adminHomePage.jsp").forward(request, response);
			response.sendRedirect("adminHomePage.jsp");
			return;
			
		}else if(s.getCode()==200)		{
//			request.setAttribute("message", "Failed");
//			request.getRequestDispatcher("/Wpl-Final-Project/WebContent/adminHomePage.jsp").forward(request, response);
//			
			response.sendRedirect("adminHomePage.jsp");
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
