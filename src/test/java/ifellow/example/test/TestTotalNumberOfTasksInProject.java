package ifellow.example.test;

import ConfiguringBrowser.WebHooks;
import ifellow.example.pages.LoginPage;
import ifellow.example.pages.ProjectPage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class TestTotalNumberOfTasksInProject extends WebHooks {
    @Test
    void Scenario() {

        LoginPage loginPage = new LoginPage();
        ProjectPage projectPage = new ProjectPage();


        loginPage.login("AT5", "Qwerty123");


        projectPage.openProject("Test");

        projectPage.switchTheFilter();


        ProjectPage taskPage = new ProjectPage();
        boolean isCreated = taskPage.createTask("BUMP");

        assertTrue(isCreated);


    }
}
