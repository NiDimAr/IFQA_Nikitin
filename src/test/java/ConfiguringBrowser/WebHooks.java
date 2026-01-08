package ConfiguringBrowser;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class WebHooks {

    @BeforeAll
    public static void setUpAll() {

        System.setProperty("webdriver.chrome.driver", Config.chromeDriverPath);
        Configuration.browser = Config.browser;
        Configuration.browserSize = null;
        Configuration.timeout = Config.timeout;
        open(Config.baseUrl);
        WebDriverRunner.getWebDriver().manage().window().maximize();

    }

    @AfterEach
    void tearDown() {

        closeWebDriver();
    }
}
