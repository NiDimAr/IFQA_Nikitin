package utils;

import lombok.Getter;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class Config {

    private static final Properties props = new Properties();
    @Getter
    private static final String baseUrl;
    @Getter
    private static final String login;
    @Getter
    private static final String password;
    @Getter
    private static final String browser;
    @Getter
    private static final String chromeDriver;
    @Getter
    private static final String driverVersion;
    @Getter
    private static final long timeout;
    @Getter
    private static final String project;
    @Getter
    private static final String bugSummary;


    static {
        try (InputStream stream = Config.class.getClassLoader()
                .getResourceAsStream("application.properties")) {

            if (stream == null) {
                throw new RuntimeException("application.properties not found in resources");
            }

            props.load(stream);

            baseUrl = required("baseUrl");
            login = required("login");
            password = optional("password");
            browser = required("browser");
            chromeDriver = required("chrome.driver");
            driverVersion = required("driver.version");
            timeout = requiredLong("timeout");
            project = required("project");
            bugSummary = required("bugSummary");

        } catch (IOException e) {
            throw new RuntimeException("Failed to load application.properties", e);
        }
    }


    private static String required(String key) {
        String value = props.getProperty(key);
        if (value == null || value.isBlank()) {
            throw new RuntimeException("Property '" + key + "' is missing or empty");
        }
        return value;
    }

    private static String optional(String key) {
        String value = props.getProperty(key);
        return (value == null || value.isBlank()) ? null : value;
    }

    private static long requiredLong(String key) {
        try {
            return Long.parseLong(required(key));
        } catch (NumberFormatException e) {
            throw new RuntimeException("Property '" + key + "' must be a number");
        }
    }
}


