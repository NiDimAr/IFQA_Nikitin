package CucumSteps.steps;

import ifellow.example.pages.Config;
import ifellow.example.pages.ProjectPage;
import io.cucumber.java.ru.Тогда;

public class StepProjectTest {

    private final ProjectPage projectPage = new ProjectPage();


    @Тогда("Я открываю проект")
    public void openProject() {
        projectPage.openProject(Config.project);
    }
}
