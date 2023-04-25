package Services.AnimalGeneratorServices;

import Model.Entities.BaseEntity.Animal.Predators.Fox;
import Model.Entities.BaseEntity.BaseEntity;
import Services.FileReadService;
import Services.RandomService;

import java.util.ArrayList;
import java.util.List;

public class FoxGenerator implements AnimalGeneratorService {
    Fox fox = new Fox();

    @Override
    public List<BaseEntity> generateEntity() {
        List<BaseEntity> list = new ArrayList<>();
        FileReadService fileReadService = new FileReadService();
        String name = fileReadService.readName(fox);
        int count = fileReadService.readMaxCount(fox);
        for (int i = 0; i < RandomService.getNumber(0, count + 1); i++) {
            list.add(new Fox(name));
        }
        return list;
    }
}
