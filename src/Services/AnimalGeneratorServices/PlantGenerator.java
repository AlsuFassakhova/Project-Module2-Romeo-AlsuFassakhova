package Services.AnimalGeneratorServices;

import Model.Entities.BaseEntity.BaseEntity;
import Model.Entities.BaseEntity.Plant;
import Services.FileReadService;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class PlantGenerator implements AnimalGeneratorService {
    Plant plant = new Plant();
    public int getRandom(int origin, int bound) {
        return ThreadLocalRandom.current().nextInt(origin, bound);
    }

    @Override
    public List<BaseEntity> generateEntity() {
        List<BaseEntity> list = new ArrayList<>();
        FileReadService fileReadService = new FileReadService();
        String name = fileReadService.readName(plant);
        int count = fileReadService.readMaxCount(plant);
        for (int i = 0; i < getRandom(0, count + 1); i++) {
            list.add(new Plant(name));
        }
        return list;
    }
}
