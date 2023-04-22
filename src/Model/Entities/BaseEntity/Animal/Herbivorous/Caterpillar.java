package Model.Entities.BaseEntity.Animal.Herbivorous;

import Model.Entities.BaseEntity.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Caterpillar extends Herbivorous {
    private static final double MAX_WEIGHT = 0.01;
    private int maxRangeToMove = 0;
    private int maxCountInTheLocation = 1000;
    public static final int MAX_COUNT = 1000;
    private final double FOOD_TO_FULL = 0;
    private double feelingOfSatiety = 0;
    private boolean isReproducible = true;
    private int steps = 0;
    private int numberOfTryingToEat = 0;
    private String pathToJsonFile = "src/Resources/CaterpillarSettings.json";

    public Caterpillar(String name) {
        this.setName(name);
    }

    @Override
    public BaseEntity createEntity() {
        return new Caterpillar("Caterpillar");
    }

}
