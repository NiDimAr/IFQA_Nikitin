package ifellow.example.pages;

import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$x;


public class LoginPage {
    private final SelenideElement usernameInput = $x("//input[contains(@class, 'medium-field') and @name='os_username']").as("Поле имя пользователя");
    private final SelenideElement passwordInput = $x("//input[contains(@class, 'medium-field') and @name='os_password']").as("Поле Пароль");
    private final SelenideElement submitButton = $x("//input[contains(@class, 'aui-button aui-button-primary') and @value='Войти']").as("Кнопка Войти");
    private final SelenideElement dashboardTitle = $x("//h3[contains(@class, 'dashboard-item-title') and text()='Назначенные мне']").as("Таблица назначенных задач строка с надписью Назначенные мне");


    public LoginPage login(String username, String password) {
        usernameInput.setValue(username);
        passwordInput.setValue(password);
        submitButton.click();
        dashboardTitle.shouldHave(text("Назначенные мне"), Duration.ofSeconds(5));
        return this;
    }
}

