package ifellow.example.pages;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class Config {
    public static final String baseUrl;
    public static final String login;
    public static final String password;
    public static final String project;
    public static final String bugSummary;
    public static final String browser;
    public static final String chromeDriverPath;
    public static final long timeout;
    private static final Properties properties = new Properties();

    static {
        try (InputStream stream = Config.class.getClassLoader()
                .getResourceAsStream("application.properties")) {

            if (stream == null) {
                throw new RuntimeException("application.properties not found in resources");
            }

            properties.load(stream);

            baseUrl = properties.getProperty("baseUrl");
            login = properties.getProperty("login");
            password = properties.getProperty("password");
            project = properties.getProperty("project");
            bugSummary = properties.getProperty("bugSummary");
            browser = properties.getProperty("browser");
            chromeDriverPath = properties.getProperty("chromeDriverPath");

            String timeoutStr = properties.getProperty("timeout");
            if (timeoutStr == null) {
                throw new RuntimeException("timeout property is missing in application.properties");
            }
            timeout = Long.parseLong(timeoutStr);

        } catch (IOException e) {
            throw new RuntimeException("Failed to load application.properties", e);
        }
    }
}


