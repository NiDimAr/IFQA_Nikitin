package CucumSteps.steps;

import ifellow.example.pages.ProjectPage;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class StepTotalNumber {
    private final ProjectPage projectPage = new ProjectPage();
    private boolean taskCreated;


    @Когда("я открываю проект {string}")
    public void iOpenProject(String projectName) {
        projectPage.openProject(projectName);
    }

    @Когда("я переключаю фильтр")
    public void iSwitchTheFilter() {
        projectPage.switchTheFilter();
    }

    @Когда("я создаю задачу с именем {string}")
    public void iCreateTask(String taskName) {
        taskCreated = projectPage.createTask(taskName);
    }

    @Тогда("я вижу, что задача создана успешно")
    public void iShouldSeeTaskCreated() {
        assertTrue(taskCreated, "Task was not created successfully");
    }
}
