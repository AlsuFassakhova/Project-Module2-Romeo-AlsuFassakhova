package Services.AnimalGeneratorServices;

import Model.Entities.BaseEntity.Animal.Herbivorous.Buffalo;
import Model.Entities.BaseEntity.BaseEntity;
import Services.FileReadService;
import Services.RandomService;

import java.util.ArrayList;
import java.util.List;

public class BuffaloGenerator implements AnimalGeneratorService {
    Buffalo buffalo = new Buffalo();

    @Override
    public List<BaseEntity> generateEntity() {
        List<BaseEntity> list = new ArrayList<>();
        FileReadService fileReadService = new FileReadService();
        String name = fileReadService.readName(buffalo);
        int count = fileReadService.readMaxCount(buffalo);
        for (int i = 0; i < RandomService.getNumber(0, count + 1); i++) {
            list.add(new Buffalo(name));
        }
        return list;
    }
}
