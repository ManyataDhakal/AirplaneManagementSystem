package service;

import java.util.List;

import dao.FlightDAO;
import model.Flight;

public class FlightService {

    // DAO object to perform flight database operations
    private FlightDAO dao = new FlightDAO();

    // add new flight after checking basic fields
    public boolean addFlight(Flight flight) {

        // check if flight object is null
        if (flight == null) {
            return false;
        }

        // check required fields
        if (flight.getFlightNumber() == null || flight.getFlightNumber().trim().isEmpty()) {
            return false;
        }

        if (flight.getDepartureCity() == null || flight.getDepartureCity().trim().isEmpty()) {
            return false;
        }

        if (flight.getArrivalCity() == null || flight.getArrivalCity().trim().isEmpty()) {
            return false;
        }

        if (flight.getDepartureTime() == null || flight.getArrivalTime() == null) {
            return false;
        }

        if (flight.getPrice() == null) {
            return false;
        }

        // call DAO to insert flight into database
        return dao.addFlight(flight);
    }

    // get all flights from database
    public List<Flight> getAllFlights() {

        // directly return list from DAO
        return dao.getAllFlights();
    }

    // get flight using id
    public Flight getFlightById(int id) {

        // check id is valid
        if (id <= 0) {
            return null;
        }

        // call DAO to fetch flight
        return dao.getFlightById(id);
    }

    // update flight details
    public boolean updateFlight(Flight flight) {

        // check object and id before update
        if (flight == null || flight.getId() <= 0) {
            return false;
        }

        // call DAO to update flight
        return dao.updateFlight(flight);
    }

    // delete flight using id
    public boolean deleteFlight(int id) {

        // check id before deleting
        if (id <= 0) {
            return false;
        }

        // call DAO to delete flight
        return dao.deleteFlight(id);
    }
}