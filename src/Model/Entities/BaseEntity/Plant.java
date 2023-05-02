package Model.Entities.BaseEntity;

import Resources.Constants;
import Services.AnimalGeneratorServices.PlantGeneratorService;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
public class Plant extends BaseEntity {
    private double maxWeight;
    private int maxCountInTheLocation;
    private String pathToJsonFile = Constants.pathToPlantJsonFile;


    public List<BaseEntity> reproduction() {
        PlantGeneratorService plantGenerator = new PlantGeneratorService();
        return plantGenerator.generate();

    }
    @Override
    public BaseEntity createEntity() {
        return null;
    }
}
