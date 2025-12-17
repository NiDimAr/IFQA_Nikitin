package ServerIF_HW5;

import ServerIF_HW5.Api.AuthApi;
import ServerIF_HW5.Utils.JsonReader;
import ServerIF_HW5.models.AuthRequest;
import org.junit.Test;

import static ServerIF_HW5.specs.ResponseSpec.status200;
import static ServerIF_HW5.specs.ResponseSpec.status401;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertNotNull;

public class TestOpen {
    @Test
    public void fullAuthFlowTest() {

        AuthRequest user = JsonReader.readUser();

        AuthApi.register(user)
                .then()
                .spec(status200())
                .body(equalTo("success register"));

        AuthRequest wrongUser = new AuthRequest();
        wrongUser.setUsername("wrongUser");
        wrongUser.setPassword(user.getPassword());

        AuthApi.login(wrongUser)
                .then()
                .spec(status401())
                .body(equalTo("not found"));

        AuthRequest wrongPass = new AuthRequest();
        wrongPass.setUsername(user.getUsername());
        wrongPass.setPassword("wrongPassword");

        AuthApi.login(wrongPass)
                .then()
                .spec(status401())
                .body(equalTo("not right pass"));

        String loginResponse = AuthApi.login(user)
                .then()
                .spec(status200())
                .extract()
                .asString();

        String token = loginResponse.split(" : ")[1].trim();
        assertNotNull(token);

        AuthApi.logout("00000000-0000-0000-0000-000000000000")
                .then()
                .spec(status401())
                .body(equalTo("not found"));

        AuthApi.logout(token)
                .then()
                .spec(status200())
                .body(equalTo("success logout"));
    }
}

