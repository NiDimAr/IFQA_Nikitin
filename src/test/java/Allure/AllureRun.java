package Allure;

import ConfiguringBrowser.Config;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;

public class AllureRun {
    @BeforeAll
    static void addAllureListener() {
        SelenideLogger.addListener(
                "allure",
                new AllureSelenide()
                        .screenshots(Config.isAllureScreenshots())
                        .savePageSource(Config.isAllureSavePageSource())

        );
    }
}
