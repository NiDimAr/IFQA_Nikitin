package RickAndMorty.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Character {
    private String name;
    private String species;
    private Location location;
    private List<String> episode;
}
