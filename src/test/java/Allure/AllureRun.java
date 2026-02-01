package Allure;

import com.codeborne.selenide.logevents.SelenideLogger;
import config.ConfigReader;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;

public class AllureRun {
    @BeforeAll
    static void addAllureListener() {
        SelenideLogger.addListener(
                "allure",
                new AllureSelenide()
                        .screenshots(ConfigReader.config.allureScreenshots())
                        .savePageSource(ConfigReader.config.allureSavePageSource())

        );
    }
}
