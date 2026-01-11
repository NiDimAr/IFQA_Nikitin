package org.RickAndMorty.Api;

import org.RickAndMorty.Models.Episode;

import static io.restassured.RestAssured.given;

public class EpisodeApi {
    public static Episode getEpisodeByUrl(String url) {
        return given()
                .when()
                .get(url)
                .then()
                .statusCode(200)
                .extract()
                .as(Episode.class);
    }
}
