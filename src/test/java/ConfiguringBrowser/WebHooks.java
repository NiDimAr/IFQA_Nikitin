package ConfiguringBrowser;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class WebHooks {

    @BeforeAll
    static void setUpAll() {
        Configuration.browser = "chrome";
        Configuration.browserSize = null;
        Configuration.timeout = 8000;

    }

    @AfterEach
    void tearDown() {

        closeWebDriver();
    }
}