package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectionManager {

    private static String url = "jdbc:postgresql://localhost:5432/coworkingspace";
    private static String user = "postgres";
    private static String password = "coworkingspace123";

    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(url,user,password);
    }
}
