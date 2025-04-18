package util;

import java.io.InputStream;
import java.util.Properties;

public class DBPropertyUtil {

    public static String getConnectionString(String propertyFileName) {
        try {

            Properties prop = new Properties();
            InputStream is = DBPropertyUtil.class.getClassLoader().getResourceAsStream(propertyFileName);
            if (is == null) {
                throw new RuntimeException("Property file not found in classpath: " + propertyFileName);
            }
            prop.load(is);

            String url = prop.getProperty("db.url");
            String user = prop.getProperty("db.user");
            String password = prop.getProperty("db.password");

            return url + "?user=" + user + "&password=" + password;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error reading DB property file: " + e.getMessage());
        }
    }
}
