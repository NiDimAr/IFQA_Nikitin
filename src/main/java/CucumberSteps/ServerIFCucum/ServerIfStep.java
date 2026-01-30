package CucumberSteps.ServerIFCucum;

import Config.Config;
import ServerIF_HW5.Steps.AuthSteps;
import ServerIF_HW5.models.AuthRequest;
import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Тогда;

public class ServerIfStep {
    private AuthRequest user;
    private String token;

    @Дано("создан пользователь с корректными данными")
    public void создан_пользователь_с_корректными_данными() {
        user = new AuthRequest();
        user.setUsername(Config.USERNAME);
        user.setPassword(Config.PASSWORD);
    }

    @Тогда("пользователь успешно регистрируется")
    public void пользователь_успешно_регистрируется() {
        AuthSteps.registerUser(user);
    }

    @Тогда("попытка логина с неверным логином")
    public void попытка_логина_с_неверным_логином() {
        AuthSteps.loginWithWrongUsername("wrongUser", user.getPassword());
    }

    @Тогда("попытка логина с неверным паролем")
    public void попытка_логина_с_неверным_паролем() {
        AuthSteps.loginWithWrongPassword(user.getUsername(), "wrongPassword");
    }

    @Тогда("пользователь успешно логинится")
    public void пользователь_успешно_логинится() {
        token = AuthSteps.login(user);
    }

    @Тогда("выход с неверным токеном завершается ошибкой")
    public void выход_с_неверным_токеном_завершается_ошибкой() {
        AuthSteps.logout("00000000-0000-0000-0000-000000000000", false);
    }

    @Тогда("пользователь успешно выходит из системы")
    public void пользователь_успешно_выходит_из_системы() {
        AuthSteps.logout(token, true);
    }
}
