package Model.Entities.BaseEntity.Animal.Herbivorous;

import Model.Entities.BaseEntity.Animal.Animal;
import Model.Entities.BaseEntity.BaseEntity;
import Model.Entities.BaseEntity.Plant;
import Services.FileReadService;

import java.util.List;


public abstract class Herbivorous extends Animal {

    @Override
    public void eat(List<BaseEntity> entityList) {
        List<BaseEntity> plantList = entityList.stream().filter(BaseEntity::isAlive).toList();
        int tryingToEat = Math.min(getNumberOfTryingToEat(),plantList.size());
        double foodInKgToFull = FileReadService.readFoodInKgToFull(this);
        for (int i = 0; i < tryingToEat; i++) {
            if (getFeelingOfSatiety() == foodInKgToFull) break;
            Plant plant = (Plant) plantList.get(i);
            setFeelingOfSatiety(Math.min((getFeelingOfSatiety() + FileReadService.readMaxWeight(plant)), foodInKgToFull));
            plant.setAlive(false);
        }
    }
}




