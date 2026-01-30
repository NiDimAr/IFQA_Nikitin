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
    public void получен_персонаж_морти() {
        morty = CharacterSteps.morty();
    }

    @Тогда("получен последний эпизод Морти")
    public void получен_последний_эпизод_морти() {
        lastEpisode = EpisodeSteps.lastEpisode(
                CharacterSteps.lastEpisodeUrl(morty)
        );
    }

    @Тогда("получен последний персонаж эпизода")
    public void получен_последний_персонаж_эпизода() {
        lastCharacter = EpisodeSteps.lastCharacter(lastEpisode);
    }

    @Тогда("вид персонажей совпадает")
    public void вид_персонажей_совпадает() {
        assertEquals(
                morty.getSpecies(),
                lastCharacter.getSpecies()
        );
    }

    @Тогда("локации персонажей не совпадают")
    public void локации_персонажей_не_совпадают() {
        assertNotEquals(
                morty.getLocation().getName(),
                lastCharacter.getLocation().getName()
        );
    }
}

