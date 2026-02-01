package config;

import org.aeonbits.owner.ConfigFactory;

public class ConfigReader {

    public static final config.TestConfig config =
            ConfigFactory.create(config.TestConfig.class);
}