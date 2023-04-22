package Model.Entities.BaseEntity.Animal.Herbivorous;

import Model.Entities.BaseEntity.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Deer extends Herbivorous{
    private double maxWeight = 300;
    private int maxRangeToMove = 4;
    private int maxCountInTheLocation = 20;
    private double foodInKgToFull = 50;
    private double feelingOfSatiety = 25;
    private int steps = 0;
    private boolean isReproducible = true;
    private int numberOfTryingToEat = 10;
    private String pathToJsonFile = "src/Resources/DeerSettings.json";

    public Deer(String name) {
        this.setName(name);
    }

    @Override
    public BaseEntity createEntity() {
        return new Deer("Deer");
    }
}
