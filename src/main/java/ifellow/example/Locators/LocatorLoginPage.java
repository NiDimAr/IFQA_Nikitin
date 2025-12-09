package ifellow.example.Locators;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$x;

@Getter
public class LocatorLoginPage {
    private final SelenideElement usernameInput = $x("//input[contains(@class, 'medium-field') and @name='os_username']");
    private final SelenideElement passwordInput = $x("//input[contains(@class, 'medium-field') and @name='os_password']");
    private final SelenideElement submitButton = $x("//input[contains(@class, 'aui-button aui-button-primary') and @value='Войти']");
    private final SelenideElement dashboardTitle = $x("//h3[contains(@class, 'dashboard-item-title') and text()='Назначенные мне']");
}