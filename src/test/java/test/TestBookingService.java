package test;

import java.math.BigDecimal;
import java.util.List;

import model.Booking;
import service.BookingService;

public class TestBookingService {

    public static void main(String[] args) {

        // create service object
        BookingService service = new BookingService();

        // create new booking
        Booking b = new Booking();
        b.setUserId(3);
        b.setFlightId(1);
        b.setBookingStatus("Reserved");
        b.setTotalAmount(new BigDecimal("4500.00"));

        // add booking
        boolean added = service.addBooking(b);
        System.out.println("Add Booking: " + added);

        // get all bookings
        List<Booking> list = service.getAllBookings();

        for (Booking booking : list) {
            System.out.println("----------------------");
            System.out.println("ID: " + booking.getId());
            System.out.println("User ID: " + booking.getUserId());
            System.out.println("Flight ID: " + booking.getFlightId());
            System.out.println("Status: " + booking.getBookingStatus());
            System.out.println("Total Amount: " + booking.getTotalAmount());
        }

        // get booking by id
        Booking one = service.getBookingById(1);

        if (one != null) {
            System.out.println("Booking Found: " + one.getId());
        } else {
            System.out.println("Booking not found");
        }

        // update booking
        if (one != null) {
            one.setBookingStatus("Paid");

            boolean updated = service.updateBooking(one);
            System.out.println("Update Booking: " + updated);
        }

        // delete booking
        boolean deleted = service.deleteBooking(3); // change id if needed
        System.out.println("Delete Booking: " + deleted);
    }
}
