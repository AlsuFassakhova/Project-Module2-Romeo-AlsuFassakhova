package Model.PlayingField;



public class Simulation {

    public void createIslandModel(int x, int y) {
        IslandModel.getInstance();
        IslandModel.islandModel.setIslandSize(x, y);
        for (Location[] locations : IslandModel.locations) {
            for (Location location : locations) {
                location.populateAnimals();
            }
        }
    }

    public void startSimulation(int day) {
        for (Location[] locations : IslandModel.locations) {
            for (Location location : locations) {
                location.reproduceAnimals();
            }
        }
        for (Location[] locations : IslandModel.locations) {
            for (Location location : locations) {
                location.feedAnimals();
                location.removeDiedEntities();
            }
        }
        for (Location[] locations : IslandModel.locations) {
            for (Location location : locations) {
                location.moveAnimals(day);
                location.removeDiedEntities();
            }
        }

    }
}


