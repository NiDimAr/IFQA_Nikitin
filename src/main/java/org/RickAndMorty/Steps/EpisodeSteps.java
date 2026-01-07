package org.RickAndMorty.Steps;

import org.RickAndMorty.Api.CharacterApi;
import org.RickAndMorty.Api.EpisodeApi;
import org.RickAndMorty.Models.Character;
import org.RickAndMorty.Models.Episode;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

public class EpisodeSteps {

    public static Episode lastEpisode(String episodeUrl) {
        Episode episode = EpisodeApi.getEpisodeByUrl(episodeUrl);
        assertNotNull("Episode not found", episode);


        StepsUtils.printList("Characters in episode " + episode.getName(), episode.getCharacters());

        return episode;
    }

    public static Character lastCharacter(Episode episode) {
        assertNotNull(episode.getCharacters());
        assertFalse(episode.getCharacters().isEmpty());

        String url = episode.getCharacters()
                .get(episode.getCharacters().size() - 1);

        Character character = CharacterApi.getCharacterByUrl(url);
        assertNotNull("Character not found", character);


        return character;
    }
}