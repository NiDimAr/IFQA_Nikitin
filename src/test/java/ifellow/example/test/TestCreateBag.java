package ifellow.example.test;

import ConfiguringBrowser.WebHooks;
import config.ConfigReader;
import ifellow.example.pages.CreateBagPage;
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

import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Тестирование создания баг репорта")
@Epic("Управление задачами")
@Feature("Создание баг-репорта")
@Owner("Дмитрий")
public class TestCreateBag extends WebHooks {

    @Test
    @Story("Пользователь создаёт баг и проверяет его статусы")
    @DisplayName("Тестирование создания баг репорта")
    @Tag("ID-5")
    void Scenario() {
        LoginPage loginPage = new LoginPage();
        ProjectPage projectPage = new ProjectPage();
        TaskSearchPage taskSearchPage = new TaskSearchPage();
        CreateBagPage createBagPage = new CreateBagPage();

        loginPage.login(ConfigReader.config.login(), ConfigReader.config.password());
        boolean isLoggedIn = loginPage.isDashboardVisible();
        assertTrue(isLoggedIn, "Авторизация не прошла: дашборд не отображается!");

        projectPage.openProject();
        boolean isProjectOpened = projectPage.isProjectOpened();
        assertTrue(isProjectOpened, "Проект не открылся: кнопка 'Посмотреть все задачи и фильтры' не отображается!");

        projectPage.switchTheFilter();

        boolean isCreated = projectPage.createTask(ConfigReader.config.Namebug());
        assertTrue(isCreated);

        taskSearchPage.openProjectBySearch(ConfigReader.config.Projectname());
        taskSearchPage.CheckingStatuses();

        createBagPage.createBagBym(
                ConfigReader.config.project(),
                ConfigReader.config.taskType(),
                ConfigReader.config.bugSummary(),
                ConfigReader.config.descriptionText(),
                ConfigReader.config.environmentText(),
                ConfigReader.config.priorityBug()
        );
    }
}