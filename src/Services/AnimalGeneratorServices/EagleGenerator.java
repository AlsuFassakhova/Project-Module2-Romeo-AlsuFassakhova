package Services.AnimalGeneratorServices;

import Model.Entities.BaseEntity.Animal.Predators.Eagle;
import Model.Entities.BaseEntity.BaseEntity;
import Services.FileReadService;
import Services.RandomService;

import java.util.ArrayList;
import java.util.List;

public class EagleGenerator implements AnimalGeneratorService {
    Eagle eagle = new Eagle();

    @Override
    public List<BaseEntity> generateEntity() {
        List<BaseEntity> list = new ArrayList<>();
        FileReadService fileReadService = new FileReadService();
        String name = fileReadService.readName(eagle);
        int count = fileReadService.readMaxCount(eagle);
        for (int i = 0; i < RandomService.getNumber(0, count + 1); i++) {
            list.add(new Eagle(name));
        }
        return list;
    }
}
