package test;

import java.util.List;

import model.Aeroplane;
import service.AeroplaneService;

public class TestAeroplaneService {

    public static void main(String[] args) {

        // create service object
        AeroplaneService service = new AeroplaneService();

        // create new aeroplane
        Aeroplane a = new Aeroplane();
        a.setAeroplaneName("Test Plane"); // change name if duplicate
        a.setModel("Boeing 737");
        a.setCapacity(120);
        a.setStatus("Available");

        // add aeroplane
        boolean added = service.addAeroplane(a);
        System.out.println("Add Aeroplane: " + added);

        // get all aeroplanes
        List<Aeroplane> list = service.getAllAeroplanes();

        for (Aeroplane ap : list) {
            System.out.println("----------------------");
            System.out.println("ID: " + ap.getId());
            System.out.println("Name: " + ap.getAeroplaneName());
            System.out.println("Model: " + ap.getModel());
            System.out.println("Capacity: " + ap.getCapacity());
            System.out.println("Status: " + ap.getStatus());
        }

        // get aeroplane by id
        Aeroplane one = service.getAeroplaneById(1);

        if (one != null) {
            System.out.println("Aeroplane Found: " + one.getAeroplaneName());
        } else {
            System.out.println("Aeroplane not found");
        }

        // update aeroplane
        if (one != null) {
            one.setCapacity(150);

            boolean updated = service.updateAeroplane(one);
            System.out.println("Update Aeroplane: " + updated);
        }

        // delete aeroplane
        boolean deleted = service.deleteAeroplane(3); // change id if needed
        System.out.println("Delete Aeroplane: " + deleted);
    }
}
