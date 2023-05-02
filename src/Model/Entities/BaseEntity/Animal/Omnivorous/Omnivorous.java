package Model.Entities.BaseEntity.Animal.Omnivorous;

import Model.Entities.BaseEntity.Animal.Animal;
import Model.Entities.BaseEntity.Animal.Herbivorous.Caterpillar;
import Model.Entities.BaseEntity.BaseEntity;
import Model.Entities.BaseEntity.Plant;
import Services.FileReadService;
import Services.RandomService;

import java.util.List;
public abstract class Omnivorous extends Animal {
    @Override
    public void eat(List<BaseEntity> entityList) {
        List<BaseEntity> food = entityList.stream().filter(x -> x instanceof Caterpillar
                || x instanceof Plant).toList();
        double foodInKgToFull = FileReadService.readFoodInKgToFull(this);
        int numberOfTryingToEat = 10;
        for (int i = 0; i < numberOfTryingToEat; i++) {
            if (getFeelingOfSatiety() < foodInKgToFull && food.size() > 0) {
                int index = RandomService.getNumber(0, food.size());
                BaseEntity entity = food.get(index);
                if (entity.isAlive()) {
                    int chanceToEat = FileReadService.chanceToEat(this,entity);
                    int chance = RandomService.getNumber(0, 100);
                    if (chance < chanceToEat) {
                        setFeelingOfSatiety((Math.min((getFeelingOfSatiety() + FileReadService.readMaxWeight(this)),
                                foodInKgToFull)));
                        entity.setAlive(false);
                    }
                }
            }
        }
    }
}
