package ifellow.example.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$x;


public class ProjectPage {
    private final SelenideElement buttonTest = $x("//a[contains(@class, 'aui-icon-container') and contains(., 'Test')]").as("Раздел Тест");
    private final SelenideElement buttonProject = $x("//a[contains(@class,'aui-nav-link') and contains(@title,'Просмотр недавних проектов')]").as("Кнопка Проекты");
    private final SelenideElement openTasks = $x("//a[@href='/issues/' and contains(text(),'Посмотреть все задачи и фильтры')]").as("Кнопка Посмотреть все задачи и фильтры");
    private final SelenideElement tasksCounter = $x("//div[@class='showing']/span").as("Количество задач");
    private final SelenideElement buttonSwitchFilter = $x("//button[contains(@class,'subnavigator-trigger') and contains(@class,'aui-button')]").as("Кнопка Переключить фильтр");
    private final SelenideElement buttonAllTasks = $x("//a[@aria-checked='false' and @data-item-id='allissues']").as("Кнопка Все задачи");
    private final SelenideElement vseZadachi = $x("//span[contains(@class, 'subnavigator-title') and text()='Все задачи']").as("Строка рядом с фильтром. Все задачи");
    private final SelenideElement buttonCreateTask = $x("//button[.//span[contains(text(), 'Создать задачу')]]").as("Кнопка Создать задачу");
    private final SelenideElement inputSummary = $x("//textarea[@name='summary']").as("Поле ввода для описания задачи");
    private final SelenideElement refresh = $x("//span[contains(@class,'aui-iconfont-refresh-small') and contains(text(),'Обновить результаты')]").as("Кнопка обновить");

    @Step("Открываем проект")
    public void openProject() {
        buttonProject
                .should(appear)
                .click();
        buttonTest.click();
        openTasks.shouldHave(text("Посмотреть все задачи и фильтры"));
    }

    @Step("Проверка открытия проекта")
    public boolean isProjectOpened() {
        return openTasks.isDisplayed();
    }
    @Step("Переключаем фильтр на все задачи")
    public void switchTheFilter() {
        buttonSwitchFilter.click();
        buttonAllTasks.click();
        vseZadachi.shouldHave(exactText("Все задачи"));
        refresh.click();
    }

    public boolean isAllTasksVisible() {
        return vseZadachi.isDisplayed() && vseZadachi.getText().equals("Все задачи");
    }

    public int getTasksTotalCount() {
        String text = tasksCounter.getText();
        int index = text.indexOf("из");
        String rightPart = text.substring(index + 2).trim();
        return Integer.parseInt(rightPart);
    }

    @Step("Создание задачи и счетчик")
    public boolean createTask(String summary) {
        int oldCount = getTasksTotalCount();
        String oldText = tasksCounter.getText();
        buttonCreateTask.shouldBe(visible).click();
        inputSummary.setValue(summary).pressEnter();
        tasksCounter.shouldNotHave(exactText(oldText));
        int newCount = getTasksTotalCount();
        return oldCount < newCount;
    }
}