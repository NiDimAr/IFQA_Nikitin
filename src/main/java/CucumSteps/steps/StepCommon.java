package CucumSteps.steps;

import ifellow.example.pages.LoginPage;
import ifellow.example.pages.ProjectPage;
import io.cucumber.java.ru.Когда;
import utils.Config;

public class StepCommon {
    LoginPage loginPage = new LoginPage();
    ProjectPage projectPage = new ProjectPage();

    @Когда("я ввожу логин и пароль")
    public void Login() {
        loginPage.login(Config.getLogin(), Config.getPassword());
    }

    @Когда("Пользователь включает фильтр")
    public void SwitchTheFilter() {
        projectPage.switchTheFilter();
    }
}