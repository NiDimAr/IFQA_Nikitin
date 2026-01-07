package ServerIF_HW5;

import Config.Config;
import ServerIF_HW5.Steps.AuthSteps;
import ServerIF_HW5.models.AuthRequest;
import org.junit.Test;

public class TestOpen {

    @Test
    public void fullAuthFlowTest() {

        AuthRequest user = new AuthRequest();
        user.setUsername(Config.USERNAME);
        user.setPassword(Config.PASSWORD);


        AuthSteps.registerUser(user);
        AuthSteps.loginWithWrongUsername("wrongUser", user.getPassword());
        AuthSteps.loginWithWrongPassword(user.getUsername(), "wrongPassword");

        String token = AuthSteps.login(user);

        AuthSteps.logout("00000000-0000-0000-0000-000000000000", false);
        AuthSteps.logout(token, true);
    }
}