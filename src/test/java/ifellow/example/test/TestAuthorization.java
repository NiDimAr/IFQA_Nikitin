package ifellow.example.test;

import ConfiguringBrowser.WebHooks;
import ifellow.example.pages.LoginPage;
import org.junit.jupiter.api.Test;

public class TestAuthorization extends WebHooks {


    @Test
    void fullScenario() {

        LoginPage loginPage = new LoginPage();
        loginPage.openPage()
                .login("AT5", "Qwerty123");

    }
}