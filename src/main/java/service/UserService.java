package service;

import dao.UserDAO;
import model.User;

public class UserService {

    // DAO instance used to interact with user-related database operations
    private UserDAO userDAO = new UserDAO();

    // Handles user registration with basic input validation
    public boolean registerUser(User user) {

        // Validate user object
        if (user == null) {
            return false;
        }

        // Validate required fields before proceeding to database layer
        if (user.getFullName() == null || user.getFullName().trim().isEmpty()) {
            return false;
        }

        if (user.getEmail() == null || user.getEmail().trim().isEmpty()) {
            return false;
        }

        if (user.getPhone() == null || user.getPhone().trim().isEmpty()) {
            return false;
        }

        if (user.getPassword() == null || user.getPassword().trim().isEmpty()) {
            return false;
        }

        if (user.getRole() == null || user.getRole().trim().isEmpty()) {
            return false;
        }

        // Delegate persistence operation to DAO layer
        return userDAO.registerUser(user);
    }

    // Handles authentication by validating input and delegating to DAO
    public User loginUser(String email, String password) {

        // Validate credentials before querying database
        if (email == null || email.trim().isEmpty()) {
            return null;
        }

        if (password == null || password.trim().isEmpty()) {
            return null;
        }

        // Retrieve user from DAO if credentials match
        return userDAO.loginUser(email, password);
    }

    // Retrieves user details based on email
    public User getUserByEmail(String email) {

        // Validate input parameter
        if (email == null || email.trim().isEmpty()) {
            return null;
        }

        // Fetch user record via DAO layer
        return userDAO.getUserByEmail(email);
    }
}