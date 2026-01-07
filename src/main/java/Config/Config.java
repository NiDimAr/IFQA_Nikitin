package Config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {
    private static final Properties properties = new Properties();
    public static final String BASE_URL = properties.getProperty("BASE_URL");
    public static final String SERVER_URL = properties.getProperty("SERVER_URL");
    public static final String USERNAME = properties.getProperty("USERNAME");
    public static final String PASSWORD = properties.getProperty("PASSWORD");
    public static final String SUCCESS_REGISTER = properties.getProperty("SUCCESS_REGISTER");
    public static final String NOT_FOUND = properties.getProperty("NOT_FOUND");
    public static final String NOT_RIGHT_PASS = properties.getProperty("NOT_RIGHT_PASS");
    public static final String SUCCESS_LOGOUT = properties.getProperty("SUCCESS_LOGOUT");

    static {
        try (InputStream stream = Config.class.getClassLoader()
                .getResourceAsStream("config.properties")) {
            if (stream == null) {
                throw new RuntimeException("config.properties not found in resources");
            }
            properties.load(stream);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config.properties", e);
        }
    }
}