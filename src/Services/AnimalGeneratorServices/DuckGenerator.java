package Services.AnimalGeneratorServices;

import Model.Entities.BaseEntity.Animal.Omnivorous.Duck;
import Model.Entities.BaseEntity.BaseEntity;
import Services.FileReadService;
import Services.RandomService;

import java.util.ArrayList;
import java.util.List;

public class DuckGenerator implements AnimalGeneratorService {
    Duck duck = new Duck();

    @Override
    public List<BaseEntity> generateEntity() {
        List<BaseEntity> list = new ArrayList<>();
        FileReadService fileReadService = new FileReadService();
        String name = fileReadService.readName(duck);
        int count = fileReadService.readMaxCount(duck);
        for (int i = 0; i < RandomService.getNumber(0, count + 1); i++) {
            list.add(new Duck(name));
        }
        return list;
    }
}
