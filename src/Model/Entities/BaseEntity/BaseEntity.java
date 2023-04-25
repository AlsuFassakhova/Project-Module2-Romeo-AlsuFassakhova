package Model.Entities.BaseEntity;

import Interfaces.Reproducible;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public abstract class BaseEntity implements Reproducible {
    private String name;
    private String icon;
    private double maxWeight;
    private int maxCountInTheLocation;
    private int maxRangeToMove;
    @JsonIgnore
    private int steps;
    @JsonIgnore
    private boolean isReproducible = true;
    @JsonIgnore
    private boolean isAlive = true;
    @JsonIgnore
    private String pathToJsonFile;

    public abstract BaseEntity createEntity();}
