package Services.AnimalGeneratorServices;

import Model.Entities.BaseEntity.Animal.Omnivorous.Mouse;
import Model.Entities.BaseEntity.BaseEntity;
import Services.FileReadService;
import Services.RandomService;

import java.util.ArrayList;
import java.util.List;

public class MouseGenerator implements AnimalGeneratorService {
    Mouse mouse = new Mouse();

    @Override
    public List<BaseEntity> generateEntity() {
        List<BaseEntity> list = new ArrayList<>();
        FileReadService fileReadService = new FileReadService();
        String name = fileReadService.readName(mouse);
        int count = fileReadService.readMaxCount(mouse);
        for (int i = 0; i < RandomService.getNumber(0, count + 1); i++) {
            list.add(new Mouse(name));
        }
        return list;
    }
}
