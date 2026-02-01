package org.RickAndMorty.Specs;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

import static config.ConfigReader.config;


public class RequestSpec {
    public static RequestSpecification defaultSpec() {
        return new RequestSpecBuilder()
                .setBaseUri(config.baseUrl())
                .setContentType("application/json")
                .build();
    }
}
