package ServerIF_HW5.specs;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

import static io.restassured.http.ContentType.JSON;

public class RequestSpec {
    public static RequestSpecification baseSpec() {
        return new RequestSpecBuilder()
                .setBaseUri("http://localhost")
                .setPort(8080)
                .setContentType(JSON)
                .build();
    }
}
