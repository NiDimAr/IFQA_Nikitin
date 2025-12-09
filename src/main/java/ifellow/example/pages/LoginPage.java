package ifellow.example.pages;

import com.codeborne.selenide.WebDriverRunner;
import ifellow.example.Locators.LocatorLoginPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;


public class LoginPage {
    private final LocatorLoginPage locatorLoginPage = new LocatorLoginPage();

    public LoginPage openPage() {
        open("https://edujira.ifellow.ru");
        WebDriverRunner.getWebDriver().manage().window().maximize();
        return this;
    }

    public LoginPage login(String username, String password) {
        locatorLoginPage.getUsernameInput().setValue(username);
        locatorLoginPage.getPasswordInput().setValue(password);
        locatorLoginPage.getSubmitButton().click();
        locatorLoginPage.getDashboardTitle().shouldHave(text("Назначенные мне"));
        return this;
    }
}

