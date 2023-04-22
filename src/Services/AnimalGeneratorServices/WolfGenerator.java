package Services.AnimalGeneratorServices;

import Model.Entities.BaseEntity.Animal.Predators.Wolf;
import Model.Entities.BaseEntity.BaseEntity;
import Services.FileReadService;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class WolfGenerator implements AnimalGeneratorService {
    Wolf wolf = new Wolf();
    public int getRandom(int origin, int bound) {
        return ThreadLocalRandom.current().nextInt(origin, bound);
    }

    @Override
    public List<BaseEntity> generateEntity() {
        List<BaseEntity> list = new ArrayList<>();
        FileReadService fileReadService = new FileReadService();
        String name = fileReadService.readName(wolf);
        int count = fileReadService.readMaxCount(wolf);
        for (int i = 0; i < getRandom(0, count + 1); i++) {
            list.add(new Wolf(name));
        }
        return list;
    }
}
