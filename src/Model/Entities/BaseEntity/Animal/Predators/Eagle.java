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

import java.util.Map;
@Getter
@Setter
@NoArgsConstructor
public class Eagle extends Predator{
    private String name;
    private String icon;
    private double maxWeight = 6.0;
    private int maxRangeToMove = 3;
    private int maxCountInTheLocation = 20;
    private double foodInKgToFull = 1.0;
    @JsonIgnore
    private double feelingOfSatiety = 0.5;
    @JsonIgnore
    private int steps = 0;
    @JsonIgnore
    private boolean isReproducible = true;
    private Map<String, Integer> eatingMap;
    @JsonIgnore
    private String pathToJsonFile = "src/Resources/EagleSettings.json";

    public Eagle(String name) {
        this.setName(name);
    }


    @Override
    public BaseEntity createEntity() {
        return new Eagle("Eagle");
    }


}
