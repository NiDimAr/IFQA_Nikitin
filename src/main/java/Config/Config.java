package Config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {

    public static final String BASE_URL;
    public static final String SERVER_URL;
    public static final String USERNAME;
    public static final String PASSWORD;

    static {
        Properties properties = new Properties();
        try (InputStream stream = Config.class.getClassLoader()
                .getResourceAsStream("config.properties")) {

            if (stream == null) {
                throw new RuntimeException("config.properties not found in resources");
            }

            properties.load(stream);

            BASE_URL = properties.getProperty("BASE_URL");
            SERVER_URL = properties.getProperty("SERVER_URL");
            USERNAME = properties.getProperty("USERNAME");
            PASSWORD = properties.getProperty("PASSWORD");

        } catch (IOException e) {
            throw new RuntimeException("Failed to load config.properties", e);
        }
    }
}