package ServerIF_HW5.specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;

public class ResponseSpec {
    public static ResponseSpecification status200() {
        return new ResponseSpecBuilder()
                .expectStatusCode(200)
                .build();
    }

    public static ResponseSpecification status401() {
        return new ResponseSpecBuilder()
                .expectStatusCode(401)
                .build();
    }
}
