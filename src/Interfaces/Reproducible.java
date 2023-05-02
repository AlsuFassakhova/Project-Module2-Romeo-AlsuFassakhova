package Interfaces;

import Model.Entities.BaseEntity.Animal.Animal;
import Model.Entities.BaseEntity.BaseEntity;

import java.util.List;

public interface Reproducible {
    Animal reproduction(List<BaseEntity> entityList);
}

