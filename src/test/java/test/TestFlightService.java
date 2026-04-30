package test;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

import model.Flight;
import service.FlightService;

public class TestFlightService {

    public static void main(String[] args) {

        // create service object
        FlightService service = new FlightService();

        // create new flight
        Flight f = new Flight();
        f.setAeroplaneId(1);
        f.setFlightNumber("FL200"); // change if duplicate
        f.setDepartureCity("Kathmandu");
        f.setArrivalCity("Pokhara");
        f.setDepartureTime(Timestamp.valueOf("2026-05-02 08:00:00"));
        f.setArrivalTime(Timestamp.valueOf("2026-05-02 08:45:00"));
        f.setPrice(new BigDecimal("4500.00"));
        f.setFlightStatus("Scheduled");

        // add flight
        boolean added = service.addFlight(f);
        System.out.println("Add Flight: " + added);

        // get all flights
        List<Flight> flights = service.getAllFlights();

        for (Flight flight : flights) {
            System.out.println("----------------------");
            System.out.println("ID: " + flight.getId());
            System.out.println("Flight: " + flight.getFlightNumber());
            System.out.println("From: " + flight.getDepartureCity());
            System.out.println("To: " + flight.getArrivalCity());
            System.out.println("Price: " + flight.getPrice());
        }

        // get by id
        Flight one = service.getFlightById(1);

        if (one != null) {
            System.out.println("Flight Found: " + one.getFlightNumber());
        } else {
            System.out.println("Flight not found");
        }

        // update flight
        if (one != null) {
            one.setPrice(new BigDecimal("5000.00"));
            boolean updated = service.updateFlight(one);
            System.out.println("Update Flight: " + updated);
        }

        // delete flight
        boolean deleted = service.deleteFlight(3); // change id if needed
        System.out.println("Delete Flight: " + deleted);
    }
}