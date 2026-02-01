package ifellow.example.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.Keys;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

@Getter
public class CreateBagPage {
    private final SelenideElement clickCreate = $x("//a[contains(@class, 'create-issue') and text()='Создать']").as("Кнопка создать задачу");
    private final SelenideElement createTaskHeading = $x("//h2[text()='Создание задачи']").as("Надпись сверху Создание задачи");
    private final SelenideElement projectBag = $x("//div[contains(@class, 'aui-ss') and contains(@class, 'project-ss')]//input[@role='combobox']").as("Поле проект");
    private final SelenideElement taskType = $x("//div[contains(@class, 'aui-ss') and contains(@class, 'issuetype-ss')]//input[@role='combobox']").as("Поле Тип задачи");
    private final SelenideElement theSubjectField = $x("//input[@name='summary' and contains(@class, 'text') and contains(@class, 'long-field')]").as("Поле тема");
    private final SelenideElement bottonVisualDescription = $x("//button[contains(@class, 'aui-button') and text()='Визуальный']").as("Кнопка Визуальный в поле описания");
    private final SelenideElement descriptionField = $x("//iframe[contains(@class, 'tox-edit-area__iframe')][1]").as("Поле Описание");
    private final SelenideElement fixInVersions = $x("//select[@id='fixVersions']//optgroup[@label='Невыпущенные версии']//option[@value='10001' and normalize-space()='Version 2.0']").as("Исправить в версиях Version 2.0");
    private final SelenideElement tegBag = $x("//div[contains(@class, 'aui-ss-select')]//input[@role='combobox' and @aria-label='Приоритет']").as("Поле Приоритет");
    private final SelenideElement marker = $x("//textarea[@id='labels-textarea' and @role='combobox' and @aria-autocomplete='list']").as("Поле метки");
    private final SelenideElement bottonVisualEnvironment = $x("(//li[@data-mode='wysiwyg']/button[text()='Визуальный'])[2]").as("Кнопка Визуальный в поле окружение");
    private final SelenideElement environmentField = $x("//label[contains(text(),'Окружение')]/following-sibling::div//iframe").as("Поле окружение");
    private final SelenideElement affectedInVersions = $x("//select[@id='versions']//optgroup[@label='Невыпущенные версии']//option[@value='10001']").as("Затронутые версии");
    private final SelenideElement clickSeriousness = $x("//select[@class='select cf-select']").as("Поле серьезность");
    private final SelenideElement clickSignificant = $x("//select[@name='customfield_10400']/option[@value='10102']").as("В поле серьезность. Значительный");
    private final SelenideElement clickCreateBag = $x("//input[@type='submit' and @value='Создать' and contains(@class,'aui-button-primary')]").as("Кнопка создать ");
    private final SelenideElement clickBusinessProcesses = $x("//span[@class='dropdown-text' and normalize-space()='Бизнес-процесс']").as("Кнопка Бизнес-процесс");
    private final SelenideElement clickBusinessProcessesDone = $x("//a[normalize-space()='Выполнено' or .//span[normalize-space()='Выполнено']]").as("Кнопка Бизнес-процесс. Статус Выполнено");
    private final SelenideElement statusBusinessProcesses = $x("//span[contains(@class,'jira-issue-status-lozenge')]").as("Статус бизнес процесса");

    TaskSearchPage taskSearchPage = new TaskSearchPage();

    @Step("Создание задачи")
    public void TapCreate() {
        clickCreate.click();
        createTaskHeading.should(appear);
    }

    @Step("Заполнение поля с выборкой")
    public void DropDownField(SelenideElement locator, String Name) {
        locator.scrollIntoView(true).click();
        locator.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        locator.sendKeys(Keys.DELETE);
        locator.setValue(Name).pressEnter();
        locator.shouldHave(value(Name));
    }

    @Step("Заполнение поля с выпадающим списоком")
    public void FillingInATextField(SelenideElement locator, String text) {
        locator.scrollIntoView(true).setValue(text);
        locator.shouldHave(value(text));
    }

    @Step("Проверка кнопки Визуальный")
    public void CheckField(SelenideElement locator) {
        locator.scrollIntoView(false);
        if (!"true".equals(locator.getAttribute("aria-pressed"))) {
            locator.click();
        }
        locator.shouldHave(attribute("aria-pressed", "true"));
    }

    @Step("Заполнение полей с редактором")
    public void fillTinyMCE(SelenideElement locator, String text) {
        locator.scrollIntoView(false);
        switchTo().frame(locator);
        SelenideElement body = $("body#tinymce");
        body.should(visible).setValue(text);
        body.shouldHave(text(text));
        switchTo().defaultContent();
    }

    @Step("Выбор версии")
    public void ClickVersion(SelenideElement locator) {
        locator.should(exist).shouldBe(visible, enabled).click();
        locator.shouldBe(selected, Duration.ofSeconds(5));
    }

    @Step("Выбор серьезности")
    public void ClickSeriousness(SelenideElement locator, SelenideElement locatorOption) {
        locator.should(visible).click();
        String value = locatorOption.getAttribute("value");
        locatorOption.should(visible)
                .click();
        locator.shouldHave(attribute("value", value));
    }

    @Step("Создание баг репорта")
    public void CreateReported() {
        getClickCreateBag().should(visible).click();
    }

    @Step("Закрытие задачи")
    public void theEndOfWork(SelenideElement locator, SelenideElement locatorOption, SelenideElement locatorStatus) {
        locator.should(appear, Duration.ofSeconds(10)).click();
        locatorOption.shouldBe(visible)
                .click();
        locatorStatus.shouldBe(visible)
                .shouldHave(text("Готово"));
    }

    @Step("Создание баг-репорта BYM")
    public void createBagBym(String projectName, String taskTypeName, String summary, String description, String environment, String priority) {

        TapCreate();

        DropDownField(getProjectBag(), projectName);
        DropDownField(getTaskType(), taskTypeName);
        FillingInATextField(getTheSubjectField(), summary);
        CheckField(getBottonVisualDescription());
        fillTinyMCE(getDescriptionField(), description);
        ClickVersion(getFixInVersions());
        DropDownField(getTegBag(), priority);
        FillingInATextField(getMarker(), projectName);
        CheckField(getBottonVisualEnvironment());
        fillTinyMCE(getEnvironmentField(), environment);
        ClickVersion(getAffectedInVersions());
        ClickSeriousness(getClickSeriousness(), getClickSignificant());
        CreateReported();

        taskSearchPage.openProjectBySearch(summary);
        taskSearchPage.CheckingStatuses();
        theEndOfWork(getClickBusinessProcesses(), getClickBusinessProcessesDone(), getStatusBusinessProcesses());
    }
}