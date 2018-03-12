package org.BlueLeaf.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import blueleaf.giftregistry.model.Status;

import org.BlueLeaf.Service.DeleteRegister;

/**
 * Servlet implementation class DeleteRegistry
 */
@WebServlet("/DeleteRegistry")
public class DeleteRegistry extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteRegistry() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		int registryID;
		registryID= Integer.parseInt(request.getParameter("Rid"));
		
		DeleteRegister del = new DeleteRegister();
		Status s =    del.del(registryID);
		
		if(s.getCode()==100) {
			
			request.setAttribute("message", "Deleted");
			request.getRequestDispatcher("ExistingRegistry.jsp").forward(request, response);
			return;
			
		}else
		{
			request.setAttribute("message", "Failed");
			request.getRequestDispatcher("ExistingRegistry.jsp").forward(request, response);
			return;
			
		}		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
	}

}
