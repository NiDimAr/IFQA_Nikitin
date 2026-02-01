package Hooks;

import io.cucumber.java.Before;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;

public class Hooks {
    @Before
    public void setup() {
        RestAssured.replaceFiltersWith(new AllureRestAssured());
    }
}
