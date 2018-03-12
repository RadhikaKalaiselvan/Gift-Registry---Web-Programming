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
 * Servlet implementation class AddBuyertoregServlet
 */
@WebServlet("/AddBuyertoregServlet")
public class AddBuyertoregServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBuyertoregServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int OwneruserID=Integer.parseInt( request.getParameter("OwneruserID"));
		int RegID=Integer.parseInt( request.getParameter("RegID"));
		String buyeremailID=request.getParameter("buyeremailID");
		
		AddProduct addusertoreg = new AddProduct();
		
		Status s=addusertoreg.addusertoPrivsteReg(OwneruserID, RegID, buyeremailID);
		
if(s.getCode()==100){
			
			request.setAttribute("message", "Added User");
			request.getRequestDispatcher("AddUsertoPrivateRegistry.jsp").forward(request, response);
			//response.sendRedirect("NewSignUp.jsp");
			return;
			
		}else if(s.getCode()==200){
			
			request.setAttribute("message", "Error: UNABLE TO ADD ENTRY TO DB");
			request.getRequestDispatcher("AddUsertoPrivateRegistry.jsp").forward(request, response);
			//response.sendRedirect("NewSignUp.jsp");
			return;
			
		}else if(s.getCode()==300){
			
			request.setAttribute("message", "Error:USER DOESNOT EXITS");
			request.getRequestDispatcher("AddUsertoPrivateRegistry.jsp").forward(request, response);
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
