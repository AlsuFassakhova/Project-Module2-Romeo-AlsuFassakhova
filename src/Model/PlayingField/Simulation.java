package Model.PlayingField;


import Services.StatisticService;

public class Simulation {
    StatisticService statisticService = new StatisticService();

    public void createIslandModel(int x, int y) {
        IslandModel.getInstance();
        IslandModel.islandModel.setIslandSize(x, y);
        System.out.println("Локация после заселения:");
        for (Location[] locations : IslandModel.locations) {
            for (Location location : locations) {
                location.populateAnimals();
                location.printEntitiesList();
                System.out.println();
            }
        }
    }

    public void startSimulation(int day) {
        System.out.println("Локация после размножения:");
        for (Location[] locations : IslandModel.locations) {
            for (Location location : locations) {
                location.reproduceAnimals();
                location.printEntitiesList();
                System.out.println();

            }
        }
        System.out.println("Локация после еды:");
        for (Location[] locations : IslandModel.locations) {
            for (Location location : locations) {
                location.feedAnimals();
                location.removeDiedEntities();
                location.printEntitiesList();
                System.out.println();

            }
        }
        statisticService.printStatisticsForDiedAnimals();
        for (Location[] locations : IslandModel.locations) {
            for (Location location : locations) {
                location.moveAnimals(day);
                location.removeDiedEntities();
            }
        }
        System.out.println("Локация после движения:");
        for (Location[] locations : IslandModel.locations) {
            for (Location location : locations) {
                location.printEntitiesList();
                System.out.println();
            }
        }
        statisticService.printStatisticsForDiedAnimals();
    }
}


