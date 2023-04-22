package Model.Entities.BaseEntity.Animal.Omnivorous;

import Model.Entities.BaseEntity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@NoArgsConstructor
@Getter
@Setter
public class Duck extends Omnivorous{
    private String name;
    private String icon;
    private  double maxWeight = 1.0;
    private int maxRangeToMove = 4;
    private int maxCountInTheLocation = 200;
    private  double foodInKgToFull = 0.15;
    @JsonIgnore
    private  double feelingOfSatiety = 0.075;
    @JsonIgnore
    private boolean isReproducible = true;
    @JsonIgnore
    private int steps = 0;
    private Map<String, Integer> eatingMap;
    @JsonIgnore
    private String pathToJsonFile = "src/Resources/DuckSettings.json";
    @JsonIgnore
    private int numberOfTryingToEat = 2;

    public Duck(String name) {
        this.setName(name);
    }


    @Override
    public BaseEntity createEntity() {
        return new Duck("Duck");
    }

}
