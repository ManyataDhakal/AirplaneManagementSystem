package service;

import java.util.List;

import dao.AeroplaneDAO;
import model.Aeroplane;

public class AeroplaneService {

    // DAO object to perform aeroplane database operations
    private AeroplaneDAO dao = new AeroplaneDAO();

    // add new aeroplane after checking basic fields
    public boolean addAeroplane(Aeroplane aeroplane) {

        // check if aeroplane object is null
        if (aeroplane == null) {
            return false;
        }

        // check required fields
        if (aeroplane.getAeroplaneName() == null || aeroplane.getAeroplaneName().trim().isEmpty()) {
            return false;
        }

        if (aeroplane.getModel() == null || aeroplane.getModel().trim().isEmpty()) {
            return false;
        }

        if (aeroplane.getCapacity() <= 0) {
            return false;
        }

        if (aeroplane.getStatus() == null || aeroplane.getStatus().trim().isEmpty()) {
            return false;
        }

        // call DAO to insert aeroplane into database
        return dao.addAeroplane(aeroplane);
    }

    // get all aeroplanes from database
    public List<Aeroplane> getAllAeroplanes() {
        return dao.getAllAeroplanes();
    }

    // get aeroplane using id
    public Aeroplane getAeroplaneById(int id) {

        // check id is valid
        if (id <= 0) {
            return null;
        }

        return dao.getAeroplaneById(id);
    }

    // update aeroplane details
    public boolean updateAeroplane(Aeroplane aeroplane) {

        // check object and id before update
        if (aeroplane == null || aeroplane.getId() <= 0) {
            return false;
        }

        return dao.updateAeroplane(aeroplane);
    }

    // delete aeroplane using id
    public boolean deleteAeroplane(int id) {

        // check id before deleting
        if (id <= 0) {
            return false;
        }

        return dao.deleteAeroplane(id);
    }
}