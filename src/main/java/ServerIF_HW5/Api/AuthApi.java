package ServerIF_HW5.Api;

import ServerIF_HW5.models.AuthRequest;
import ServerIF_HW5.specs.RequestSpec;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class AuthApi {
    public static Response register(AuthRequest request) {
        return given()
                .spec(RequestSpec.baseSpec())
                .body(request)
                .post("/api/register");
    }

    public static Response login(AuthRequest request) {
        return given()
                .spec(RequestSpec.baseSpec())
                .body(request)
                .post("/api/login");
    }

    public static Response logout(String token) {
        return given()
                .spec(RequestSpec.baseSpec())
                .header("Authorization", token)
                .get("/api/logout");
    }
}
