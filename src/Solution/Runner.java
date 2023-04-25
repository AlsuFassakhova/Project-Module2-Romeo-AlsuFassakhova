package Solution;

import Model.PlayingField.Simulation;
import Services.StatisticService;


public class Runner {
    public static void main(String[] args) {
        Simulation simulation = new Simulation();
        StatisticService statistic = new StatisticService();
        simulation.createIslandModel(100, 20);
        for (int i = 1; i < 31; i++) {
            System.out.println("Day " + i);
            simulation.startSimulation(i);
            statistic.printStatisticsForEachAnimalSpecies();
            statistic.printStatisticsForGroupOfAnimals();
            statistic.printStatisticsForDiedAnimals();
        }
    }
}
