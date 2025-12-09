package ifellow.example.Locators;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$x;

@Getter
public class LocatorTaskSearch {

    private final SelenideElement SearchTask = $x("//input[@placeholder='Поиск' and @name='searchString' and @type='text']");
    private final SelenideElement TaskTitle = $x("//h1[contains(@class,'editable-field')]");
    private final SelenideElement StatusTask = $x("//span[contains(@class, 'jira-issue-status-lozenge') and text()='Сделать']");
    private final SelenideElement StatusVersion = $x("//a[@title='Version 2.0 ' and text()='Version 2.0']");
    private final SelenideElement ViewAllRelevantIssues = $x("//span[@aria-tooltip='Просмотр всех подходящих проблем' and text()='Просмотр всех подходящих проблем']");
}
