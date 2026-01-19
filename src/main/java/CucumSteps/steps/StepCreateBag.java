package CucumSteps.steps;

import ifellow.example.pages.CreateBagPage;
import ifellow.example.pages.ProjectPage;
import ifellow.example.pages.TaskSearchPage;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import org.junit.jupiter.api.Assertions;
import utils.Config;

public class StepCreateBag {
    ProjectPage projectPage = new ProjectPage();
    TaskSearchPage taskSearchPage = new TaskSearchPage();
    CreateBagPage createBagPage = new CreateBagPage();

    @Тогда("Пользователь открывает")
    public void OpenProject() {
        projectPage.openProject(Config.getProject());
    }

    @Тогда("Пользователь создает задачу {string}")
    public void IsCreated(String taskName) {
        boolean isCreated = projectPage.createTask(taskName);
        Assertions.assertTrue(isCreated);
    }

    @Когда("Пользователь создает баг {string}")
    public void CreateBagPage(String bagName) {
        createBagPage.TapCreate();
        createBagPage.DropDownField(createBagPage.getProjectBag(), Config.getProject());
        createBagPage.DropDownField(createBagPage.getTaskType(), "Ошибка");
        createBagPage.FillingInATextField(createBagPage.getTheSubjectField(), bagName);
        createBagPage.CheckField(createBagPage.getBottonVisualDescription());
        createBagPage.fillTinyMCE(createBagPage.getDescriptionField(), "BagBym");
        createBagPage.ClickVersion(createBagPage.getFixInVersions());
        createBagPage.DropDownField(createBagPage.getTegBag(), "High");
        createBagPage.FillingInATextField(createBagPage.getMarker(), Config.getProject());
        createBagPage.CheckField(createBagPage.getBottonVisualEnvironment());
        createBagPage.fillTinyMCE(createBagPage.getEnvironmentField(), "BagBym");
        createBagPage.ClickVersion(createBagPage.getAffectedInVersions());
        createBagPage.ClickSeriousness(createBagPage.getClickSeriousness(), createBagPage.getClickSignificant());
        createBagPage.getClickCreateBag().click();
    }

    @Тогда("Баг успешно создан")
    public void BagCreate() {
        Assertions.assertTrue(createBagPage.getClickCreateBag().exists());
    }

    @Тогда("Пользователь проверяет баг в проекте")
    public void OpenProjectBySearch() {
        taskSearchPage.openProjectBySearch("BYM");
        createBagPage.theEndOfWork(createBagPage.getClickBusinessProcesses(),
                createBagPage.getClickBusinessProcessesDone(),
                createBagPage.getStatusBusinessProcesses());
    }
}
