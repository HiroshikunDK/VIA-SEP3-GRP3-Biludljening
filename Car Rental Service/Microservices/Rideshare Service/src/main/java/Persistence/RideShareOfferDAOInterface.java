package Persistence;

import Model.Rideshare;
import java.sql.SQLException;
import java.util.Collection;

public interface RideShareOfferDAOInterface {
    Rideshare create(Rideshare animal) throws SQLException;
    Rideshare create(int id, int reg_nr, String name, String species, String sub_species, String birthday, float weight, int farm_reg_nr) throws SQLException;
    Collection<Rideshare> readAll() throws SQLException;
    void update(Rideshare animal) throws SQLException;
    void delete(String registrationNumber) throws SQLException;
    Rideshare read(String registrationNumber) throws SQLException;
}
