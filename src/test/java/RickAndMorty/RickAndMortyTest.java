package RickAndMorty;

import RickAndMorty.Api.CharacterApi;
import RickAndMorty.Api.EpisodeApi;
import RickAndMorty.Models.Character;
import RickAndMorty.Models.Episode;
import org.junit.Test;

import static org.junit.Assert.*;

public class RickAndMortyTest {
    @Test
    public void checkLastEpisodeLastCharacter() {


        Character morty =
                CharacterApi.getCharacterByName("Morty Smith");

        String mortySpecies = morty.getSpecies();
        String mortyLocation = morty.getLocation() != null
                ? morty.getLocation().getName()
                : null;


        assertNotNull(morty.getEpisode());
        assertFalse(morty.getEpisode().isEmpty());

        String lastEpisodeUrl =
                morty.getEpisode().get(morty.getEpisode().size() - 1);

        Episode episode =
                EpisodeApi.getEpisodeByUrl(lastEpisodeUrl);

        String lastCharacterUrl =
                episode.getCharacters()
                        .get(episode.getCharacters().size() - 1);

        Character lastCharacter =
                CharacterApi.getCharacterByUrl(lastCharacterUrl);

        String lastCharacterLocation = lastCharacter.getLocation() != null
                ? lastCharacter.getLocation().getName()
                : null;

        assertNotEquals(
                mortySpecies,
                lastCharacter.getSpecies()
        );

        assertNotEquals(
                mortyLocation,
                lastCharacterLocation
        );
    }
}
