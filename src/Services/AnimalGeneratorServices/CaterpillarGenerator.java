package Services.AnimalGeneratorServices;

import Model.Entities.BaseEntity.Animal.Herbivorous.Caterpillar;
import Model.Entities.BaseEntity.BaseEntity;
import Services.FileReadService;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class CaterpillarGenerator implements AnimalGeneratorService {
    Caterpillar caterpillar = new Caterpillar();
    public int getRandom(int origin, int bound) {
        return ThreadLocalRandom.current().nextInt(origin, bound);
    }

    @Override
    public List<BaseEntity> generateEntity() {
        List<BaseEntity> list = new ArrayList<>();
        FileReadService fileReadService = new FileReadService();
        String name = fileReadService.readName(caterpillar);
        int count = fileReadService.readMaxCount(caterpillar);
        for (int i = 0; i < getRandom(0, count + 1); i++) {
            list.add(new Caterpillar(name));
        }
        return list;
    }
}
