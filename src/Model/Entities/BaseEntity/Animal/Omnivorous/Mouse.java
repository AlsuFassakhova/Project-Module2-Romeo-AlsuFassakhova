package Model.Entities.BaseEntity.Animal.Omnivorous;

import Model.Entities.BaseEntity.BaseEntity;
import Resources.Constants;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@NoArgsConstructor
@Getter
@Setter
public class Mouse extends Omnivorous {
    private String name;
    private String icon;
    private double maxWeight;
    private int maxCountInTheLocation;
    private int maxRangeToMove;
    private double foodInKgToFull;
    private double feelingOfSatiety = foodInKgToFull*0.5;
    private boolean isReproducible = true;
    private int steps = 0;
    private Map<String, Integer> eatingMap;
    private String pathToJsonFile = Constants.pathToMouseJsonFile;
    private int numberOfTryingToEat = 1;

    public Mouse(String icon, double maxWeight, int maxCountInTheLocation, int maxRangeToMove, double foodInKgToFull) {
        this.icon = icon;
        this.maxWeight = maxWeight;
        this.maxCountInTheLocation = maxCountInTheLocation;
        this.maxRangeToMove = maxRangeToMove;
        this.foodInKgToFull = foodInKgToFull;
    }

    @Override
    public BaseEntity createEntity() {
        return new Mouse();
    }


}
