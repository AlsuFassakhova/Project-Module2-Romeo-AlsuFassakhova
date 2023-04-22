package Model.Entities.BaseEntity.Animal.Predators;


import Model.Entities.BaseEntity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.Map;
@NoArgsConstructor
@Getter
@Setter
public class Fox extends Predator{
    private String name;
    private String icon;
    private double maxWeight = 8.0;
    private int maxRangeToMove = 2;
    private int maxCountInTheLocation = 30;
    private double foodInKgToFull = 2.0;
    @JsonIgnore
    private double feelingOfSatiety = 1.0;
    @JsonIgnore
    private int steps = 0;
    @JsonIgnore
    private boolean isReproducible = true;
    private Map<String, Integer> eatingMap;
    @JsonIgnore
    private String pathToJsonFile = "src/Resources/FoxSettings.json";

    public Fox(String name) {
        this.setName(name);
    }

    @Override
    public BaseEntity createEntity() {
        return new Fox("Fox");
    }



}
