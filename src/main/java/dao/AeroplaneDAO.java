package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Aeroplane;
import util.DBConfig;

public class AeroplaneDAO {

    // insert new aeroplane record
    public boolean addAeroplane(Aeroplane a) {

        // SQL query to insert data into aeroplane table
        String query = "INSERT INTO aeroplane(aeroplane_name, model, capacity, status) VALUES (?, ?, ?, ?)";

        try (
            // get database connection
            Connection conn = DBConfig.getConnection();

            // prepare SQL statement
            PreparedStatement ps = conn.prepareStatement(query)
        ) {

            // set values from object to query
            ps.setString(1, a.getAeroplaneName());
            ps.setString(2, a.getModel());
            ps.setInt(3, a.getCapacity());
            ps.setString(4, a.getStatus());

            // execute insert query
            int rows = ps.executeUpdate();

            // return true if data inserted
            return rows > 0;

        } catch (Exception e) {
            e.printStackTrace(); // print error
        }

        return false;
    }


    //  get all aeroplanes
    public List<Aeroplane> getAllAeroplanes() {

        // list to store aeroplane objects
        List<Aeroplane> list = new ArrayList<>();

        // SQL query to fetch all records
        String query = "SELECT * FROM aeroplane";

        try (
            Connection conn = DBConfig.getConnection();
            PreparedStatement ps = conn.prepareStatement(query);

            // execute select query
            ResultSet rs = ps.executeQuery()
        ) {

            // loop through each row
            while (rs.next()) {

                // create object for each row
                Aeroplane a = new Aeroplane();

                // set values from database to object
                a.setId(rs.getInt("id"));
                a.setAeroplaneName(rs.getString("aeroplane_name"));
                a.setModel(rs.getString("model"));
                a.setCapacity(rs.getInt("capacity"));
                a.setStatus(rs.getString("status"));

                // add object to list
                list.add(a);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        // return all aeroplanes
        return list;
    }


    // get aeroplane by id
    public Aeroplane getAeroplaneById(int id) {

        // SQL query with condition
        String query = "SELECT * FROM aeroplane WHERE id = ?";

        try (
            Connection conn = DBConfig.getConnection();
            PreparedStatement ps = conn.prepareStatement(query)
        ) {

            // set id in query
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            // if record found
            if (rs.next()) {

                Aeroplane a = new Aeroplane();

                // map database values to object
                a.setId(rs.getInt("id"));
                a.setAeroplaneName(rs.getString("aeroplane_name"));
                a.setModel(rs.getString("model"));
                a.setCapacity(rs.getInt("capacity"));
                a.setStatus(rs.getString("status"));

                return a; // return object
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null; // return null if not found
    }


    //  update aeroplane details
    public boolean updateAeroplane(Aeroplane a) {

        // SQL query to update record
        String query = "UPDATE aeroplane SET aeroplane_name=?, model=?, capacity=?, status=? WHERE id=?";

        try (
            Connection conn = DBConfig.getConnection();
            PreparedStatement ps = conn.prepareStatement(query)
        ) {

            // set updated values
            ps.setString(1, a.getAeroplaneName());
            ps.setString(2, a.getModel());
            ps.setInt(3, a.getCapacity());
            ps.setString(4, a.getStatus());
            ps.setInt(5, a.getId()); // where condition

            // execute update query
            int rows = ps.executeUpdate();

            // return true if updated
            return rows > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }


    // remove aeroplane by id
    public boolean deleteAeroplane(int id) {

        // SQL query to delete record
        String query = "DELETE FROM aeroplane WHERE id = ?";

        try (
            Connection conn = DBConfig.getConnection();
            PreparedStatement ps = conn.prepareStatement(query)
        ) {

            // set id to delete
            ps.setInt(1, id);

            // execute delete query
            int rows = ps.executeUpdate();

            // return true if deleted
            return rows > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}
