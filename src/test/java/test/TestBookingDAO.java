package test;

import java.math.BigDecimal;
import java.util.List;

import dao.BookingDAO;
import model.Booking;

public class TestBookingDAO {

    public static void main(String[] args) {

        // create DAO object
        BookingDAO dao = new BookingDAO();

        // create new booking and set values
        Booking booking = new Booking();
        booking.setUserId(3); // existing user
        booking.setFlightId(1); // existing flight
        booking.setBookingStatus("Reserved");
        booking.setTotalAmount(new BigDecimal("4500.00"));

        // add booking to database
        boolean added = dao.addBooking(booking);
        System.out.println("Add Booking: " + added);

        // get all bookings from database
        List<Booking> bookings = dao.getAllBookings();

        // print all booking records
        for (Booking b : bookings) {
            System.out.println("-----------------------------");
            System.out.println("ID: " + b.getId());
            System.out.println("User ID: " + b.getUserId());
            System.out.println("Flight ID: " + b.getFlightId());
            System.out.println("Status: " + b.getBookingStatus());
            System.out.println("Total Amount: " + b.getTotalAmount());
        }

        // get booking by id
        Booking b = dao.getBookingById(1);

        // check if booking exists
        if (b != null) {
            System.out.println("Booking Found: " + b.getId());
        } else {
            System.out.println("Booking not found");
        }

        // update booking status
        if (b != null) {
            b.setBookingStatus("Paid");

            boolean updated = dao.updateBooking(b);
            System.out.println("Update Booking: " + updated);
        }

        // delete booking by id
        boolean deleted = dao.deleteBooking(3); // change id if needed
        System.out.println("Delete Booking: " + deleted);
    }
}
