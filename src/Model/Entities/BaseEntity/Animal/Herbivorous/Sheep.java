package Model.Entities.BaseEntity.Animal.Herbivorous;

import Model.Entities.BaseEntity.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Sheep extends Herbivorous{
    private double maxWeight = 70.0;
    private int maxRangeToMove = 3;
    private int maxCountInTheLocation = 150;
    private double foodInKgToFull = 15.0;
    private double feelingOfSatiety = 7.5;
    private int steps = 0;
    private boolean isReproducible = true;
    private int numberOfTryingToEat = 5;
    private String pathToJsonFile = "src/Resources/SheepSettings.json";

    public Sheep(String name) {
        this.setName(name);
    }

    @Override
    public BaseEntity createEntity() {
        return new Sheep("Sheep");
    }
}
