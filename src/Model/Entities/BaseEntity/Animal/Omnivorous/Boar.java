package Model.Entities.BaseEntity.Animal.Omnivorous;

import Model.Entities.BaseEntity.Animal.Herbivorous.Caterpillar;
import Model.Entities.BaseEntity.BaseEntity;
import Model.Entities.BaseEntity.Plant;

import Resources.Constants;
import Services.FileReadService;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.List;
import java.util.Map;
import java.util.Random;

@NoArgsConstructor
@Getter
@Setter
public class Boar extends Omnivorous {
    private String name;
    private String icon;
    private double maxWeight;
    private int maxCountInTheLocation;
    private int maxRangeToMove;
    private double foodInKgToFull;
    private double feelingOfSatiety = foodInKgToFull * 0.5;
    private boolean isReproducible = true;
    private int steps = 0;
    private Map<String, Integer> eatingMap;
    private String pathToJsonFile = Constants.pathToBoarJsonFile;
    private int numberOfTryingToEat = 8;

    public Boar(String icon, double maxWeight, int maxCountInTheLocation, int maxRangeToMove, double foodInKgToFull) {
        this.icon = icon;
        this.maxWeight = maxWeight;
        this.maxCountInTheLocation = maxCountInTheLocation;
        this.maxRangeToMove = maxRangeToMove;
        this.foodInKgToFull = foodInKgToFull;
    }

    @Override
    public BaseEntity createEntity() {
        return new Boar();
    }


    @Override
    public void eat(List<BaseEntity> entityList) {
        List<BaseEntity> food = entityList.stream().filter(x -> x instanceof Caterpillar
                || x instanceof Mouse || x instanceof Plant).toList();
        int numberOfTryingToEat = 4;
        Random random = new Random();
        for (int i = 0; i < numberOfTryingToEat; i++) {
            if (getFeelingOfSatiety() < getFoodInKgToFull() && food.size() > 0) {
                int index = random.nextInt(0, food.size());
                BaseEntity entity = food.get(index);
                if (entity.isAlive()) {
                    int chance = random.nextInt(0, 100);
                    int chanceToEat = FileReadService.chanceToEat(this, entity);
                    if (chance < chanceToEat) {
                        setFeelingOfSatiety((Math.min((getFeelingOfSatiety() + entity.getMaxWeight()), getFoodInKgToFull())));
                        entity.setAlive(false);
                    }
                }
            }
        }
    }
}

