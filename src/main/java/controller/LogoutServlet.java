package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import util.SessionUtil;

/**
 * Servlet implementation class LogoutServlet
 * This servlet handles user logout functionality
 */
@SuppressWarnings("serial")
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	/**
	 * Handles Logout request
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	     throws ServletException, IOException {
		
		// Step 1: Remove user attribute from session
		SessionUtil.removeAttribute(request,"user");
		
		// Step 2: Invalidate the session completely
		SessionUtil.invalidateSession(request);
		
		//Step 3: Redirect user back to Login page
		response.sendRedirect(request.getContextPath() + "/views/auth/login.jsp");
	}
}
