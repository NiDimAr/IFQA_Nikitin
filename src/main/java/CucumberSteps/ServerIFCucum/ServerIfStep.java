package CucumberSteps.ServerIFCucum;

import ServerIF_HW5.Steps.AuthSteps;
import ServerIF_HW5.models.AuthRequest;
import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Тогда;

import static config.ConfigReader.config;


public class ServerIfStep {
    private AuthRequest user;
    private String token;

    @Дано("создан пользователь с корректными данными")
    public void createUser() {
        user = new AuthRequest();
        user.setUsername(config.user());
        user.setPassword(config.password());
    }

    @Тогда("пользователь успешно регистрируется")
    public void registerUser() {
        AuthSteps.registerUser(user);
    }

    @Тогда("попытка логина с неверным логином")
    public void loginWithWrongUsername() {
        AuthSteps.loginWithWrongUsername("wrongUser", user.getPassword());
    }

    @Тогда("попытка логина с неверным паролем")
    public void loginWithWrongPassword() {
        AuthSteps.loginWithWrongPassword(user.getUsername(), "wrongPassword");
    }

    @Тогда("пользователь успешно логинится")
    public void loginUser() {
        token = AuthSteps.login(user);
    }

    @Тогда("выход с неверным токеном завершается ошибкой")

    public void logoutWithInvalidToken() {
        AuthSteps.logout("00000000-0000-0000-0000-000000000000", false);
    }

    @Тогда("пользователь успешно выходит из системы")

    public void logoutUser() {

        AuthSteps.logout(token, true);
    }
}
