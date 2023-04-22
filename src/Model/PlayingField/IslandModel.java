package Model.PlayingField;

import java.util.concurrent.CopyOnWriteArrayList;

public class IslandModel {
    public static IslandModel islandModel;
    public static Location[][] locations;

    public static synchronized void getInstance() {
        if (islandModel == null) {
            islandModel = new IslandModel();
        }
    }

    public void setIslandSize(int x, int y) {
        locations = new Location[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                locations[i][j] = new Location(i, j, new CopyOnWriteArrayList<>());
            }
        }
    }
}

