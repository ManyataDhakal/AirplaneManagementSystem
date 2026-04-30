package test;

import dao.UserDAO;
import model.User;

public class TestUserDAO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		UserDAO dao = new UserDAO();
		
		//Create test user
		User user = new User();
		user.setFullName("Test User");
		user.setEmail("testuser456@gmail.com");
        user.setPhone("9800000011");
        user.setPassword("1234");
        user.setRole("Customer");
        
        // Test Register
        boolean register = dao.registerUser(user);
        System.out.println("Register: " + register);
        
        // Test LOGIN 
        User login = dao.loginUser("testuser456@gmail.com", "1234");
        
        if (login != null) {
        	System.out.println("Login success: " + login.getFullName());
        } else {
        	System.out.println("Login failed");
        }
	}

}
