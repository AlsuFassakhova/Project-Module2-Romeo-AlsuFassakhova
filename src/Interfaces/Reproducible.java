package Interfaces;

import Model.Entities.BaseEntity.BaseEntity;

import java.util.List;

public interface Reproducible {
    List<BaseEntity> reproduction(List<BaseEntity> entityList);
}
