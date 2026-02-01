package org.RickAndMorty.Steps;

import org.RickAndMorty.Api.CharacterApi;
import org.RickAndMorty.Api.EpisodeApi;
import org.RickAndMorty.Models.Character;
import org.RickAndMorty.Models.Episode;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;


public class EpisodeSteps {

    public static Episode lastEpisode(String episodeUrl) {
        Episode episode = EpisodeApi.getEpisodeByUrl(episodeUrl);
        assertNotNull(episode, "Episode not found");

        return episode;
    }

    public static Character lastCharacter(Episode episode) {
        assertNotNull(episode.getCharacters());
        assertFalse(episode.getCharacters().isEmpty());

        String url = episode.getCharacters()
                .get(episode.getCharacters().size() - 1);

        Character character = CharacterApi.getCharacterByUrl(url);
        assertNotNull(character, "Character not found");


        return character;
    }
}