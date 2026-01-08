package ifellow.example.test;

import ConfiguringBrowser.Config;
import ConfiguringBrowser.WebHooks;
import ifellow.example.pages.LoginPage;
import ifellow.example.pages.ProjectPage;
import org.junit.jupiter.api.Test;

public class TestProjectTest extends WebHooks {

    @Test
    void Scenario() {

        LoginPage loginPage = new LoginPage();
        ProjectPage projectPage = new ProjectPage();


        loginPage.login(Config.login, Config.password);


        projectPage.openProject(Config.project);

    }
}
