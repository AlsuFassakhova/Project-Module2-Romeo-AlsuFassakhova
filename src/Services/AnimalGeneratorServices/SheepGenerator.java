package Services.AnimalGeneratorServices;

import Model.Entities.BaseEntity.Animal.Herbivorous.Sheep;
import Model.Entities.BaseEntity.BaseEntity;
import Services.FileReadService;
import Services.RandomService;

import java.util.ArrayList;
import java.util.List;

public class SheepGenerator implements AnimalGeneratorService {
    Sheep sheep = new Sheep();

    @Override
    public List<BaseEntity> generateEntity() {
        List<BaseEntity> list = new ArrayList<>();
        FileReadService fileReadService = new FileReadService();
        String name = fileReadService.readName(sheep);
        int count = fileReadService.readMaxCount(sheep);
        for (int i = 0; i < RandomService.getNumber(0, count + 1); i++) {
            list.add(new Sheep(name));
        }
        return list;
    }
}
