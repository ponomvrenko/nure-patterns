package data.utils;

import java.sql.Connection;

public interface DBConnector {
    Connection getConnection();
}
