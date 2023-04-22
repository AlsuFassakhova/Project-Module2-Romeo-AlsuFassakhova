package Model.PlayingField;

import Interfaces.Movable;
import Model.Entities.BaseEntity.Animal.Herbivorous.*;
import Model.Entities.BaseEntity.Animal.Omnivorous.Boar;
import Model.Entities.BaseEntity.Animal.Omnivorous.Omnivorous;
import Model.Entities.BaseEntity.Animal.Predators.*;
import Model.Entities.BaseEntity.BaseEntity;
import Model.Entities.BaseEntity.Plant;
import Services.AnimalGeneratorServices.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Location {

    private int positionX;
    private int positionY;
    private List<BaseEntity> entityList;
    private int diedAnimals = 0;

    public Location(int positionX, int positionY, List<BaseEntity> entityList) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.entityList = entityList;
    }

    public int getRandom(int origin, int bound) {
        return ThreadLocalRandom.current().nextInt(origin, bound);
    }

    public void printEntitiesList() {
        int bearCount = 0;
        int wolfCount = 0;
        int horseCount = 0;
        int mouseCount = 0;
        int boarCount = 0;
        int plantCount = 0;
        int eagleCount = 0;
        for (var entity : entityList
        ) {
            Class<? extends BaseEntity> clazz = entity.getClass();
            if (entity instanceof Bear) {
                bearCount++;
            } else if (clazz.equals(Wolf.class)) {
                wolfCount++;
            } else if (clazz.equals(Horse.class)) {
                horseCount++;
            } else if (clazz.equals(Model.Entities.BaseEntity.Animal.Omnivorous.Mouse.class)) {
                mouseCount++;
            } else if (clazz.equals(Boar.class)) {
                boarCount++;
            } else if (clazz.equals(Plant.class)) {
                plantCount++;
            } else if (clazz.equals(Eagle.class)) {
                eagleCount++;
            }
        }
        System.out.printf("Bear: %s, Wolf: %s, Eagle: %s, Horse: %s, Mouse: %s, Boar: %s, Plant: %s",
                bearCount, wolfCount, eagleCount, horseCount, mouseCount, boarCount, plantCount);
        //   System.out.println("Bear: " + bearCount);
    }


    public void populateAnimals() {
        AnimalGeneratorService[] serviceArray = {new BearGenerator(), new BoarGenerator(), new BoaGenerator(),
                new CaterpillarGenerator(), new BuffaloGenerator(), new DeerGenerator(), new DuckGenerator(),
                new EagleGenerator(), new FoxGenerator(), new GoatGenerator(), new SheepGenerator(), new WolfGenerator(),
                new HorseGenerator(), new MouseGenerator(), new PlantGenerator(), new RabbitGenerator()};

        for (var service : serviceArray
        ) {
            entityList.addAll(service.generateEntity());
        }
    }

    public void removeDiedEntities() {
        diedAnimals = (int) entityList.stream().filter(x -> !x.isAlive() && !(x instanceof Plant)).count();
        entityList.removeIf(entity -> !entity.isAlive());
    }

    public void moveAnimals(int day) {
        int maxX = IslandModel.locations.length - 1;
        int maxY = IslandModel.locations[0].length - 1;
        for (var animal : entityList) {
            if (animal instanceof Movable) {
                if (animal instanceof Caterpillar) break;
                if (animal.getSteps() == day) break;
                int[] settings = ((Movable) animal).move();
                int direction = settings[0];
                int range = settings[1];
                if (range != 0) {
                    int xEnd = 0;
                    int yEnd = 0;
                    switch (direction) {
                        case 0 -> xEnd = Math.min((positionX + range), maxX);
                        case 1 -> xEnd = Math.max(positionY - range, 0);
                        case 2 -> yEnd = Math.min((positionY + range), maxY);
                        case 3 -> yEnd = Math.max(positionY - range, 0);
                    }
                    Location dest = IslandModel.locations[xEnd][yEnd];
                    if ((xEnd != positionX || yEnd != positionY) &&
                            dest.entityCounting(animal) < animal.getMaxCountInTheLocation()) {
                        dest.getEntityList().add(animal);
                        entityList.remove(animal);
                    }
                    animal.setSteps(day);
                }
            }
        }
    }

    public int entityCounting(BaseEntity entity) {
        return (int) entityList.stream().filter(x -> x.getClass().equals(entity.getClass())).count();
    }


    public void reproduceAnimals() {
        for (var entity : entityList) {
            int count = entityCounting(entity);
            if (count < entity.getMaxCountInTheLocation()) {
                entityList.addAll(entity.reproduction(entityList));
            }
        }
    }

    public void feedAnimals() {
        List<BaseEntity> predatorsFood = entityList.stream()
                .filter(x -> x instanceof Herbivorous || x instanceof Omnivorous).toList();
        List<BaseEntity> herbFood = entityList.stream().
                filter(x -> x instanceof Plant).toList();
        List<BaseEntity> omniFood = new ArrayList<>(herbFood);
        omniFood.addAll(predatorsFood);
        for (var entity : entityList
        ) {
            if (entity.isAlive()) {
                if (entity instanceof Predator) {
                    ((Predator) entity).eat(predatorsFood);
                } else if (entity instanceof Herbivorous) {
                    ((Herbivorous) entity).eat(herbFood);
                } else if (entity instanceof Omnivorous) {
                    ((Omnivorous) entity).eat(omniFood);
                }
            }
        }
    }
}






