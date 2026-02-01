package ifellow.example.test;

import ConfiguringBrowser.WebHooks;
import config.ConfigReader;
import ifellow.example.pages.LoginPage;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Тестирование авторизации")
@Epic("Управление пользователями")
@Feature("Авторизация")
@Owner("Дмитрий")
public class TestAuthorization extends WebHooks {

    @Test
    @Story("Вход пользователя в систему")
    @DisplayName("Тестирование авторизации")
    @Tag("ID-1")
    void fullScenario() {

        LoginPage loginPage = new LoginPage();
        loginPage.login(ConfigReader.config.login(), ConfigReader.config.password());
        boolean isLoggedIn = loginPage.isDashboardVisible();
        assertTrue(isLoggedIn, "Авторизация не прошла: дашборд не отображается!");
    }

}