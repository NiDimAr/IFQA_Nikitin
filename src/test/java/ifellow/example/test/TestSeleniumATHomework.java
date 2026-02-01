package ifellow.example.test;

import ConfiguringBrowser.WebHooks;
import config.ConfigReader;
import ifellow.example.pages.LoginPage;
import ifellow.example.pages.ProjectPage;
import ifellow.example.pages.TaskSearchPage;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Epic("Управление задачами")
@Feature("Переход к таске и проверка статусов")
@Owner("Дмитрий")
@DisplayName("Переход к таске TestSeleniumATHomework")
public class TestSeleniumATHomework extends WebHooks {

    @Test
    @Story("Пользователь создаёт таску и проверяет её статус")
    @DisplayName("Переход к таске TestSeleniumATHomework")
    @Tag("ID-4")
    void Scenario() {

        LoginPage loginPage = new LoginPage();
        ProjectPage projectPage = new ProjectPage();
        TaskSearchPage taskSearchPage = new TaskSearchPage();

        loginPage.login(ConfigReader.config.login(), ConfigReader.config.password());

        projectPage.openProject();

        projectPage.switchTheFilter();

        projectPage.createTask(ConfigReader.config.Namebug());

        taskSearchPage.openProjectBySearch(ConfigReader.config.Projectname());

        taskSearchPage.CheckingStatuses();
    }
}

