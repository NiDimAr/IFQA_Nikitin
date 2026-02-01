package ServerIF_HW5.specs;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static config.ConfigReader.config;


public class RequestSpec {
    public static RequestSpecification baseSpec() {
        return new RequestSpecBuilder()
                .setBaseUri(config.serverUrl())
                .setContentType(ContentType.JSON)
                .build();
    }
}
