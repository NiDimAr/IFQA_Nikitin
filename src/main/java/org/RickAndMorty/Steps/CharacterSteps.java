package org.RickAndMorty.Steps;

import org.RickAndMorty.Api.CharacterApi;
import org.RickAndMorty.Models.Character;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

public class CharacterSteps {

    public static Character morty() {
        Character morty = CharacterApi.getCharacterByName("Morty Smith");
        assertNotNull("Morty not found", morty);

        StepsUtils.printList("Morty episodes", morty.getEpisode());

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