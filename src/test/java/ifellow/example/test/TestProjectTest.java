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

@Epic("Управление проектами")
@Feature("Открытие проекта и проверка статусов")
@Owner("Дмитрий")
@DisplayName("Тестирование открытия проекта и проверка статусов")
public class TestProjectTest extends WebHooks {

    @Test
    @Story("Пользователь открывает проект и проверяет, что проект доступен")
    @DisplayName("Тестирование открытия проекта и проверка статусов")
    @Tag("ID-2")
    void Scenario() {

        LoginPage loginPage = new LoginPage();
        ProjectPage projectPage = new ProjectPage();

        loginPage.login(ConfigReader.config.login(), ConfigReader.config.password());

        projectPage.openProject();

        boolean isProjectOpened = projectPage.isProjectOpened();
        assertTrue(isProjectOpened, "Проект не открылся: кнопка 'Посмотреть все задачи и фильтры' не отображается!");
    }
}
