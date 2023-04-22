package Model.Entities.BaseEntity.Animal.Omnivorous;

import Model.Entities.BaseEntity.Animal.Animal;
import Model.Entities.BaseEntity.Animal.Herbivorous.Caterpillar;
import Model.Entities.BaseEntity.BaseEntity;
import Model.Entities.BaseEntity.Plant;
import Services.FileReadService;

import java.util.List;
import java.util.Random;

public abstract class Omnivorous extends Animal {
    private int numberOfTryingToEat;

    @Override
    public void eat(List<BaseEntity> entityList) {
        List<BaseEntity> food = entityList.stream().filter(x -> x instanceof Caterpillar
                || x instanceof Plant).toList();
        int numberOfTryingToEat = 4;
        Random random = new Random();
        for (int i = 0; i < numberOfTryingToEat; i++) {
            if (getFeelingOfSatiety() < getFoodInKgToFull() && food.size() > 0) {
                int index = random.nextInt(0, food.size());
                BaseEntity entity = food.get(index);
                if (entity.isAlive()) {
                    int chanceToEat = FileReadService.chanceToEat(this,entity);
                    int chance = random.nextInt(0, 100);
                    if (chance < chanceToEat) {
                        setFeelingOfSatiety((Math.min((getFeelingOfSatiety() + entity.getMaxWeight()),
                                getFoodInKgToFull())));
                        entity.setAlive(false);
                    }
                }
            }
        }
    }
}
