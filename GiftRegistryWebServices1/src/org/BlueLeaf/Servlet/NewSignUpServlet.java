package org.BlueLeaf.Servlet;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.BlueLeaf.Service.NewSignUpService;

import blueleaf.giftregistry.model.AllUserinfo;
import blueleaf.giftregistry.model.UserInfo;

/**
 * Servlet implementation class NewSignUpServlet
 */
@WebServlet("/SignUp")
public class NewSignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String username,email ,password,repassword;
		int userType=1;
		long phonenumber;
		username= request.getParameter("username");
		email= request.getParameter("userEmail");
		password= request.getParameter("password");
		repassword= request.getParameter("repassword");
		phonenumber= Long.parseLong((request.getParameter("phonenumber")));
		
	System.out.print(phonenumber);
				
			UserInfo u=new UserInfo(username,password,email,userType,phonenumber);
		
			NewSignUpService newSignupService = new NewSignUpService();
		
		AllUserinfo result =  newSignupService.Vaidate(u); 
		
		if(result.getUserID() == 0 || !(password.equals(repassword)))
		{
			request.setAttribute("message", "Something Wrong Please Try again");
			request.getRequestDispatcher("NewSignUp.jsp").forward(request, response);
			//response.sendRedirect("NewSignUp.jsp");
			return;
		}
		else
		{	
			
			response.sendRedirect("login.jsp");
			return;
		}
	
	}
   	}
   	

