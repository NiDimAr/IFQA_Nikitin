package org.RickAndMorty.Specs;

import Config.Config;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class RequestSpec {
    public static RequestSpecification defaultSpec() {
        return new RequestSpecBuilder()
                .setBaseUri(Config.BASE_URL)
                .setContentType("application/json")
                .build();
    }
}
