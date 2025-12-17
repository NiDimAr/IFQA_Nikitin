package RickAndMorty.Api;

import RickAndMorty.Models.Episode;
import RickAndMorty.Specs.ResponseSpec;

import static io.restassured.RestAssured.given;

public class EpisodeApi {
    public static Episode getEpisodeByUrl(String url) {
        return given()
                .when()
                .get(url)
                .then()
                .spec(ResponseSpec.success200())
                .extract()
                .as(Episode.class);
    }
}
