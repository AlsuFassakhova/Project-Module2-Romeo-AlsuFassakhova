package Services.AnimalGeneratorServices;

import Model.Entities.BaseEntity.Animal.Herbivorous.Goat;
import Model.Entities.BaseEntity.BaseEntity;
import Services.FileReadService;
import Services.RandomService;

import java.util.ArrayList;
import java.util.List;

public class GoatGenerator implements AnimalGeneratorService {
    Goat goat = new Goat();

    @Override
    public List<BaseEntity> generateEntity() {
        List<BaseEntity> list = new ArrayList<>();
        FileReadService fileReadService = new FileReadService();
        String name = fileReadService.readName(goat);
        int count = fileReadService.readMaxCount(goat);
        for (int i = 0; i < RandomService.getNumber(0, count + 1); i++) {
            list.add(new Goat(name));
        }
        return list;
    }
}
