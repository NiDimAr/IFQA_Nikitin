package ifellow.example.test;

import ConfiguringBrowser.Config;
import ConfiguringBrowser.WebHooks;
import ifellow.example.pages.CreateBagPage;
import ifellow.example.pages.LoginPage;
import ifellow.example.pages.ProjectPage;
import ifellow.example.pages.TaskSearchPage;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestCreateBag extends WebHooks {
    @Test
    void Scenario() {
        LoginPage loginPage = new LoginPage();
        ProjectPage projectPage = new ProjectPage();
        TaskSearchPage taskSearchPage = new TaskSearchPage();
        CreateBagPage createBagPage = new CreateBagPage();

        loginPage.login(Config.getLogin(), Config.getPassword());
        projectPage.openProject(Config.getProject());
        projectPage.switchTheFilter();

        ProjectPage taskPage = new ProjectPage();
        boolean isCreated = taskPage.createTask("Garag");
        assertTrue(isCreated);

        taskSearchPage.openProjectBySearch("TestSeleniumATHomework");
        taskSearchPage.CheckingStatuses();

        createBagPage.TapCreate();
        createBagPage.DropDownField(createBagPage.getProjectBag(), Config.getProject());
        createBagPage.DropDownField(createBagPage.getTaskType(), "Ошибка");
        createBagPage.FillingInATextField(createBagPage.getTheSubjectField(), "BYM");
        createBagPage.CheckField(createBagPage.getBottonVisualDescription());
        createBagPage.fillTinyMCE(createBagPage.getDescriptionField(), "BagBym");
        createBagPage.ClickVersion(createBagPage.getFixInVersions());
        createBagPage.DropDownField(createBagPage.getTegBag(), "High");
        createBagPage.FillingInATextField(createBagPage.getMarker(), Config.getProject());
        createBagPage.CheckField(createBagPage.getBottonVisualEnvironment());
        createBagPage.fillTinyMCE(createBagPage.getEnvironmentField(), "BagBym");
        createBagPage.ClickVersion(createBagPage.getAffectedInVersions());
        createBagPage.ClickSeriousness(createBagPage.getClickSeriousness(), createBagPage.getClickSignificant());
        createBagPage.getClickCreateBag().should(visible).click();
        taskSearchPage.openProjectBySearch("BYM");
        createBagPage.theEndOfWork(createBagPage.getClickBusinessProcesses(),
                createBagPage.getClickBusinessProcessesDone(),
                createBagPage.getStatusBusinessProcesses());
    }
}