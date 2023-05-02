package Services.AnimalGeneratorServices;

import Model.Entities.BaseEntity.Animal.Herbivorous.*;
import Model.Entities.BaseEntity.Animal.Omnivorous.Boar;
import Model.Entities.BaseEntity.Animal.Omnivorous.Duck;
import Model.Entities.BaseEntity.Animal.Omnivorous.Mouse;
import Model.Entities.BaseEntity.Animal.Predators.*;
import Model.Entities.BaseEntity.BaseEntity;
import Model.Entities.BaseEntity.Plant;
import Services.FileReadService;
import Services.RandomService;
import lombok.Getter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
@Getter
public class EntitiesGeneratorService {
public static final Set<BaseEntity> entitySet = new HashSet<>();
    private static Set<BaseEntity> generateSet() {
        entitySet.add(new Bear());
        entitySet.add(new Boa());
        entitySet.add(new Boar());
        entitySet.add(new Eagle());
        entitySet.add(new Buffalo());
        entitySet.add(new Caterpillar());
        entitySet.add(new Deer());
        entitySet.add(new Duck());
        entitySet.add(new Fox());
        entitySet.add(new Goat());
        entitySet.add(new Horse());
        entitySet.add(new Mouse());
        entitySet.add(new Plant());
        entitySet.add(new Rabbit());
        entitySet.add(new Sheep());
        entitySet.add(new Wolf());

        return entitySet;
    }
    public static List<BaseEntity> generateEntitiesList() throws CloneNotSupportedException {
        Set<BaseEntity> set = generateSet();
        List<BaseEntity> list = new CopyOnWriteArrayList<>();
        for (var entity : set) {
            int count = RandomService.getNumber(0, FileReadService.readMaxCount(entity));
            for (int i = 0; i < count; i++) {
                list.add((BaseEntity) entity.clone());
            }
        }
        return list;
    }
}
