package org.BlueLeaf.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.BlueLeaf.Service.ChangePasswordService;

import blueleaf.giftregistry.model.Status;


@WebServlet("/ChangePassword")
public class ChangePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String userEmail ;
		userEmail= request.getParameter("emailID");
		ChangePasswordService changePasswordService = new ChangePasswordService();
		
		Status s = changePasswordService.CheckEmailID(userEmail);
		if(s.getCode()==100) {
		request.setAttribute("message", "Please enter the New Password received");
		request.getRequestDispatcher("login.jsp").forward(request, response);
		//response.sendRedirect("adminHomePage.jsp");
		return;
		}else if(s.getCode()==200) {
		request.setAttribute("message", "Failed: Most likly - Email ID Mismatch");
		request.getRequestDispatcher("login.jsp").forward(request, response);
		//response.sendRedirect("adminHomePage.jsp");
		return;
		} else {
		request.setAttribute("message", "Failed");
		request.getRequestDispatcher("login.jsp").forward(request, response);
		//response.sendRedirect("adminHomePage.jsp");
		return;
		}
		
	}

}
