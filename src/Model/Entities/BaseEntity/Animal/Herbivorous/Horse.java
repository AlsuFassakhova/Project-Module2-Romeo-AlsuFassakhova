package Model.Entities.BaseEntity.Animal.Herbivorous;


import Model.Entities.BaseEntity.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Getter
@Setter
public class Horse extends Herbivorous {
    private double maxWeight = 400;
    private int maxRangeToMove = 4;
    private int maxCountInTheLocation = 20;
    private double foodInKgToFull = 60;
    private double feelingOfSatiety = 30;
    private int steps = 0;
    private boolean isReproducible = true;
    private int numberOfTryingToEat = 10;
    private String pathToJsonFile = "src/Resources/HorseSettings.json";

    public Horse(String name) {
        this.setName(name);
    }

    @Override
    public BaseEntity createEntity() {
        return new Horse("Horse");
    }

}



