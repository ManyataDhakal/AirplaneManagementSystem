package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;
import service.UserService;
import util.SessionUtil;

/**
 * Servlet implementation class LoginServlet
 * This servlet handles user login functionality
 */
@SuppressWarnings("serial")
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	// Service object for login logic
	private UserService userService = new UserService();
	
	/**
	 * Handles POST request from login form
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	          throws ServletException, IOException {
		
		// Step 1: Get form data from login.jsp
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		// Step 2: Call service layer to validate user
		User user = userService.loginUser(email,  password);
		
		// Step 3: If login successful
		if (user != null) {
			
			// Store user in session using SessionUtil
			SessionUtil.setAttribute(request, "user", user);
			
			// Step 4: Redirect based on user role
			if (user.getRole().equals("Admin")) {
				response.sendRedirect(request.getContextPath() + "/views/admin/dashboard.jsp");
				
			} else if (user.getRole().equals("Receptionist")) {
				response.sendRedirect(request.getContextPath() + "/views/receptionist/dashboard.jsp");
				
			} else {
				response.sendRedirect(request.getContextPath() + "/views/customer/dashboard.jsp");
			}
			
		} else {
			// Step 5: If login fails, show error message
			request.setAttribute("error","Invalid email or password");
			request.getRequestDispatcher("/views/auth/login.jsp").forward(request, response);
		}
	}
	
	/**
	 * Handles GET request
	 * Redirects user to login page
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	       throws ServletException, IOException {
		
		response.sendRedirect(request.getContextPath() + "/views/auth/login.jsp");
	}
}
