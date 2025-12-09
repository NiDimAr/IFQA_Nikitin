package ifellow.example.pages;

import ifellow.example.Locators.LocatorProjectPage;
import ifellow.example.Locators.LocatorTaskSearch;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.Wait;


public class ProjectPage {

    private final LocatorProjectPage locatorProjectPage = new LocatorProjectPage();
    private final LocatorTaskSearch locatorTaskSearch = new LocatorTaskSearch();

    public ProjectPage openProject(String name) {
        locatorProjectPage.getButtonProject()
                .should(appear)
                .click();

        locatorProjectPage.getButtonTest()

                .click();

        locatorProjectPage.getOpenTasks().shouldHave(text("Посмотреть все задачи и фильтры"));
        return this;
    }

    public ProjectPage switchTheFilter() {
        locatorProjectPage.getButtonSwitchFilter().click();
        locatorProjectPage.getButtonAllTasks().click();
        locatorProjectPage.getVseZadachi().shouldHave(exactText("Все задачи"));
        locatorProjectPage.getRefresh().click();
        return this;
    }

    public int getTasksTotalCount() {
        String text = locatorProjectPage.getTasksCounter().getText();
        int index = text.indexOf("из");
        String rightPart = text.substring(index + 2).trim();
        return Integer.parseInt(rightPart);
    }

    public boolean createTask(String summary) {

        int oldCount = getTasksTotalCount();

        locatorProjectPage.getButtonCreateTask().shouldBe(visible).click();

        locatorProjectPage.getInputSummary()
                .setValue(summary)
                .pressEnter();

        locatorTaskSearch.getTaskTitle()
                .shouldHave(visible)
                .shouldHave(text(summary));

        Wait().until(driver -> getTasksTotalCount() > oldCount);

        int newCount = getTasksTotalCount();

        return newCount > oldCount;
    }
}