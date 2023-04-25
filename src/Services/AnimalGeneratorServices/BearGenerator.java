package Services.AnimalGeneratorServices;


import Model.Entities.BaseEntity.Animal.Predators.Bear;
import Model.Entities.BaseEntity.BaseEntity;
import Services.FileReadService;
import Services.RandomService;

import java.util.ArrayList;
import java.util.List;

public class BearGenerator implements AnimalGeneratorService {

    Bear bear = new Bear();

    @Override
    public List<BaseEntity> generateEntity() {
        List<BaseEntity> list = new ArrayList<>();
        FileReadService fileReadService = new FileReadService();
        String name = fileReadService.readName(bear);
        int count = fileReadService.readMaxCount(bear);
        for (int i = 0; i < RandomService.getNumber(0, count + 1); i++) {
            list.add(new Bear(name));
        }
        return list;
    }
}
