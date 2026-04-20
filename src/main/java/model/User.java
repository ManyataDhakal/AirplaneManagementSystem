package model;

import java.sql.Timestamp;

public class User {
	    private int id;
	    private String fullName;
	    private String email;
	    private String phone;
	    private String password;
	    private int roleId;
	    private Timestamp createdAt;
	    private Timestamp updatedAt;

	    public User() {
	    }

	    public User(int id, String fullName, String email, String phone, String password, int roleId,
	                Timestamp createdAt, Timestamp updatedAt) {
	        this.id = id;
	        this.fullName = fullName;
	        this.email = email;
	        this.phone = phone;
	        this.password = password;
	        this.roleId = roleId;
	        this.createdAt = createdAt;
	        this.updatedAt = updatedAt;
	    }

	    public int getId() {
	        return id;
	    }

	    public void setId(int id) {
	        this.id = id;
	    }

	    public String getFullName() {
	        return fullName;
	    }

	    public void setFullName(String fullName) {
	        this.fullName = fullName;
	    }

	    public String getEmail() {
	        return email;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }

	    public String getPhone() {
	        return phone;
	    }

	    public void setPhone(String phone) {
	        this.phone = phone;
	    }

	    public String getPassword() {
	        return password;
	    }

	    public void setPassword(String password) {
	        this.password = password;
	    }

	    public int getRoleId() {
	        return roleId;
	    }

	    public void setRoleId(int roleId) {
	        this.roleId = roleId;
	    }

	    public Timestamp getCreatedAt() {
	        return createdAt;
	    }

	    public void setCreatedAt(Timestamp createdAt) {
	        this.createdAt = createdAt;
	    }

	    public Timestamp getUpdatedAt() {
	        return updatedAt;
	    }

	    public void setUpdatedAt(Timestamp updatedAt) {
	        this.updatedAt = updatedAt;
	    }
	}
