package RickAndMorty.Api;

import RickAndMorty.Specs.RequestSpec;
import RickAndMorty.Specs.ResponseSpec;

import static io.restassured.RestAssured.given;

public class CharacterApi {
    public static RickAndMorty.Models.Character getCharacterByName(String name) {
        return given()
                .spec(RequestSpec.defaultSpec())
                .queryParam("name", name)
                .when()
                .get("/character")
                .then()
                .spec(ResponseSpec.success200())
                .extract()
                .jsonPath()
                .getObject("results[0]", RickAndMorty.Models.Character.class);
    }

    public static RickAndMorty.Models.Character getCharacterByUrl(String url) {
        return given()
                .when()
                .get(url)
                .then()
                .spec(ResponseSpec.success200())
                .extract()
                .as(RickAndMorty.Models.Character.class);
    }
}
