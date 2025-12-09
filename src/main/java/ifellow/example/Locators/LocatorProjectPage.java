package ifellow.example.Locators;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$x;

@Getter
public class LocatorProjectPage {
    private final SelenideElement buttonTest = $x("//a[contains(@class, 'aui-icon-container') and contains(., 'Test')]");
    private final SelenideElement buttonProject = $x("//a[contains(@class,'aui-nav-link') and contains(@title,'Просмотр недавних проектов')]");
    private final SelenideElement openTasks = $x("//a[@href='/issues/' and contains(text(),'Посмотреть все задачи и фильтры')]");
    private final SelenideElement tasksCounter = $x("//div[@class='showing']/span");
    private final SelenideElement buttonSwitchFilter = $x("//button[contains(@class,'subnavigator-trigger') and contains(@class,'aui-button')]");
    private final SelenideElement buttonAllTasks = $x("//a[@aria-checked='false' and @data-item-id='allissues']");
    private final SelenideElement vseZadachi = $x("//span[contains(@class, 'subnavigator-title') and text()='Все задачи']");
    private final SelenideElement ButtonCreateTask = $x("//button[.//span[contains(text(), 'Создать задачу')]]");
    private final SelenideElement InputSummary = $x("//textarea[@name='summary']");
    private final SelenideElement Refresh = $x("//span[contains(@class,'aui-iconfont-refresh-small') and contains(text(),'Обновить результаты')]");
}


