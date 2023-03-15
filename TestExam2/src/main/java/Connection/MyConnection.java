package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class MyConnection {
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "123456";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/scoremanagement";
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }
}
