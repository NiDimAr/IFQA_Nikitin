package ifellow.example.test;

import ConfiguringBrowser.Utils;
import ConfiguringBrowser.WebHooks;
import ifellow.example.Locators.LocatorCreateBagPage;
import ifellow.example.pages.CreateBagPage;
import ifellow.example.pages.LoginPage;
import ifellow.example.pages.ProjectPage;
import ifellow.example.pages.TaskSearchPage;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.sleep;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestCreateBag extends WebHooks {
    @Test
    void Scenario() {

        LoginPage loginPage = new LoginPage();
        ProjectPage projectPage = new ProjectPage();
        TaskSearchPage taskSearchPage = new TaskSearchPage();
        CreateBagPage createBagPage = new CreateBagPage();
        LocatorCreateBagPage locatorCreateBagPage = new LocatorCreateBagPage();

        loginPage.openPage()
                .login("AT5", "Qwerty123");

        projectPage.openProject("Test");

        projectPage.switchTheFilter();

        ProjectPage taskPage = new ProjectPage();
        boolean isCreated = taskPage.createTask("Garag");

        assertTrue(isCreated);


        taskSearchPage.openProjectBySearch("TestSeleniumATHomework");
        taskSearchPage.CheckingStatuses();


        createBagPage.TapCreate();
        createBagPage.DropDownField(locatorCreateBagPage.getProjectBag(), "Test");
        createBagPage.DropDownField(locatorCreateBagPage.getTaskType(), "Ошибка");
        createBagPage.FillingInATextField(locatorCreateBagPage.getTheSubjectField(), "BYM");
        createBagPage.CheckField(locatorCreateBagPage.getBottonVisualDescription());
        createBagPage.fillTinyMCE(locatorCreateBagPage.getDescriptionField(), "BagBym");
        createBagPage.ClickVersion(locatorCreateBagPage.getFixInVersions());
        Utils.scrollPageByWheel(0, 1000);
        createBagPage.DropDownField(locatorCreateBagPage.getTegBag(), "High");
        Utils.scrollPageByWheel(0, 1000);
        createBagPage.FillingInATextField(locatorCreateBagPage.getMarker(), "Test");
        Utils.scrollPageByWheel(0, 1000);
        createBagPage.CheckField(locatorCreateBagPage.getBottonVisualEnvironment());
        createBagPage.fillTinyMCE(locatorCreateBagPage.getEnvironmentField(), "BagBym");
        createBagPage.ClickVersion(locatorCreateBagPage.getAffectedInVersions());
        Utils.scrollPageByWheel(0, 500);
        createBagPage.ClickSeriousness(locatorCreateBagPage.getClickSeriousness(), locatorCreateBagPage.getClickSignificant());
        locatorCreateBagPage.getClickCreateBag().should(visible)
                .click();
        taskSearchPage.openProjectBySearch("BYM");
        createBagPage.theEndOfWork(locatorCreateBagPage.getClickBusinessProcesses(), locatorCreateBagPage.getClickBusinessProcessesDone(), locatorCreateBagPage.getStatusBusinessProcesses());
        sleep(35000);


    }
}
