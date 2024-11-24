package Persistance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Databasehelper
{
    private static final String URL ="jdbc:sqlite:C:/Users/sakaa/IdeaProjects/VIA-SEP3-GRP3-Biludljening/Car Rental Service/Microservices/Database/PaymentService.db";
    //private static final String URL = "jdbc:sqlite:Car Rental Service/Z_DatabaseUtility/PaymentServiceDBLite/PaymentServiceDB.db";

    public Connection getConnection()
    {
        try
        {
            return DriverManager.getConnection(URL);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return null;
        }

    }

    public Connection getConnection(String connectionstring)
    {
        try
        {
            return DriverManager.getConnection(connectionstring);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return null;
        }
    }
}
