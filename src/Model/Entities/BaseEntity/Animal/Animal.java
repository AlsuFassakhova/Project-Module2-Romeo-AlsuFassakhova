package Model.Entities.BaseEntity.Animal;

import Interfaces.Eatable;
import Interfaces.Movable;
import Model.Entities.BaseEntity.BaseEntity;
import Services.RandomService;
import lombok.Getter;
import lombok.Setter;

import java.util.*;


@Getter
@Setter
public abstract class Animal extends BaseEntity implements Movable, Eatable {
    private double foodInKgToFull;
    private double feelingOfSatiety;
    private int numberOfTryingToEat;
    private Map<String, Integer> eatingMap;

    @Override
    public List<BaseEntity> reproduction(List<BaseEntity> entityList) {
        List<BaseEntity> newEntity = new ArrayList<>();
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
                newEntity.add(createEntity());
            }
        }
        return newEntity;
    }

    public int[] move() {
        int range = RandomService.getNumber(1, getMaxRangeToMove() + 1);
        int direction = RandomService.getNumber(0, 4);
        setFeelingOfSatiety(getFeelingOfSatiety() - getFoodInKgToFull() * 0.25);
        if (getFeelingOfSatiety() <= 0) setAlive(false);
        return new int[]{direction, range};
    }


}

