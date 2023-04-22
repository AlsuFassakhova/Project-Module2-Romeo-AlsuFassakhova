package Model.Entities.BaseEntity.Animal.Predators;

import Model.Entities.BaseEntity.Animal.Herbivorous.Herbivorous;
import Model.Entities.BaseEntity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.File;
import java.io.IOException;
import java.util.Map;
@Getter
@Setter
@NoArgsConstructor
public class Boa extends Predator {
    private String name;
    private String icon;
    private double maxWeight = 50.0;
    private int maxRangeToMove = 3;
    private int maxCountInTheLocation = 30;
    private double foodInKgToFull = 8.0;
    @JsonIgnore
    private double feelingOfSatiety = 4.0;
    @JsonIgnore
    private int steps = 0;
    @JsonIgnore
    private boolean isReproducible = true;
    private Map<String, Integer> eatingMap;
    @JsonIgnore
    private String pathToJsonFile = "src/Resources/BoaSettings.json";

    public Boa(String name) {
        this.setName(name);
    }


    @Override
    public BaseEntity createEntity() {
        return new Boa("Boa");
    }

}
