package Services.AnimalGeneratorServices;

import Model.Entities.BaseEntity.BaseEntity;
import Model.Entities.BaseEntity.Plant;
import Services.FileReadService;
import Services.RandomService;

import java.util.ArrayList;
import java.util.List;

public class PlantGenerator implements AnimalGeneratorService {
    Plant plant = new Plant();

    @Override
    public List<BaseEntity> generateEntity() {
        List<BaseEntity> list = new ArrayList<>();
        FileReadService fileReadService = new FileReadService();
        String name = fileReadService.readName(plant);
        int count = fileReadService.readMaxCount(plant);
        for (int i = 0; i < RandomService.getNumber(0, count + 1); i++) {
            list.add(new Plant(name));
        }
        return list;
    }
}
