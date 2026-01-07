package RickAndMorty;

import org.RickAndMorty.Models.Character;
import org.RickAndMorty.Models.Episode;
import org.RickAndMorty.Steps.CharacterSteps;
import org.RickAndMorty.Steps.EpisodeSteps;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class RickAndMortyTest {

    @Test
    public void shouldCompareMortyWithLastEpisodeCharacter() {

        Character morty = CharacterSteps.morty();

        Episode lastEpisode =
                EpisodeSteps.lastEpisode(CharacterSteps.lastEpisodeUrl(morty));

        Character lastCharacter =
                EpisodeSteps.lastCharacter(lastEpisode);

        assertEquals(
                morty.getSpecies(),
                lastCharacter.getSpecies()
        );

        assertNotEquals(
                morty.getLocation().getName(),
                lastCharacter.getLocation().getName()
        );
    }
}