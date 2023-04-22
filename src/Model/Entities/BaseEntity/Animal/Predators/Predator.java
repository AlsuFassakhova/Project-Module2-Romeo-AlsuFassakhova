package Model.Entities.BaseEntity.Animal.Predators;

import Model.Entities.BaseEntity.Animal.Animal;

import Model.Entities.BaseEntity.BaseEntity;

import Services.FileReadService;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Random;

@Getter
@Setter
public abstract class Predator extends Animal {

    @Override
    public void eat(List<BaseEntity> entityList) {
        int numberOfTryingToEat = 4;
        Random random = new Random();
        for (int i = 0; i < numberOfTryingToEat; i++) {
            if (getFeelingOfSatiety() < getFoodInKgToFull() && entityList.size() > 0) {
                int index = random.nextInt(0, entityList.size());
                BaseEntity hb = entityList.get(index);
                if (hb.isAlive()) {
                    int chanceToEat = FileReadService.chanceToEat(this,hb);
                    int chance = random.nextInt(0, 100);
                    if (chance < chanceToEat) {
                        setFeelingOfSatiety((Math.min((getFeelingOfSatiety() + hb.getMaxWeight()),
                                getFoodInKgToFull())));
                        hb.setAlive(false);
                    }
                }
            }
        }
    }
}



