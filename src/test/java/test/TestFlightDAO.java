package test;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

import dao.FlightDAO;
import model.Flight;

public class TestFlightDAO {

    public static void main(String[] args) {

        FlightDAO dao = new FlightDAO();

        // Add new flight to database
        Flight flight = new Flight();
        flight.setAeroplaneId(1);
        flight.setFlightNumber("FL100"); // unique flight number
        flight.setDepartureCity("Kathmandu");
        flight.setArrivalCity("Pokhara");
        flight.setDepartureTime(Timestamp.valueOf("2026-05-01 08:00:00"));
        flight.setArrivalTime(Timestamp.valueOf("2026-05-01 08:45:00"));
        flight.setPrice(new BigDecimal("4500.00"));
        flight.setFlightStatus("Scheduled");

        boolean added = dao.addFlight(flight);
        System.out.println("Add Flight: " + added);


        // Get all flights from database
        List<Flight> flights = dao.getAllFlights();
        
        for (Flight f : flights) {
            System.out.println("-----------------------------");
            System.out.println("ID: " + f.getId());
            System.out.println("Flight: " + f.getFlightNumber());
            System.out.println("From: " + f.getDepartureCity());
            System.out.println("To: " + f.getArrivalCity());
            System.out.println("Price: " + f.getPrice());
        }

        // Get flight  by ID)
        Flight f = dao.getFlightById(1);

        if (f != null) {
            System.out.println("Flight Found: " + f.getFlightNumber());
        } else {
            System.out.println("Flight not found");
        }

        // UPDATE flight price
        if (f != null) {
            f.setPrice(new BigDecimal("5000.00"));

            boolean updated = dao.updateFlight(f);
            System.out.println("Update Flight: " + updated);
        }

        // DELETE flight by ID
        boolean deleted = dao.deleteFlight(3); // change id if needed
        System.out.println("Delete Flight: " + deleted);
    }
}