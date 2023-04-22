package Services.AnimalGeneratorServices;

import Model.Entities.BaseEntity.Animal.Predators.Eagle;
import Model.Entities.BaseEntity.BaseEntity;
import Services.FileReadService;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class EagleGenerator implements AnimalGeneratorService {
    Eagle eagle = new Eagle();
    public int getRandom(int origin, int bound) {
        return ThreadLocalRandom.current().nextInt(origin, bound);
    }

    @Override
    public List<BaseEntity> generateEntity() {
        List<BaseEntity> list = new ArrayList<>();
        FileReadService fileReadService = new FileReadService();
        String name = fileReadService.readName(eagle);
        int count = fileReadService.readMaxCount(eagle);
        for (int i = 0; i < getRandom(0, count + 1); i++) {
            list.add(new Eagle(name));
        }
        return list;
    }
}
