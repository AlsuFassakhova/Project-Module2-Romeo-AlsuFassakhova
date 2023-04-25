package Services.AnimalGeneratorServices;


import Model.Entities.BaseEntity.Animal.Predators.Boa;
import Model.Entities.BaseEntity.BaseEntity;
import Services.FileReadService;
import Services.RandomService;

import java.util.ArrayList;
import java.util.List;
public class BoaGenerator implements AnimalGeneratorService {
    Boa boa = new Boa();

    @Override
    public List<BaseEntity> generateEntity() {
        List<BaseEntity> list = new ArrayList<>();
        FileReadService fileReadService = new FileReadService();
        String name = fileReadService.readName(boa);
        int count = fileReadService.readMaxCount(boa);
        for (int i = 0; i < RandomService.getNumber(0, count + 1); i++) {
            list.add(new Boa(name));
        }
        return list;
    }
}
