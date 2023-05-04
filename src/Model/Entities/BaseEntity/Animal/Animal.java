package Model.Entities.BaseEntity.Animal;

import Interfaces.Eatable;
import Interfaces.Movable;
import Interfaces.Reproducible;
import Model.Entities.BaseEntity.BaseEntity;
import Services.FileReadService;
import Services.RandomService;
import lombok.Getter;
import lombok.Setter;

import java.util.*;


@Getter
@Setter
public abstract class Animal extends BaseEntity implements Movable, Eatable, Reproducible {
    private double foodInKgToFull;
    private double feelingOfSatiety = foodInKgToFull * 0.5;
    private int numberOfTryingToEat;
    private Map<String, Integer> eatingMap;

    public Animal reproduction(List<BaseEntity> entityList) {
        if (isReproducible()) {
            BaseEntity partner = null;
            for (var animal : entityList) {
                if (animal != this && animal.getClass().equals(this.getClass()) && animal.isReproducible()) {
                    partner = animal;
                    break;
                }
            }
            if (partner != null) {
                setReproducible(false);
                partner.setReproducible(false);
                return (Animal) createEntity();
            }
        }
        return null;
    }

    public int[] move() {
        int range = RandomService.getNumber(1, FileReadService.readMaxRangeToMove(this) + 1);
        int direction = RandomService.getNumber(0, 4);
        double energyDown = FileReadService.readFoodInKgToFull(this)/4;
        setFeelingOfSatiety(getFeelingOfSatiety() - energyDown);
        if (getFeelingOfSatiety() <= 0) setAlive(false);
        return new int[]{direction, range};
    }


}

