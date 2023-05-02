package Model.Entities.BaseEntity.Animal.Herbivorous;

import Model.Entities.BaseEntity.BaseEntity;
import Resources.Constants;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Caterpillar extends Herbivorous {
    private String name;
    private String icon;
    private double maxWeight;
    private int maxCountInTheLocation;
    private int maxRangeToMove;
    private boolean isReproducible = true;
    private String pathToJsonFile = Constants.pathToCaterpillarJsonFile;

    public Caterpillar(String icon, double maxWeight, int maxCountInTheLocation, int maxRangeToMove) {
        this.icon = icon;
        this.maxWeight = maxWeight;
        this.maxCountInTheLocation = maxCountInTheLocation;
        this.maxRangeToMove = maxRangeToMove;
    }

    @Override
    public BaseEntity createEntity() {
        return new Caterpillar();
    }

}
