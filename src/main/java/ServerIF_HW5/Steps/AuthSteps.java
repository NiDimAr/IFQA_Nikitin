package ServerIF_HW5.Steps;

import ServerIF_HW5.Api.AuthApi;
import ServerIF_HW5.models.AuthRequest;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertNotNull;

public class AuthSteps {

    public static void registerUser(AuthRequest user) {
        AuthApi.register(user)
                .then()
                .statusCode(200)
                .body(equalTo("success register"));
    }

    public static void loginWithWrongUsername(String username, String password) {
        AuthRequest wrongUser = new AuthRequest();
        wrongUser.setUsername(username);
        wrongUser.setPassword(password);

        AuthApi.login(wrongUser)
                .then()
                .statusCode(401)
                .body(equalTo("not found"));
    }

    public static void loginWithWrongPassword(String username, String wrongPassword) {
        AuthRequest wrongPass = new AuthRequest();
        wrongPass.setUsername(username);
        wrongPass.setPassword(wrongPassword);

        AuthApi.login(wrongPass)
                .then()
                .statusCode(401)
                .body(equalTo("not right pass"));
    }

    public static String login(AuthRequest user) {
        String response = AuthApi.login(user)
                .then()
                .statusCode(200)
                .extract()
                .asString();

        String token = response.split(" : ")[1].trim();
        assertNotNull(token);
        return token;
    }

    public static void logout(String token, boolean expectSuccess) {
        if (expectSuccess) {
            AuthApi.logout(token)
                    .then()
                    .statusCode(200)
                    .body(equalTo("success logout"));
        } else {
            AuthApi.logout(token)
                    .then()
                    .statusCode(401)
                    .body(equalTo("not found"));
        }
    }
}