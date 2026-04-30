package service;

import java.util.List;

import dao.BookingDAO;
import model.Booking;

public class BookingService {

    // DAO object to perform booking database operations
    private BookingDAO dao = new BookingDAO();

    // add new booking after checking basic fields
    public boolean addBooking(Booking booking) {

        // check if booking object is null
        if (booking == null) {
            return false;
        }

        // check required fields
        if (booking.getUserId() <= 0) {
            return false;
        }

        if (booking.getFlightId() <= 0) {
            return false;
        }

        if (booking.getBookingStatus() == null || booking.getBookingStatus().trim().isEmpty()) {
            return false;
        }

        if (booking.getTotalAmount() == null) {
            return false;
        }

        // call DAO to insert booking
        return dao.addBooking(booking);
    }

    // get all bookings from database
    public List<Booking> getAllBookings() {
        return dao.getAllBookings();
    }

    // get booking by id
    public Booking getBookingById(int id) {

        // check id
        if (id <= 0) {
            return null;
        }

        return dao.getBookingById(id);
    }

    // update booking details
    public boolean updateBooking(Booking booking) {

        // check object and id
        if (booking == null || booking.getId() <= 0) {
            return false;
        }

        return dao.updateBooking(booking);
    }

    // delete booking by id
    public boolean deleteBooking(int id) {

        // check id
        if (id <= 0) {
            return false;
        }

        return dao.deleteBooking(id);
    }
}