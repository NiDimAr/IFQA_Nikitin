package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:config.properties"
})
public interface TestConfig extends Config {

    @Key("BASE_URL")
    String baseUrl();

    @Key("SERVER_URL")
    String serverUrl();

    @Key("USER")
    String user();

    @Key("PASSWORD")
    String password();
}