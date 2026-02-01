package ifellow.example.test;

import ConfiguringBrowser.WebHooks;
import config.ConfigReader;
import ifellow.example.pages.LoginPage;
import ifellow.example.pages.ProjectPage;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Epic("Управление задачами")
@Feature("Счётчик задач в проекте")
@Owner("Дмитрий")
@DisplayName("Проверка счетчика задач")
public class TestTotalNumberOfTasksInProject extends WebHooks {

    @Test
    @Story("Создание задачи и проверка общего количества задач в проекте")
    @DisplayName("Проверка счетчика задач")
    @Tag("ID-3")
    void Scenario() {

        LoginPage loginPage = new LoginPage();
        ProjectPage projectPage = new ProjectPage();

        loginPage.login(ConfigReader.config.login(), ConfigReader.config.password());

        projectPage.openProject();

        projectPage.switchTheFilter();
        boolean isFilterSwitched = projectPage.isAllTasksVisible();
        assertTrue(isFilterSwitched, "Фильтр 'Все задачи' не переключился!");

        boolean isCreated = projectPage.createTask(ConfigReader.config.Namebug());
        assertTrue(isCreated);


    }
}
