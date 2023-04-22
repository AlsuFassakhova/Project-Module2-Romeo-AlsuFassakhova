package Model.Entities.BaseEntity.Animal.Herbivorous;

import Model.Entities.BaseEntity.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Goat extends Herbivorous {
    private double maxWeight = 60.0;
    private int maxRangeToMove = 3;
    private int maxCountInTheLocation = 140;
    private double foodInKgToFull = 10.0;
    private double feelingOfSatiety = 5.0;
    private int steps = 0;
    private boolean isReproducible = true;
    private int numberOfTryingToEat = 3;
    private String pathToJsonFile = "src/Resources/GoatSettings.json";
    public Goat(String name) {
        this.setName(name);
    }

    @Override
    public BaseEntity createEntity() {
        return new Goat("Goat");
    }
}
