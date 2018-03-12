package org.BlueLeaf.Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;
import javax.xml.bind.ParseConversionEvent;

import org.BlueLeaf.Service.EditProfileService;

import blueleaf.giftregistry.model.AllUserinfo;
import blueleaf.giftregistry.model.UserInfo;

import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class EditProfile
 */
@WebServlet("/EditProfile")
public class EditProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditProfile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		long userID;
		String username;
		String password;
		String email;
		int userType=1;
		long phoneNum;
		
		email= request.getParameter("email"); 
		username= request.getParameter("username");
		phoneNum= Long.parseLong(request.getParameter("phonenum"));
		password=  request.getParameter("password");
		userID=  (long) request.getSession().getAttribute("SuserID");
		
		AllUserinfo user = new AllUserinfo( userID,username, password, email, userType,phoneNum);
		
		EditProfileService editpro = new EditProfileService();
		UserInfo userupdated = editpro.UpdateUser(user);
		
		//if(userupdated == user) {
			request.setAttribute("message", "Updated");
			request.getRequestDispatcher("EditProfile.jsp").forward(request, response);
//			request.setAttribute("userinfo", userupdated);
//			RequestDispatcher dispacter = request.getRequestDispatcher("success.jsp");
//			dispacter.forward(request, response);
//			request.setAttribute("userupdated", userupdated);
//			
			return;
		//}
		
	}

}
