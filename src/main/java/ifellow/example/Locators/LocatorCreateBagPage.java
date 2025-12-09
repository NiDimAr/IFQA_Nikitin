package ifellow.example.Locators;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$x;

@Getter
public class LocatorCreateBagPage {
    private final SelenideElement ClickCreate = $x("//a[contains(@class, 'create-issue') and text()='Создать']");
    private final SelenideElement createTaskHeading = $x("//h2[text()='Создание задачи']");
    private final SelenideElement ProjectBag = $x("//div[contains(@class, 'aui-ss') and contains(@class, 'project-ss')]//input[@role='combobox']");
    private final SelenideElement TaskType = $x("//div[contains(@class, 'aui-ss') and contains(@class, 'issuetype-ss')]//input[@role='combobox']");
    private final SelenideElement TheSubjectField = $x("//input[@name='summary' and contains(@class, 'text') and contains(@class, 'long-field')]");
    private final SelenideElement BottonVisualDescription = $x("//button[contains(@class, 'aui-button') and text()='Визуальный']");
    private final SelenideElement DescriptionField = $x("//iframe[contains(@class, 'tox-edit-area__iframe')][1]");
    private final SelenideElement FixInVersions = $x("//select[@id='fixVersions']//optgroup[@label='Невыпущенные версии']//option[@value='10001' and normalize-space()='Version 2.0']");
    private final SelenideElement TegBag = $x("//div[contains(@class, 'aui-ss-select')]//input[@role='combobox' and @aria-label='Приоритет']");
    private final SelenideElement Marker = $x("//textarea[@id='labels-textarea' and @role='combobox' and @aria-autocomplete='list']");
    private final SelenideElement BottonVisualEnvironment = $x("(//li[@data-mode='wysiwyg']/button[text()='Визуальный'])[2]");
    private final SelenideElement EnvironmentField = $x("//iframe[@id='mce_9_ifr']");
    private final SelenideElement AffectedInVersions = $x("//select[@id='versions']//optgroup[@label='Невыпущенные версии']//option[@value='10001']");
    private final SelenideElement ClickSeriousness = $x("//select[@class='select cf-select']");
    private final SelenideElement ClickSignificant = $x("//select[@name='customfield_10400']/option[@value='10102']");
    private final SelenideElement ClickCreateBag = $x("//input[@type='submit' and @value='Создать' and contains(@class,'aui-button-primary')]");
    private final SelenideElement ClickBusinessProcesses = $x("//span[@class='dropdown-text' and normalize-space()='Бизнес-процесс']");
    private final SelenideElement ClickBusinessProcessesDone = $x("//a[normalize-space()='Выполнено' or .//span[normalize-space()='Выполнено']]");
    private final SelenideElement StatusBusinessProcesses = $x("//span[contains(@class,'jira-issue-status-lozenge')]");
}
