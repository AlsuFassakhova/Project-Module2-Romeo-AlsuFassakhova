package Services.AnimalGeneratorServices;

import Model.Entities.BaseEntity.Animal.Omnivorous.Mouse;
import Model.Entities.BaseEntity.BaseEntity;
import Services.FileReadService;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class MouseGenerator implements AnimalGeneratorService {
    Mouse mouse = new Mouse();
    public int getRandom(int origin, int bound) {
        return ThreadLocalRandom.current().nextInt(origin, bound);
    }

    @Override
    public List<BaseEntity> generateEntity() {
        List<BaseEntity> list = new ArrayList<>();
        FileReadService fileReadService = new FileReadService();
        String name = fileReadService.readName(mouse);
        int count = fileReadService.readMaxCount(mouse);
        for (int i = 0; i < getRandom(0, count + 1); i++) {
            list.add(new Mouse(name));
        }
        return list;
    }
}
