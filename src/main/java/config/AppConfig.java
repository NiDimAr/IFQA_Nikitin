package config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:application.properties")
public interface AppConfig extends Config {

    @Key("baseUrl")
    String baseUrl();

    @Key("login")
    String login();

    @Key("password")
    String password();

    @Key("namebug")
    String Namebug();

    @Key("projectname")
    String Projectname();

    @Key("browser")
    @DefaultValue("chrome")
    String browser();

    @Key("chrome.driver")
    String chromeDriver();

    @Key("driver.version")
    String driverVersion();

    @Key("timeout")
    @DefaultValue("8000")
    long timeout();

    @Key("project")
    String project();

    @Key("bugSummary")
    String bugSummary();

    @Key("allure.screenshots")
    @DefaultValue("true")
    boolean allureScreenshots();

    @Key("allure.savePageSource")
    @DefaultValue("false")
    boolean allureSavePageSource();

    @Key("taskType")
    @DefaultValue("Ошибка")
    String taskType();

    @Key("descriptionText")
    @DefaultValue("BagBym")
    String descriptionText();

    @Key("environmentText")
    @DefaultValue("BagBym")
    String environmentText();

    @Key("priorityBug")
    @DefaultValue("High")
    String priorityBug();
}

