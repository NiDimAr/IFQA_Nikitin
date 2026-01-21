package ifellow.example.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$x;


public class TaskSearchPage {

    private final SelenideElement searchTask = $x("//input[@placeholder='Поиск' and @name='searchString' and @type='text']").as("Строка поиска");
    private final SelenideElement taskTitle = $x("//h1[contains(@class,'editable-field')]").as("Название таска");
    private final SelenideElement statusTask = $x("//span[contains(@class, 'jira-issue-status-lozenge') and text()='Сделать']").as("Статус задачи");
    private final SelenideElement statusVersion = $x("//a[@title='Version 2.0 ' and text()='Version 2.0']").as("Статус версии");
    private final SelenideElement viewAllRelevantIssues = $x("//span[@aria-tooltip='Просмотр всех подходящих проблем' and text()='Просмотр всех подходящих проблем']").as("После ввода в поиск появляется данная кнопка");

    @Step("Поиск задачи")
    public void openProjectBySearch(String projectName) {
        searchTask.setValue(projectName);
        viewAllRelevantIssues.shouldHave(visible).click();
        taskTitle.shouldHave(visible).shouldHave(text(projectName));
    }

    @Step("Проверка статусов задачи")
    public void CheckingStatuses() {
        statusTask.shouldHave(exactText("Сделать"));
        statusVersion.shouldHave(exactText(" Version 2.0"));
    }
}
