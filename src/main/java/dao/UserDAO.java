package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.User;
import util.DBConfig;

public class UserDAO {
	
	// Insert new user into database (REGISTER)
	public boolean registerUser(User user) {
		
		// SQL query to insert user data
		String query = "INSERT INTO users(full_name, email, phone, password, role) VALUES (?, ?, ?, ?, ?)";
		
		try (
				// Get database connection
				Connection conn = DBConfig.getConnection();
				
				// Prepare SQL statement
				PreparedStatement ps = conn.prepareStatement(query)
			) {
			
			     // Set values from user object into query
			     ps.setString(1, user.getFullName());
			     ps.setString(2, user.getEmail());
			     ps.setString(3, user.getPhone());
			     ps.setString(4, user.getPassword());
			     ps.setString(5, user.getRole());
			     
			     // Execute query
			     int rows = ps.executeUpdate();
			     
			     //If rows inserted 
			     return rows > 0;	
		} catch (Exception e) {
			e.printStackTrace();	
		}
		return false;
		
	}
	
	// Check user Login (LOGIN)
	public User loginUser(String email, String password) {
		
		// SQL query to check email and password
		String query = "SELECT * FROM users WHERE email = ? AND password = ?";
		
		try (
			Connection conn = DBConfig.getConnection();
			PreparedStatement ps = conn.prepareStatement(query)
			){
			
			   // Set email and password
			   ps.setString(1, email);
			   ps.setString(2,  password);
			   
			   // Execute SELECT query
			   ResultSet rs = ps.executeQuery();
			   
			   //If user found
			   if (rs.next()) {
				   
				   //Create User object and store data
				   User user = new User();
				   user.setId(rs.getInt("id"));
				   user.setFullName(rs.getString("full_name"));
				   user.setEmail(rs.getString("email"));
				   user.setPhone(rs.getString("phone"));
				   user.setPassword(rs.getString("password"));
				   user.setRole(rs.getString("role"));
				   
			          return user;
			   }	   	   
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		 return null;
	}
	
	// Get user by email
	public User getUserByEmail(String email) {
		
		String query = "SELECT * FROM users WHERE email = ?";
		
		try (
			Connection conn = DBConfig.getConnection();
			PreparedStatement ps = conn.prepareStatement(query)
			) {
				
				ps.setString(1,  email);
				ResultSet rs = ps.executeQuery();
				
				if (rs.next()) {
					User user = new User();
					user.setId(rs.getInt("id"));
					user.setFullName(rs.getString("full_name"));
					user.setEmail(rs.getString("email"));
					user.setPhone(rs.getString("phone"));
					user.setPassword(rs.getString("password"));
					user.setRole(rs.getString("role"));
					return user;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return null;
	    }
	      
	}
