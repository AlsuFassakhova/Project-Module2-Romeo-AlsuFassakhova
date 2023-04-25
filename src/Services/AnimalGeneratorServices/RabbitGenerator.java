package Services.AnimalGeneratorServices;

import Model.Entities.BaseEntity.Animal.Herbivorous.Rabbit;
import Model.Entities.BaseEntity.BaseEntity;
import Services.FileReadService;
import Services.RandomService;

import java.util.ArrayList;
import java.util.List;

public class RabbitGenerator implements AnimalGeneratorService {
    Rabbit rabbit = new Rabbit();

    @Override
    public List<BaseEntity> generateEntity() {
        List<BaseEntity> list = new ArrayList<>();
        FileReadService fileReadService = new FileReadService();
        String name = fileReadService.readName(rabbit);
        int count = fileReadService.readMaxCount(rabbit);
        for (int i = 0; i < RandomService.getNumber(0, count + 1); i++) {
            list.add(new Rabbit(name));
        }
        return list;
    }
}
