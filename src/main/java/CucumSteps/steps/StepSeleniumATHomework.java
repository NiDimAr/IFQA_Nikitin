package CucumSteps.steps;

import ifellow.example.pages.ProjectPage;
import ifellow.example.pages.TaskSearchPage;
import io.cucumber.java.ru.Тогда;
import org.junit.jupiter.api.Assertions;
import utils.Config;

public class StepSeleniumATHomework {
    ProjectPage projectPage = new ProjectPage();
    TaskSearchPage taskSearchPage = new TaskSearchPage();


    @Тогда("Пользователь открывает проект")
    public void OpenProject() {
        projectPage.openProject(Config.getProject());
    }

    @Тогда("Пользователь создает {string}")
    public void IsCreated(String taskName) {
        boolean isCreated = projectPage.createTask(taskName);
        Assertions.assertTrue(isCreated);
    }


    @Тогда("Пользователь проверяет статусы задач")
    public void OpenProjectBySearch() {
        taskSearchPage.openProjectBySearch("TestSeleniumATHomework");
        taskSearchPage.CheckingStatuses();
    }
}
