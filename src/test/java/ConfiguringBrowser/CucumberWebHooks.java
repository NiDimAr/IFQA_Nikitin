package ConfiguringBrowser;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.Config;

import java.io.File;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class CucumberWebHooks {

    @Before
    public void setUpScenario() {
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

    @After
    public void tearDownScenario() {
        closeWebDriver();

    }
}
