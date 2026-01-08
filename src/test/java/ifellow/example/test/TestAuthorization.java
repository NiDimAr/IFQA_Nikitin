package ifellow.example.test;

import ConfiguringBrowser.Config;
import ConfiguringBrowser.WebHooks;
import ifellow.example.pages.LoginPage;
import org.junit.jupiter.api.Test;

public class TestAuthorization extends WebHooks {


    @Test
    void fullScenario() {

        LoginPage loginPage = new LoginPage();
        loginPage.login(Config.login, Config.password);

    }
}