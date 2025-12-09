package ifellow.example.pages;

import com.codeborne.selenide.SelenideElement;
import ifellow.example.Locators.LocatorCreateBagPage;
import org.openqa.selenium.Keys;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

public class CreateBagPage {
    public final LocatorCreateBagPage locatorCreateBagPage = new LocatorCreateBagPage();

    public CreateBagPage TapCreate() {
        locatorCreateBagPage.getClickCreate().click();
        locatorCreateBagPage.getCreateTaskHeading().should(appear);

        return this;
    }

    public CreateBagPage DropDownField(SelenideElement locator, String Name) {
        locator.should(visible)
                .click();
        locator.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        locator.sendKeys(Keys.DELETE);

        locator
                .setValue(Name)
                .pressEnter();


        locator.shouldHave(value(Name));
        return this;

    }

    public CreateBagPage FillingInATextField(SelenideElement locator, String text) {
        locator.should(visible)
                .setValue(text);
        locator.shouldHave(value(text));
        return this;
    }

    public CreateBagPage CheckField(SelenideElement locator) {
        if (!"true".equals(locator.getAttribute("aria-pressed"))) {
            locator.click();
        }
        locator.shouldHave(attribute("aria-pressed", "true"));

        return this;
    }

    public CreateBagPage fillTinyMCE(SelenideElement locator, String text) {

        switchTo().frame(locator);

        SelenideElement body = $("body#tinymce");
        body.should(visible)
                .setValue(text);


        body.shouldHave(text(text));

        switchTo().defaultContent();

        return this;
    }

    public CreateBagPage ClickVersion(SelenideElement locator) {

        locator.should(exist).shouldBe(visible, enabled).click();

        locator.shouldBe(selected, Duration.ofSeconds(5));

        return this;
    }

    public CreateBagPage ClickSeriousness(SelenideElement locator, SelenideElement locatorOption) {
        locator.should(visible)
                .click();
        String value = locatorOption.getAttribute("value");

        locatorOption.should(visible)
                .click();

        locator.shouldHave(attribute("value", value));
        return this;
    }

    public CreateBagPage theEndOfWork(SelenideElement locator, SelenideElement locatorOption, SelenideElement locatorStatus) {
        locator.should(appear, Duration.ofSeconds(10)).click();

        locatorOption.shouldBe(visible)
                .click();

        locatorStatus.shouldBe(visible)
                .shouldHave(text("Готово"));
        return this;
    }
}
