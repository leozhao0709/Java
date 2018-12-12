package dbTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

class DBUtil {

    private static String url;
    private static String userName;
    private static String password;

    static {
        ResourceBundle rb = ResourceBundle.getBundle("dbTest.db");
        url = rb.getString("dbUrl");
        String driverClass = rb.getString("driverClass");
        userName = System.getenv("DB_USER");
        password = System.getenv("DB_PASS");
        try {
            Class.forName(driverClass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, userName, password);
    }
}
