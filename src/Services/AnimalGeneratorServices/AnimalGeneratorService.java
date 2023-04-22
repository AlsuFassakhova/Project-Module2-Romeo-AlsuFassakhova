package Services.AnimalGeneratorServices;

import Model.Entities.BaseEntity.BaseEntity;

import java.util.List;

public interface AnimalGeneratorService {
    List<BaseEntity> generateEntity();
}
