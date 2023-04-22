package Services.AnimalGeneratorServices;

import Model.Entities.BaseEntity.Animal.Omnivorous.Duck;
import Model.Entities.BaseEntity.BaseEntity;
import Services.FileReadService;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class DuckGenerator implements AnimalGeneratorService {
    Duck duck = new Duck();
    public int getRandom(int origin, int bound) {
        return ThreadLocalRandom.current().nextInt(origin, bound);
    }

    @Override
    public List<BaseEntity> generateEntity() {
        List<BaseEntity> list = new ArrayList<>();
        FileReadService fileReadService = new FileReadService();
        String name = fileReadService.readName(duck);
        int count = fileReadService.readMaxCount(duck);
        for (int i = 0; i < getRandom(0, count + 1); i++) {
            list.add(new Duck(name));
        }
        return list;
    }
}
