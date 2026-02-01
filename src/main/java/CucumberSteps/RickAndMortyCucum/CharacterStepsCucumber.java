package CucumberSteps.RickAndMortyCucum;

import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Тогда;
import org.RickAndMorty.Models.Character;
import org.RickAndMorty.Models.Episode;
import org.RickAndMorty.Steps.CharacterSteps;
import org.RickAndMorty.Steps.EpisodeSteps;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


public class CharacterStepsCucumber {

    private Character morty;
    private Episode lastEpisode;
    private Character lastCharacter;

    @Дано("получен персонаж Морти")
    public void PersonMorty() {
        morty = CharacterSteps.morty();
    }

    @Тогда("получен последний эпизод Морти")
    public void EpisodeMorty() {
        lastEpisode = EpisodeSteps.lastEpisode(
                CharacterSteps.lastEpisodeUrl(morty)
        );
    }

    @Тогда("получен последний персонаж эпизода")
    public void LastEpisode() {
        lastCharacter = EpisodeSteps.lastCharacter(lastEpisode);
    }

    @Тогда("вид персонажей совпадает")
    public void PersonAssert() {
        assertEquals(
                morty.getSpecies(),
                lastCharacter.getSpecies()
        );
    }

    @Тогда("локации персонажей не совпадают")
    public void LocationPerson() {
        assertNotEquals(
                morty.getLocation().getName(),
                lastCharacter.getLocation().getName()
        );
    }
}

