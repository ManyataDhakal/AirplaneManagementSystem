package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Booking;
import util.DBConfig;

public class BookingDAO {

    //Add new booking
    public boolean addBooking(Booking b) {

        // SQL query to insert booking data into bookings table
        String query = "INSERT INTO bookings(user_id, flight_id, booking_status, total_amount) VALUES (?, ?, ?, ?)";

        try (
            // establish database connection
            Connection conn = DBConfig.getConnection();

            // prepare SQL statement
            PreparedStatement ps = conn.prepareStatement(query)
        ) {

            // set values from Booking object to SQL query
            ps.setInt(1, b.getUserId());
            ps.setInt(2, b.getFlightId());
            ps.setString(3, b.getBookingStatus());
            ps.setBigDecimal(4, b.getTotalAmount());

            // execute insert query
            int rows = ps.executeUpdate();

            // return true if insertion successful
            return rows > 0;

        } catch (Exception e) {
            e.printStackTrace(); // print error if any
        }

        return false;
    }

    // READ: Get all bookings
    public List<Booking> getAllBookings() {

        // list to store booking objects
        List<Booking> list = new ArrayList<>();

        // SQL query to fetch all bookings
        String query = "SELECT * FROM bookings";

        try (
            Connection conn = DBConfig.getConnection();
            PreparedStatement ps = conn.prepareStatement(query);

            // execute select query
            ResultSet rs = ps.executeQuery()
        ) {

            // loop through result set (each row)
            while (rs.next()) {

                // create Booking object for each record
                Booking b = new Booking();

                // database values to object fields
                b.setId(rs.getInt("id"));
                b.setUserId(rs.getInt("user_id"));
                b.setFlightId(rs.getInt("flight_id"));
                b.setBookingStatus(rs.getString("booking_status"));
                b.setTotalAmount(rs.getBigDecimal("total_amount"));

                // add object to list
                list.add(b);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        // return list of bookings
        return list;
    }

    //READ: Get booking by ID
    public Booking getBookingById(int id) {

        // SQL query to fetch one booking using id
        String query = "SELECT * FROM bookings WHERE id = ?";

        try (
            Connection conn = DBConfig.getConnection();
            PreparedStatement ps = conn.prepareStatement(query)
        ) {

            // set id parameter in query
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            // check if record exists
            if (rs.next()) {

                Booking b = new Booking();

                //  values from database to object
                b.setId(rs.getInt("id"));
                b.setUserId(rs.getInt("user_id"));
                b.setFlightId(rs.getInt("flight_id"));
                b.setBookingStatus(rs.getString("booking_status"));
                b.setTotalAmount(rs.getBigDecimal("total_amount"));

                return b; // return booking object
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null; // return null if not found
    }

    // UPDATE: Modify booking
    public boolean updateBooking(Booking b) {

        // SQL query to update booking details
        String query = "UPDATE bookings SET user_id=?, flight_id=?, booking_status=?, total_amount=? WHERE id=?";

        try (
            Connection conn = DBConfig.getConnection();
            PreparedStatement ps = conn.prepareStatement(query)
        ) {

            // set updated values
            ps.setInt(1, b.getUserId());
            ps.setInt(2, b.getFlightId());
            ps.setString(3, b.getBookingStatus());
            ps.setBigDecimal(4, b.getTotalAmount());
            ps.setInt(5, b.getId()); // condition to update specific row

            // execute update query
            int rows = ps.executeUpdate();

            // return true if update successful
            return rows > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    // DELETE: Remove booking
    public boolean deleteBooking(int id) {

        // SQL query to delete booking by id
        String query = "DELETE FROM bookings WHERE id = ?";

        try (
            Connection conn = DBConfig.getConnection();
            PreparedStatement ps = conn.prepareStatement(query)
        ) {

            // set id to delete
            ps.setInt(1, id);

            // execute delete query
            int rows = ps.executeUpdate();

            // return true if deletion successful
            return rows > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}
