package Services.AnimalGeneratorServices;

import Model.Entities.BaseEntity.Animal.Predators.Wolf;
import Model.Entities.BaseEntity.BaseEntity;
import Services.FileReadService;
import Services.RandomService;

import java.util.ArrayList;
import java.util.List;

public class WolfGenerator implements AnimalGeneratorService {
    Wolf wolf = new Wolf();

    @Override
    public List<BaseEntity> generateEntity() {
        List<BaseEntity> list = new ArrayList<>();
        FileReadService fileReadService = new FileReadService();
        String name = fileReadService.readName(wolf);
        int count = fileReadService.readMaxCount(wolf);
        for (int i = 0; i < RandomService.getNumber(0, count + 1); i++) {
            list.add(new Wolf(name));
        }
        return list;
    }
}
