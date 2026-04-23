package model;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class Booking {
	 private int id;
	    private int userId;
	    private int flightId;
	    private Timestamp bookingDate;
	    private String bookingStatus; // Reserved, Paid, Cancelled
	    private BigDecimal totalAmount;

	    public Booking() {
	    }

	    public Booking(int id, int userId, int flightId, Timestamp bookingDate, String bookingStatus, BigDecimal totalAmount) {
	        this.id = id;
	        this.userId = userId;
	        this.flightId = flightId;
	        this.bookingDate = bookingDate;
	        this.bookingStatus = bookingStatus;
	        this.totalAmount = totalAmount;
	    }

	    // Getters and Setters
	    public int getId() {
	        return id;
	    }

	    public void setId(int id) {
	        this.id = id;
	    }

	    public int getUserId() {
	        return userId;
	    }

	    public void setUserId(int userId) {
	        this.userId = userId;
	    }

	    public int getFlightId() {
	        return flightId;
	    }

	    public void setFlightId(int flightId) {
	        this.flightId = flightId;
	    }

	    public Timestamp getBookingDate() {
	        return bookingDate;
	    }

	    public void setBookingDate(Timestamp bookingDate) {
	        this.bookingDate = bookingDate;
	    }

	    public String getBookingStatus() {
	        return bookingStatus;
	    }

	    public void setBookingStatus(String bookingStatus) {
	        this.bookingStatus = bookingStatus;
	    }

	    public BigDecimal getTotalAmount() {
	        return totalAmount;
	    }

	    public void setTotalAmount(BigDecimal totalAmount) {
	        this.totalAmount = totalAmount;
	    }
	}
