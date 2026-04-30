package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Flight;
import util.DBConfig;

public class FlightDAO {

    // Insert new flight into database
    public boolean addFlight(Flight flight) {
    	
        // SQL INSERT query
        String query = "INSERT INTO flights(aeroplane_id, flight_number, departure_city, arrival_city, departure_time, arrival_time, price, flight_status) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (
        	// Get database connection and prepare SQL query
            Connection conn = DBConfig.getConnection();
            PreparedStatement ps = conn.prepareStatement(query)
        ) {
            // Set values into query 
            ps.setInt(1, flight.getAeroplaneId());
            ps.setString(2, flight.getFlightNumber());
            ps.setString(3, flight.getDepartureCity());
            ps.setString(4, flight.getArrivalCity());
            ps.setTimestamp(5, flight.getDepartureTime());
            ps.setTimestamp(6, flight.getArrivalTime());
            ps.setBigDecimal(7, flight.getPrice());
            ps.setString(8, flight.getFlightStatus());

            // Execute INSERT query and returns true if insert successful
            int rows = ps.executeUpdate();
            return rows > 0;

        } catch (Exception e) {
            e.printStackTrace();// print error if any
        }

        return false;
    }

    // Get all flights from database
    public List<Flight> getAllFlights() {

    	// Retrieve all flights from database and store in list 
        List<Flight> flights = new ArrayList<>();
        String query = "SELECT * FROM flights";

        try (
            Connection conn = DBConfig.getConnection();
            PreparedStatement ps = conn.prepareStatement(query);
            
        		// Execute SELECT query 
        		ResultSet rs = ps.executeQuery()
        ) {

        	// Convert each row into flight object
            while (rs.next()) {
                Flight f = new Flight();

                f.setId(rs.getInt("id"));
                f.setAeroplaneId(rs.getInt("aeroplane_id"));
                f.setFlightNumber(rs.getString("flight_number"));
                f.setDepartureCity(rs.getString("departure_city"));
                f.setArrivalCity(rs.getString("arrival_city"));
                f.setDepartureTime(rs.getTimestamp("departure_time"));
                f.setArrivalTime(rs.getTimestamp("arrival_time"));
                f.setPrice(rs.getBigDecimal("price"));
                f.setFlightStatus(rs.getString("flight_status"));

                flights.add(f);// Add to list
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return flights;
    }

    // Get single flight by id
    public Flight getFlightById(int id) {

        String query = "SELECT * FROM flights WHERE id = ?";

        try (
            Connection conn = DBConfig.getConnection();
            PreparedStatement ps = conn.prepareStatement(query)
        ) {

        	// Set ID in query
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            // If record found
            if (rs.next()) {
                Flight f = new Flight();

                f.setId(rs.getInt("id"));
                f.setAeroplaneId(rs.getInt("aeroplane_id"));
                f.setFlightNumber(rs.getString("flight_number"));
                f.setDepartureCity(rs.getString("departure_city"));
                f.setArrivalCity(rs.getString("arrival_city"));
                f.setDepartureTime(rs.getTimestamp("departure_time"));
                f.setArrivalTime(rs.getTimestamp("arrival_time"));
                f.setPrice(rs.getBigDecimal("price"));
                f.setFlightStatus(rs.getString("flight_status"));

                return f;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    // Update existing flight details
    public boolean updateFlight(Flight flight) {

        String query = "UPDATE flights SET aeroplane_id=?, flight_number=?, departure_city=?, arrival_city=?, departure_time=?, arrival_time=?, price=?, flight_status=? WHERE id=?";

        try (
            Connection conn = DBConfig.getConnection();
            PreparedStatement ps = conn.prepareStatement(query)
        ) {

            ps.setInt(1, flight.getAeroplaneId());
            ps.setString(2, flight.getFlightNumber());
            ps.setString(3, flight.getDepartureCity());
            ps.setString(4, flight.getArrivalCity());
            ps.setTimestamp(5, flight.getDepartureTime());
            ps.setTimestamp(6, flight.getArrivalTime());
            ps.setBigDecimal(7, flight.getPrice());
            ps.setString(8, flight.getFlightStatus());
            ps.setInt(9, flight.getId()); // WHERE condition

            int rows = ps.executeUpdate();
            return rows > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    // Delete flight from database by id
    public boolean deleteFlight(int id) {

        String query = "DELETE FROM flights WHERE id = ?";

        try (
            Connection conn = DBConfig.getConnection();
            PreparedStatement ps = conn.prepareStatement(query)
        ) {
            // Set ID to delete
            ps.setInt(1, id);

            int rows = ps.executeUpdate();
            return rows > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}