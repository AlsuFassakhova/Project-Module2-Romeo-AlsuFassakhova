package Services.AnimalGeneratorServices;

import Model.Entities.BaseEntity.Animal.Herbivorous.Horse;
import Model.Entities.BaseEntity.BaseEntity;
import Services.FileReadService;
import Services.RandomService;

import java.util.ArrayList;
import java.util.List;

public class HorseGenerator implements AnimalGeneratorService {
    Horse horse = new Horse();

    @Override
    public List<BaseEntity> generateEntity() {
        List<BaseEntity> list = new ArrayList<>();
        FileReadService fileReadService = new FileReadService();
        String name = fileReadService.readName(horse);
        int count = fileReadService.readMaxCount(horse);
        for (int i = 0; i < RandomService.getNumber(0, count + 1); i++) {
            list.add(new Horse(name));
        }
        return list;
    }
}
