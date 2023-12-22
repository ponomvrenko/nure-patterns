package java.data.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SimpleDBConnector implements DBConnector {

    private final String url;
    private final String user;
    private final String password;

    public SimpleDBConnector(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    static {
        // Optionally, you can load the JDBC driver here
         try {
             Class.forName("com.mysql.cj.jdbc.MySQLDriver");
         } catch (ClassNotFoundException e) {
             e.printStackTrace();
         }
    }

    @Override
    public Connection getConnection() {
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace(); // Handle or log the exception as needed
            return null;
        }
    }
}
