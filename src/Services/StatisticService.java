package Services;

import Model.Entities.BaseEntity.Animal.Herbivorous.*;
import Model.Entities.BaseEntity.Animal.Omnivorous.Boar;
import Model.Entities.BaseEntity.Animal.Omnivorous.Duck;
import Model.Entities.BaseEntity.Animal.Omnivorous.Mouse;
import Model.Entities.BaseEntity.Animal.Omnivorous.Omnivorous;
import Model.Entities.BaseEntity.Animal.Predators.*;
import Model.Entities.BaseEntity.Plant;
import Model.PlayingField.IslandModel;
import Model.PlayingField.Location;


public class StatisticService {
    FileReadService fileReadService = new FileReadService();

    public void printStatisticsForEachAnimalSpecies() {
        int bearCount = 0;
        int wolfCount = 0;
        int horseCount = 0;
        int mouseCount = 0;
        int boarCount = 0;
        int plantCount = 0;
        int boaCount = 0;
        int eagleCount = 0;
        int duckCount = 0;
        int deerCount = 0;
        int foxCount = 0;
        int sheepCount = 0;
        int rabbitCount = 0;
        int goatCount = 0;
        int buffaloCount = 0;
        int caterpillarCount = 0;

        for (Location[] locations : IslandModel.locations) {
            for (Location location : locations) {

                bearCount += location.getEntityList().stream().filter(x -> x instanceof Bear).count();
                wolfCount += location.getEntityList().stream().filter(x -> x instanceof Wolf).count();
                horseCount += location.getEntityList().stream().filter(x -> x instanceof Horse).count();
                mouseCount += location.getEntityList().stream().filter(x -> x instanceof Mouse).count();
                boarCount += location.getEntityList().stream().filter(x -> x instanceof Boar).count();
                boaCount += location.getEntityList().stream().filter(x -> x instanceof Boa).count();
                buffaloCount += location.getEntityList().stream().filter(x -> x instanceof Buffalo).count();
                goatCount += location.getEntityList().stream().filter(x -> x instanceof Goat).count();
                duckCount += location.getEntityList().stream().filter(x -> x instanceof Duck).count();
                sheepCount += location.getEntityList().stream().filter(x -> x instanceof Sheep).count();
                rabbitCount += location.getEntityList().stream().filter(x -> x instanceof Rabbit).count();
                caterpillarCount += location.getEntityList().stream().filter(x -> x instanceof Caterpillar).count();
                plantCount += location.getEntityList().stream().filter(x -> x instanceof Plant).count();
                deerCount += location.getEntityList().stream().filter(x -> x instanceof Deer).count();
                foxCount += location.getEntityList().stream().filter(x -> x instanceof Fox).count();
                eagleCount += location.getEntityList().stream().filter(x -> x instanceof Eagle).count();

            }
        }
        int sum = bearCount + wolfCount + horseCount + mouseCount + boarCount + plantCount +
                boaCount + foxCount + eagleCount + sheepCount + deerCount + goatCount +
                buffaloCount + rabbitCount + duckCount + caterpillarCount;
        System.out.printf("Bear: %d, Wolf: %d, Horse: %d, Mouse: %d, Boar: %d, Plant: %d " +
                        "Boa: %d, Fox: %d, Eagle: %d, Sheep: %d, Deer: %d, Goat: %d " +
                        "Buffalo: %d, Rabbit: %d, Duck: %d, Caterpillar: %d",
                bearCount, wolfCount, horseCount, mouseCount, boarCount, plantCount,
                boaCount, foxCount, eagleCount, sheepCount, deerCount, goatCount,
                buffaloCount, rabbitCount, duckCount, caterpillarCount);
        System.out.println();
        System.out.println("Sum: "+sum);
        }

    public void printStatisticsForGroupOfAnimals() {
        long predatorCount = 0;
        long omnivorousCount = 0;
        long herbivorousCount = 0;
        long plantCount = 0;
        for (Location[] locations : IslandModel.locations) {
            for (Location location : locations) {
                predatorCount += location.getEntityList().stream().filter(x -> x instanceof Predator).count();
                omnivorousCount += location.getEntityList().stream().filter(x -> x instanceof Omnivorous).count();
                herbivorousCount += location.getEntityList().stream().filter(x -> x instanceof Herbivorous).count();
                plantCount += location.getEntityList().stream().filter(x -> x instanceof Plant).count();
            }
        }
        System.out.printf("Predators: %s, Omnivarouse: %s, herbivarous: %s, Plant: %s",
                predatorCount, omnivorousCount, herbivorousCount, plantCount);
    }

    public void printStatisticsForDiedAnimals() {
        int diedAnimals = 0;
        for (Location[] locations : IslandModel.locations) {
            for (Location location : locations) {
                diedAnimals += location.getDiedAnimals();
            }
        }
        System.out.printf("Died: %d", diedAnimals);
        System.out.println();
    }

    public void printStatisticsForNewBornAnimals() {
        int newAnimals = 0;
    }
}
