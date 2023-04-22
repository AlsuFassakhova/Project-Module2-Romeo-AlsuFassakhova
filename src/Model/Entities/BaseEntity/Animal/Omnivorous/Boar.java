package Model.Entities.BaseEntity.Animal.Omnivorous;

import Model.Entities.BaseEntity.Animal.Herbivorous.Caterpillar;
import Model.Entities.BaseEntity.BaseEntity;
import Model.Entities.BaseEntity.Plant;

import Services.FileReadService;
import com.fasterxml.jackson.annotation.JsonIgnore;

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
    private  double maxWeight = 400.0;
    private int maxRangeToMove = 2;
    private int maxCountInTheLocation = 50;
    private  double foodInKgToFull = 50.0;
    @JsonIgnore
    private  double feelingOfSatiety = 25.0;
    @JsonIgnore
    private boolean isReproducible = true;
    @JsonIgnore
    private int steps = 0;
    private Map<String, Integer> eatingMap;
    @JsonIgnore
    private String pathToJsonFile = "src/Resources/BoarSettings.json";
    @JsonIgnore
    private int numberOfTryingToEat = 8;

    public Boar(String name) {
        this.setName(name);
    }


    @Override
    public BaseEntity createEntity() {
        return new Boar("Boar");
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
                    int chanceToEat = FileReadService.chanceToEat(this,entity);
                    if (chance < chanceToEat) {
                        setFeelingOfSatiety((Math.min((getFeelingOfSatiety() + entity.getMaxWeight()), getFoodInKgToFull())));
                        entity.setAlive(false);
                    }
                }
            }
        }
    }
}

