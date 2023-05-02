package Model.Entities.BaseEntity.Animal.Predators;

import Model.Entities.BaseEntity.BaseEntity;
import Resources.Constants;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@NoArgsConstructor
@Getter
@Setter
public class Bear extends Predator {
    private String name;
    private String icon;
    private double maxWeight;
    private int maxCountInTheLocation;
    private int maxRangeToMove;
    private double foodInKgToFull;
    private double feelingOfSatiety = foodInKgToFull * 0.5;
    private int steps = 0;
    private boolean isReproducible = true;
    private Map<String, Integer> eatingMap;
    private String pathToJsonFile = Constants.pathToBearJsonFile;

    public Bear(String icon, double maxWeight, int maxCountInTheLocation, int maxRangeToMove, double foodInKgToFull) {
        this.icon = icon;
        this.maxWeight = maxWeight;
        this.maxCountInTheLocation = maxCountInTheLocation;
        this.maxRangeToMove = maxRangeToMove;
        this.foodInKgToFull = foodInKgToFull;
    }

    @Override
    public BaseEntity createEntity() {
        return new Bear();
    }


}



