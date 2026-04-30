package test;

import java.util.List;

import dao.AeroplaneDAO;
import model.Aeroplane;

public class TestAeroplaneDAO {

    public static void main(String[] args) {
    	//create DAO object to call database methods
        AeroplaneDAO dao = new AeroplaneDAO();

        // create new aeroplane object and set values
        Aeroplane a = new Aeroplane();
        a.setAeroplaneName("Test Air");
        a.setModel("Boeing 737");
        a.setCapacity(100);
        a.setStatus("Available");

        // call DAO method to insert data into database
        boolean added = dao.addAeroplane(a);
        System.out.println("Add Aeroplane: " + added);


        // call DAO method to fetch all records
        List<Aeroplane> list = dao.getAllAeroplanes();

        // Loop through each record and display values
        for (Aeroplane ap : list) {
            System.out.println("--------------------");
            System.out.println("ID: " + ap.getId());
            System.out.println("Name: " + ap.getAeroplaneName());
            System.out.println("Model: " + ap.getModel());
            System.out.println("Capacity: " + ap.getCapacity());
            System.out.println("Status: " + ap.getStatus());
        }


        // fetch single aeroplane using  id
        Aeroplane one = dao.getAeroplaneById(1);

        // check if data exists
        if (one != null) {
            System.out.println("Found: " + one.getAeroplaneName());
        } else {
            System.out.println("Not found");
        }


        // update only if records exists
        if (one != null) {
            one.setCapacity(120);
            
            // call DAO method to update record
            boolean updated = dao.updateAeroplane(one);
            System.out.println("Update Aeroplane: " + updated);
        }


        // delete aeroplane using id
        boolean deleted = dao.deleteAeroplane(3); // change id if needed
        System.out.println("Delete Aeroplane: " + deleted);
    }
}