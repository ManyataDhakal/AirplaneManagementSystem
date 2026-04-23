package model;

import java.sql.Timestamp;

public class Aeroplane {
	private int id;
	private String aeroplaneName;
	private String model;
	private int capacity;
	private String status;
	private Timestamp createdAt;
	private Timestamp updatedAt;
	
	public Aeroplane() {
	}
		public Aeroplane(int id, String aeroplaneName, String model, int capacity, String status, Timestamp createdAt, Timestamp updatedAt) {
		this.id = id;
		this.aeroplaneName = aeroplaneName;
		this.model = model;
		this.capacity = capacity;
		this.status = status;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		}
		
		// Getters and Setters
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		
		public String getAeroplaneName() {
			return aeroplaneName;
		}
		public void setAeroplaneName(String aeroplaneName) {
			this.aeroplaneName = aeroplaneName;
		}
		
		public String getModel() {
			return model;
		}
		public void setModel(String model) {
			this.model = model;
		}
		
		public int getCapacity() {
			return capacity;
		}
		public void setCapacity(int capacity) {
			this.capacity = capacity;
		}
		
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
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
