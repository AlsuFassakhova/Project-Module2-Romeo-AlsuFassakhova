package Model.Entities.BaseEntity.Animal.Herbivorous;

import Model.Entities.BaseEntity.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Rabbit extends Herbivorous {
    private double maxWeight = 2.0;
    private int maxRangeToMove = 2;
    private int maxCountInTheLocation = 160;
    private double foodInKgToFull = 0.45;
    private double feelingOfSatiety = 0.2;
    private int steps = 0;
    private boolean isReproducible = true;
    private int numberOfTryingToEat = 1;
    private String pathToJsonFile = "src/Resources/RabbitSettings.json";

    public Rabbit(String name) {
        this.setName(name);
    }

    @Override
    public BaseEntity createEntity() {
        return new Rabbit("Rabbit");
    }
}
