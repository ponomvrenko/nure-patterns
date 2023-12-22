package data.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class MySqlDBConnector implements DBConnector {

    private final Properties properties = new Properties();
    private String user;
    private String password;
    private String url;

    private MySqlDBConnector() {
        try {
            properties.load(MySqlDBConnector.class.getClassLoader().getResourceAsStream("application.properties"));
            user = properties.getProperty("db.mysql.username");
            password = properties.getProperty("db.mysql.password");
            url = properties.getProperty("db.mysql.url");
        } catch (Exception e) {
            throw new RuntimeException("Error initializing MySQL DB Connector", e);
        }
    }

    @Override
    public Connection getConnection() {
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static class Holder {
        private static final MySqlDBConnector INSTANCE = new MySqlDBConnector();
    }

    public static MySqlDBConnector getInstance() {
        return Holder.INSTANCE;
    }
}
