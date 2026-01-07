package org.RickAndMorty.Api;

import org.RickAndMorty.Models.Character;
import org.RickAndMorty.Specs.RequestSpec;
import org.RickAndMorty.Specs.ResponseSpec;

import static io.restassured.RestAssured.given;

public class CharacterApi {
    public static Character getCharacterByName(String name) {
        return given()
                .spec(RequestSpec.defaultSpec())
                .queryParam("name", name)
                .when()
                .get("/character")
                .then()
                .spec(ResponseSpec.success200())
                .extract()
                .jsonPath()
                .getObject("results[0]", Character.class);
    }

    public static Character getCharacterByUrl(String url) {
        return given()
                .when()
                .get(url)
                .then()
                .spec(ResponseSpec.success200())
                .extract()
                .as(Character.class);
    }
}
