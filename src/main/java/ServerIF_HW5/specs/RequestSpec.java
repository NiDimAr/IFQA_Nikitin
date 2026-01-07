package ServerIF_HW5.specs;

import Config.Config;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;


public class RequestSpec {
    public static RequestSpecification baseSpec() {
        return new RequestSpecBuilder()
                .setBaseUri(Config.SERVER_URL)
                .setContentType(ContentType.JSON)
                .build();
    }
}
