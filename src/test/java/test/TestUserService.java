package test;

import model.User;
import service.UserService;

public class TestUserService {

    public static void main(String[] args) {

        // create service object to test service layer methods
        UserService service = new UserService();

        // create new user object and set values
        User user = new User();
        user.setFullName("Service Test User");
        user.setEmail("servicetest@gmail.com"); // use new email if duplicate
        user.setPhone("9800000088");
        user.setPassword("1234");
        user.setRole("Customer");

        // call register method from service
        boolean registered = service.registerUser(user);

        // display registration result
        System.out.println("Register: " + registered);


        // call login method using same email and password
        User login = service.loginUser("servicetest@gmail.com", "1234");

        // check if login successful
        if (login != null) {
            System.out.println("Login success: " + login.getFullName());
        } else {
            System.out.println("Login failed");
        }


        // fetch user by email
        User foundUser = service.getUserByEmail("servicetest@gmail.com");

        // check if user exists in database
        if (foundUser != null) {
            System.out.println("User found: " + foundUser.getEmail());
        } else {
            System.out.println("User not found");
        }
    }
}