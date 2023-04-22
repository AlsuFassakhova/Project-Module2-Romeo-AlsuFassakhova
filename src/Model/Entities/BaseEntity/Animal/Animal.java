package Model.Entities.BaseEntity.Animal;

import Interfaces.Eatable;
import Interfaces.Movable;
import Model.Entities.BaseEntity.BaseEntity;
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

    public int getRandom(int origin, int bound) {
        Random random = new Random();
        return random.nextInt(origin, bound);
    }

    @Override
    public List<BaseEntity> reproduction(List<BaseEntity> entityList) {
        List<BaseEntity> newEntity = new ArrayList<>();
        if (isReproducible()) {
            BaseEntity partner = null;
            for (var animal : entityList) {
                if (animal!=this&&animal.getClass().equals(this.getClass()) && animal.isReproducible()) {
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
        int range = getRandom(1, getMaxRangeToMove() + 1);
        int direction = getRandom(0, 4);
        setFeelingOfSatiety(getFeelingOfSatiety()-getFoodInKgToFull()*0.25);
        if(getFeelingOfSatiety()<=0)setAlive(false);
        return new int[]{direction, range};
    }


}

