package ifellow.example.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Param;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.SetValueOptions.withText;
import static io.qameta.allure.model.Parameter.Mode.HIDDEN;


public class LoginPage {
    private final SelenideElement usernameInput = $x("//input[contains(@class, 'medium-field') and @name='os_username']").as("Поле имя пользователя");
    private final SelenideElement passwordInput = $x("//input[contains(@class, 'medium-field') and @name='os_password']").as("Поле Пароль");
    private final SelenideElement submitButton = $x("//input[contains(@class, 'aui-button aui-button-primary') and @value='Войти']").as("Кнопка Войти");
    private final SelenideElement dashboardTitle = $x("//h3[contains(@class, 'dashboard-item-title') and text()='Назначенные мне']").as("Таблица назначенных задач строка с надписью Назначенные мне");

    @Step("Вход в учетку {username}")
    public LoginPage login(String username, @Param(mode = HIDDEN) String password) {
        usernameInput.shouldBe(visible).setValue(username);
        passwordInput.shouldBe(visible).setValue(withText(password).sensitive());
        submitButton.shouldBe(visible).click();
        dashboardTitle.shouldHave(text("Назначенные мне"));
        return this;

    }

}

