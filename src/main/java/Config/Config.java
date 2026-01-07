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