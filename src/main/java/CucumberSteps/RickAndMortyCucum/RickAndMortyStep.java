package CucumberSteps.RickAndMortyCucum;

import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Тогда;
import org.RickAndMorty.Models.Character;
import org.RickAndMorty.Steps.CharacterSteps;

import static org.junit.Assert.assertNotNull;

public class RickAndMortyStep {

    private Character morty;
    private String lastEpisodeUrl;

    @Дано("получаем персонажа Морти")
    public void GivenMorty() {
        morty = CharacterSteps.morty();
        assertNotNull(morty);
    }

    @Тогда("получаем ссылку на последний эпизод персонажа")
    public void lastEpisode() {
        lastEpisodeUrl = CharacterSteps.lastEpisodeUrl(morty);
        assertNotNull(lastEpisodeUrl);
    }
}

