package ConfiguringBrowser;

import Allure.AllureRun;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import java.io.File;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class WebHooks extends AllureRun {

    @BeforeAll
    public static void setUpAll() {

        String driverPath = Config.getChromeDriver() + File.separator + "chromedriver-" + Config.getDriverVersion() + ".exe";
        File driverFile = new File(driverPath);
        if (driverFile.exists() && driverFile.canExecute()) {
            System.setProperty("webdriver.chrome.driver", driverFile.getAbsolutePath());
        }

        Configuration.browser = Config.getBrowser();
        Configuration.browserSize = null;
        Configuration.timeout = Config.getTimeout();
        Selenide.open(Config.getBaseUrl());
        WebDriverRunner.getWebDriver().manage().window().maximize();
    }

    @AfterEach
    @Step("Закрытие браузера")
    void tearDown() {

        closeWebDriver();
    }
}
