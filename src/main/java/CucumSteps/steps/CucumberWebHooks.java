package CucumSteps.steps;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import ifellow.example.pages.Config;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class CucumberWebHooks {
    @Before
    public void setUpScenario() {
        System.setProperty("webdriver.chrome.driver", Config.chromeDriverPath);
        Configuration.browser = Config.browser;
        Configuration.browserSize = null;
        Configuration.timeout = Config.timeout;
        Selenide.open(Config.baseUrl);
        WebDriverRunner.getWebDriver().manage().window().maximize();
    }

    @After
    public void tearDownScenario() {
        closeWebDriver();
    }
}
