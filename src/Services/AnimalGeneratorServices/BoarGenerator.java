package Services.AnimalGeneratorServices;

import Model.Entities.BaseEntity.Animal.Omnivorous.Boar;
import Model.Entities.BaseEntity.BaseEntity;
import Services.FileReadService;
import Services.RandomService;

import java.util.ArrayList;
import java.util.List;

public class BoarGenerator implements AnimalGeneratorService {
    Boar boar = new Boar();

    @Override
    public List<BaseEntity> generateEntity() {
        List<BaseEntity> list = new ArrayList<>();
        FileReadService fileReadService = new FileReadService();
        String name = fileReadService.readName(boar);
        int count = fileReadService.readMaxCount(boar);
        for (int i = 0; i < RandomService.getNumber(0, count + 1); i++) {
            list.add(new Boar(name));
        }
        return list;
    }
}
