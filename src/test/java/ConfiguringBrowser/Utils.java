package ConfiguringBrowser;

import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.interactions.Actions;

public class Utils {
    public static void scrollPageByWheel(int xOffset, int yOffset) {
        Actions actions = new Actions(WebDriverRunner.getWebDriver());
        actions.scrollByAmount(xOffset, yOffset).perform();
    }
}
