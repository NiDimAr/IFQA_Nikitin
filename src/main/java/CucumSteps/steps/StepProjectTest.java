package CucumSteps.steps;

import ifellow.example.pages.ProjectPage;
import io.cucumber.java.ru.Тогда;
import utils.Config;

public class StepProjectTest {

    private final ProjectPage projectPage = new ProjectPage();


    @Тогда("Я открываю проект")
    public void openProject() {
        projectPage.openProject(Config.getProject());
    }
}
