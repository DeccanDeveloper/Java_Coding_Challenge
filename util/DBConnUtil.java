package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import java.io.InputStream;

public class DBConnUtil {

    public static Connection getDBConn() {
        try {

            String connStr = DBPropertyUtil.getConnectionString("DB.properties");

            return DriverManager.getConnection(connStr);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error establishing database connection.");
        }
    }
}
