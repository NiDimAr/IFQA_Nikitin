package ConfiguringBrowser;

import Allure.AllureRun;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import config.ConfigReader;
import io.qameta.allure.Step;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import java.io.File;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class WebHooks extends AllureRun {

    @BeforeAll
    public static void setUpAll() {

        String version = ConfigReader.config.driverVersion();
        String path = ConfigReader.config.chromeDriver()
                + File.separator
                + "chromedriver" + version + ".exe";

        File driverFile = new File(path);

        if (driverFile.exists()) {
            System.setProperty("webdriver.chrome.driver", driverFile.getAbsolutePath());
        }

        Configuration.browser = ConfigReader.config.browser();
        Configuration.browserSize = null;
        Configuration.timeout = ConfigReader.config.timeout();
        Selenide.open(ConfigReader.config.baseUrl());
        WebDriverRunner.getWebDriver().manage().window().maximize();

    }

    @AfterEach
    @Step("Закрытие браузера")
    void tearDown() {
        closeWebDriver();
    }

}
