package Model.Entities.BaseEntity;

import Services.AnimalGeneratorServices.AnimalGeneratorService;
import Services.AnimalGeneratorServices.PlantGenerator;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
public class Plant extends BaseEntity {
    private double maxWeight = 1;
    private int maxCountInTheLocation = 500;
    private String pathToJsonFile = "src/Resources/PlantSettings.json";

    public Plant(String name) {
        this.setName(name);
    }

    @Override
    public List<BaseEntity> reproduction(List<BaseEntity> entityList) {
        AnimalGeneratorService animalGeneratorService = new PlantGenerator();
        return animalGeneratorService.generateEntity();

    }

    @Override
    public BaseEntity createEntity() {
        return null;
    }
}
