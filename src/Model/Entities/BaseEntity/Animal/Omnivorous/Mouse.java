package Model.Entities.BaseEntity.Animal.Omnivorous;

import Model.Entities.BaseEntity.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@NoArgsConstructor
@Getter
@Setter
public class Mouse extends Omnivorous {
    private double maxWeight = 0.05;
    private int maxRangeToMove = 1;
    private int maxCountInTheLocation = 500;
    private double foodInKgToFull = 0.01;
    private double feelingOfSatiety = 0.005;
    private boolean isReproducible = true;
    private int steps = 0;
    private Map<String, Integer> eatingMap;
    private String pathToJsonFile = "src/Resources/MouseSettings.json";
    private int numberOfTryingToEat = 1;

    public Mouse(String name) {
        this.setName(name);
    }

    @Override
    public BaseEntity createEntity() {
        return new Mouse("Mouse");
    }


}
