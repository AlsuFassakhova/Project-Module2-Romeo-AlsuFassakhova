package Services.AnimalGeneratorServices;

import Model.Entities.BaseEntity.Animal.Predators.Fox;
import Model.Entities.BaseEntity.BaseEntity;
import Services.FileReadService;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class FoxGenerator implements AnimalGeneratorService {
    Fox fox = new Fox();
    public int getRandom(int origin, int bound) {
        return ThreadLocalRandom.current().nextInt(origin, bound);
    }

    @Override
    public List<BaseEntity> generateEntity() {
        List<BaseEntity> list = new ArrayList<>();
        FileReadService fileReadService = new FileReadService();
        String name = fileReadService.readName(fox);
        int count = fileReadService.readMaxCount(fox);
        for (int i = 0; i < getRandom(0, count + 1); i++) {
            list.add(new Fox(name));
        }
        return list;
    }
}
