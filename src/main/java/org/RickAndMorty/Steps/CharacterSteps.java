package org.RickAndMorty.Steps;

import org.RickAndMorty.Api.CharacterApi;
import org.RickAndMorty.Models.Character;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;


public class CharacterSteps {

    public static Character morty() {
        Character morty = CharacterApi.getCharacterByName("Morty Smith");
        assertNotNull(morty, "Morty not found");


        return morty;
    }

    public static String lastEpisodeUrl(Character character) {
        assertNotNull(character.getEpisode());
        assertFalse(character.getEpisode().isEmpty());
        String url = character.getEpisode()
                .get(character.getEpisode().size() - 1);
        System.out.println("Last episode URL: " + url);
        return url;
    }
}