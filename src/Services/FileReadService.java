package Services;


import Model.Entities.BaseEntity.Animal.Animal;
import Model.Entities.BaseEntity.BaseEntity;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;

import java.io.File;
import java.io.IOException;

import java.util.Map;

public class FileReadService {
    static ObjectMapper objectMapper = new JsonMapper();

    public String readName(BaseEntity entity) {
        String name;
        try {
            BaseEntity entity1 = objectMapper.readValue(new File(entity.getPathToJsonFile()), entity.getClass());
            name = entity1.getName();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return name;
    }

    public int readMaxCount(BaseEntity entity) {
        int maxCount;
        try {
            BaseEntity entity1 = objectMapper.readValue(new File(entity.getPathToJsonFile()), entity.getClass());
            maxCount = entity1.getMaxCountInTheLocation();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return maxCount;
    }

    public static int chanceToEat(BaseEntity animal, BaseEntity food) {
        int chance = 0;
        try {
            Animal animal1 = (Animal) objectMapper.readValue(new File(animal.getPathToJsonFile()), animal.getClass());
            Map<String, Integer> eatingMap = animal1.getEatingMap();
            for (var entity : eatingMap.keySet()) {
                if (entity.equalsIgnoreCase(food.getName())) {
                    chance = eatingMap.get(entity);
                    break;
                }
            }
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return chance;
    }

}
