package org.BlueLeaf.Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.BlueLeaf.Service.LoginService;

import blueleaf.giftregistry.model.AllUserinfo;
import blueleaf.giftregistry.model.Status;
import blueleaf.giftregistry.model.UserInfo;
import javax.ws.rs.*;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String password;
		//long userID;
		String username;
		
		String email;
		int userType;
		long phoneNum;
		
		email= request.getParameter("email");
		password= request.getParameter("password");
		phoneNum = 0;
		userType=0;
		username="";
		
		UserInfo u=new UserInfo(username,password,email,userType,phoneNum);
		
		HttpSession session = request.getSession();
		
		
		
		
	LoginService loginService = new LoginService();
	Status s=  loginService.authenticate(u);
		
		if(s.getCode()==100) {
			//Admin
			session.setAttribute("Semail", email);
			session.setAttribute("Spassword", password);
			response.sendRedirect("adminHomePage.jsp");
			return;
		}else 
		if(s.getCode()==110) {
			//Customer	
			session.setAttribute("Semail", email);
			session.setAttribute("Spassword", password);
			Client client=ClientBuilder.newClient();
			Response r= client.target("http://localhost:9080/GiftRegistryWebServices_AppServ2/rest/usermanagementservice/getUserInfo/"+email).request().get();
			UserInfo userinfo=r.readEntity(UserInfo.class);
			request.setAttribute("userinfo", userinfo);
			session.setAttribute("SuserID", userinfo.getUserID());
			session.setAttribute("SUname", userinfo.getUsername());
			session.setAttribute("Sphonenum", userinfo.getPhoneNum());
			RequestDispatcher dispacter = request.getRequestDispatcher("success.jsp");
			dispacter.forward(request, response);
//			RequestDispatcher dispacter1 = request.getRequestDispatcher("EditProfile.jsp");
//			dispacter.forward(request, response);
			//response.sendRedirect("success.jsp");
			return;
		}else
			if(s.getCode()==103) {
				//User Doesn't Exist
				//response.sendRedirect("login.jsp");
				request.setAttribute("message", "User Doesn't exist");
				request.getRequestDispatcher("login.jsp").forward(request, response);
				return;
				
				
			}else 
				if(s.getCode()==104) {
					//Invalid Password
					//response.sendRedirect("login.jsp");
					request.setAttribute("message", "Invalid Password");
					request.getRequestDispatcher("login.jsp").forward(request, response);
					return;
					
				}
		
		}
		
	}

