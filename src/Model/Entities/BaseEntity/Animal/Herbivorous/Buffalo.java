package Model.Entities.BaseEntity.Animal.Herbivorous;

import Model.Entities.BaseEntity.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Buffalo extends Herbivorous{
    private double maxWeight = 700.0;
    private int maxRangeToMove = 3;
    private int maxCountInTheLocation = 10;
    private double foodInKgToFull = 100.0;
    private double feelingOfSatiety = 50.0;
    private int steps = 0;
    private boolean isReproducible = true;
    private int numberOfTryingToEat = 20;
    private String pathToJsonFile = "src/Resources/BuffaloSettings.json";

    public Buffalo(String name) {
        this.setName(name);
    }

    @Override
    public BaseEntity createEntity() {
        return new Buffalo("Buffalo");
    }
}
