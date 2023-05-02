package Services.AnimalGeneratorServices;

import Model.Entities.BaseEntity.BaseEntity;
import Model.Entities.BaseEntity.Plant;
import Services.FileReadService;
import Services.RandomService;

import java.util.ArrayList;
import java.util.List;

public class PlantGeneratorService {
    Plant plant = new Plant();


    public List<BaseEntity> generate() {
        List<BaseEntity> list = new ArrayList<>();
        int count = FileReadService.readMaxCount(plant);
        for (int i = 0; i < RandomService.getNumber(0, count + 1); i++) {
            try {
                list.add((BaseEntity) plant.clone());
            } catch (CloneNotSupportedException e) {
                throw new RuntimeException(e);
            }
        }
        return list;
    }
}
