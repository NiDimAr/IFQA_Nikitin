package ifellow.example.pages;

import ifellow.example.Locators.LocatorTaskSearch;

import static com.codeborne.selenide.Condition.*;


public class TaskSearchPage {
    private final LocatorTaskSearch locatorTaskSearch = new LocatorTaskSearch();

    public TaskSearchPage openProjectBySearch(String projectName) {
        locatorTaskSearch.getSearchTask().setValue(projectName);
        locatorTaskSearch.getViewAllRelevantIssues().shouldHave(visible).click();
        locatorTaskSearch.getTaskTitle()
                .shouldHave(visible)
                .shouldHave(text(projectName));


        return this;
    }

    public TaskSearchPage CheckingStatuses() {
        locatorTaskSearch.getStatusTask().shouldHave(exactText("Сделать"));
        locatorTaskSearch.getStatusVersion().shouldHave(exactText(" Version 2.0"));
        return this;
    }
}
