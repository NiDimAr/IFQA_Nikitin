package ifellow.example.test;

import ConfiguringBrowser.Config;
import ConfiguringBrowser.WebHooks;
import ifellow.example.pages.LoginPage;
import ifellow.example.pages.ProjectPage;
import ifellow.example.pages.TaskSearchPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestSeleniumATHomework extends WebHooks {
    @Test
    void Scenario() {

        LoginPage loginPage = new LoginPage();
        ProjectPage projectPage = new ProjectPage();
        TaskSearchPage taskSearchPage = new TaskSearchPage();


        loginPage.login(Config.login, Config.password);


        projectPage.openProject(Config.project);

        projectPage.switchTheFilter();


        boolean isIncreased = projectPage.createTask("Garag");
        Assertions.assertTrue(isIncreased);

        taskSearchPage.openProjectBySearch("TestSeleniumATHomework");
        taskSearchPage.CheckingStatuses();
    }
}

