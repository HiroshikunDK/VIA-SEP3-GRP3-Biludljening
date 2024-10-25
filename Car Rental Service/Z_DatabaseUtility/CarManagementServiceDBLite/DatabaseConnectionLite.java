import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectionLite {
    //private static final String URL ="jdbc:sqlite:Car Rental Service/Z_DatabaseUtility/CarManagementServiceDBLite/CarManagementServiceDBV2.db";
    private static final String URL ="jdbc:sqlite:Car Rental Service/Z_DatabaseUtility/CarManagementServiceDBLite/CarManagementServiceDB.db";

    public Connection getConnection() {
        try {
            return DriverManager.getConnection(URL);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }
    public Connection getConnection(String connectionstring) {
        try {
            return DriverManager.getConnection(connectionstring);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }


}