package CucumSteps.steps;

import ifellow.example.pages.Config;
import ifellow.example.pages.LoginPage;
import ifellow.example.pages.ProjectPage;
import io.cucumber.java.ru.Когда;

public class StepCommon {
    LoginPage loginPage = new LoginPage();
    ProjectPage projectPage = new ProjectPage();

    @Когда("я ввожу логин и пароль")
    public void Login() {
        loginPage.login(Config.login, Config.password);
    }

    @Когда("Пользователь включает фильтр")
    public void SwitchTheFilter() {
        projectPage.switchTheFilter();
    }
}