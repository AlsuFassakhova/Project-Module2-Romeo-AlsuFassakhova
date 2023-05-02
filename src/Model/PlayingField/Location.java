package Model.PlayingField;

import Interfaces.Movable;
import Model.Entities.BaseEntity.Animal.Animal;
import Model.Entities.BaseEntity.Animal.Herbivorous.*;
import Model.Entities.BaseEntity.Animal.Omnivorous.Mouse;
import Model.Entities.BaseEntity.Animal.Omnivorous.Omnivorous;
import Model.Entities.BaseEntity.Animal.Predators.*;
import Model.Entities.BaseEntity.BaseEntity;
import Model.Entities.BaseEntity.Plant;
import Services.AnimalGeneratorServices.*;
import Services.FileReadService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Location {

    private int positionX;
    private int positionY;
    private List<BaseEntity> entityList;
    private int diedAnimals = 0;
    private int newBornAnimals = 0;

    public Location(int positionX, int positionY, List<BaseEntity> entityList) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.entityList = entityList;
    }

    public void populateAnimals() throws CloneNotSupportedException {
        entityList.addAll(EntitiesGeneratorService.generateEntitiesList());
    }

    public void removeDiedEntities() {
        diedAnimals = (int) entityList.stream().filter(x -> !x.isAlive() && !(x instanceof Plant)).count();
        entityList.removeIf(entity -> !entity.isAlive());
    }

    public void moveAnimals(int day) {
        List<Movable> movableList = entityList.stream()
                .filter(x -> !(x instanceof Plant) && !(x instanceof Caterpillar) && !(x.getSteps() == day))
                .map(x -> (Movable) x).toList();
        for (var animal : movableList) {
            int[] coordinates = getMoveCoordinates(animal.move());
            if (coordinates != null) {
                int xEnd = coordinates[0];
                int yEnd = coordinates[1];
                Location dest = IslandModel.locations[xEnd][yEnd];
                BaseEntity entity = (BaseEntity) animal;
                if ((xEnd != positionX || yEnd != positionY) &&
                        dest.entityCounting(entity) < FileReadService.readMaxCount(entity)) {
                    dest.getEntityList().add(entity);
                    entityList.remove(animal);
                }
                entity.setSteps(day);
            }
        }
    }

    public int[] getMoveCoordinates(int[] settings) {
        int maxX = IslandModel.locations.length - 1;
        int maxY = IslandModel.locations[0].length - 1;
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
            return new int[]{xEnd, yEnd};
        } else return null;
    }

    public int entityCounting(BaseEntity entity) {
        return (int) entityList.stream().filter(x -> x.getClass().equals(entity.getClass())).count();
    }

    public void reproduceAnimals() {
        newBornAnimals = 0;
        List<Animal> newAnimalList = entityList.stream()
                .filter(x -> entityCounting(x) < FileReadService.readMaxCount(x)&&!(x instanceof Plant))
                .map(x -> (Animal) x).toList();
        for (Animal animal : newAnimalList) {
            Animal newBorn = animal.reproduction(entityList);
            if (newBorn != null) {
                entityList.add(newBorn);
                newBornAnimals++;
            }
        }
    }

    public void reproducePlant() {
        Plant plant = new Plant();
        entityList.addAll(plant.reproduction());

    }

    public void reproduceEntities() {
        reproduceAnimals();
        reproducePlant();
    }

    public void feedAnimals() {
        List<BaseEntity> predatorsFood = entityList.stream()
                .filter(x -> x instanceof Herbivorous || x instanceof Omnivorous).toList();
        List<BaseEntity> herbFood = entityList.stream().
                filter(x -> x instanceof Plant).toList();
        List<BaseEntity> omniFood = entityList.stream()
                .filter(x -> x instanceof Plant || x instanceof Caterpillar || x instanceof Mouse).toList();
        entityList.stream().filter(x -> x.isAlive() && x instanceof Predator)
                .forEach(x -> ((Predator) x).eat(predatorsFood));
        entityList.stream().filter(x -> x.isAlive() && x instanceof Herbivorous)
                .forEach(x -> ((Herbivorous) x).eat(herbFood));
        entityList.stream().filter(x -> x.isAlive() && x instanceof Omnivorous)
                .forEach(x -> ((Omnivorous) x).eat(omniFood));
    }


}







