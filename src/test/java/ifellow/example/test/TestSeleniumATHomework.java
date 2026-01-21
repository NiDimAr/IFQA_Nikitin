package ifellow.example.test;

import ConfiguringBrowser.Config;
import ConfiguringBrowser.WebHooks;
import ifellow.example.pages.LoginPage;
import ifellow.example.pages.ProjectPage;
import ifellow.example.pages.TaskSearchPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestSeleniumATHomework extends WebHooks {
    @Test
    @DisplayName("Переход к таске TestSeleniumATHomework")
    void Scenario() {

        LoginPage loginPage = new LoginPage();
        ProjectPage projectPage = new ProjectPage();
        TaskSearchPage taskSearchPage = new TaskSearchPage();

        loginPage.login(Config.getLogin(), Config.getPassword());

        projectPage.openProject(Config.getProject());

        projectPage.switchTheFilter();

        boolean isIncreased = projectPage.createTask("Garag");
        assertTrue(isIncreased);

        taskSearchPage.openProjectBySearch("TestSeleniumATHomework");
        taskSearchPage.CheckingStatuses();
    }
}

