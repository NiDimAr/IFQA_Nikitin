package config;

import org.aeonbits.owner.ConfigFactory;

public class ConfigReader {

    public static final AppConfig config;

    static {
        config = ConfigFactory.create(AppConfig.class);
        validateConfig(config);


    }

    private static void validateConfig(AppConfig config) {
        if (config.baseUrl() == null || config.baseUrl().trim().isEmpty()) {
            throw new IllegalStateException("Property 'baseUrl' must not be empty!");
        }
        if (config.login() == null || config.login().trim().isEmpty()) {
            throw new IllegalStateException("Property 'login' must not be empty!");
        }
        if (config.password() == null || config.password().trim().isEmpty()) {
            throw new IllegalStateException("Property 'password' must not be empty!");
        }
        if (config.chromeDriver() == null || config.chromeDriver().trim().isEmpty()) {
            throw new IllegalStateException("Property 'chrome.driver' must not be empty!");
        }
        if (config.driverVersion() == null || config.driverVersion().trim().isEmpty()) {
            throw new IllegalStateException("Property 'driver.version' must not be empty!");
        }
        if (config.project() == null || config.project().trim().isEmpty()) {
            throw new IllegalStateException("Property 'project' must not be empty!");
        }
        if (config.bugSummary() == null || config.bugSummary().trim().isEmpty()) {
            throw new IllegalStateException("Property 'bugSummary' must not be empty!");
        }

        if (config.Namebug() == null || config.Namebug().trim().isEmpty()) {
            throw new IllegalStateException("Property 'namebug' must not be empty!");
        }
        if (config.Projectname() == null || config.Projectname().trim().isEmpty()) {
            throw new IllegalStateException("Property 'projectname' must not be empty!");
        }
        if (config.taskType() == null || config.taskType().trim().isEmpty()) {
            throw new IllegalStateException("Property 'taskType' must not be empty!");
        }
        if (config.descriptionText() == null || config.descriptionText().trim().isEmpty()) {
            throw new IllegalStateException("Property 'descriptionText' must not be empty!");
        }
        if (config.environmentText() == null || config.environmentText().trim().isEmpty()) {
            throw new IllegalStateException("Property 'environmentText' must not be empty!");
        }
        if (config.priorityBug() == null || config.priorityBug().trim().isEmpty()) {
            throw new IllegalStateException("Property 'priorityBug' must not be empty!");
        }
    }
}

