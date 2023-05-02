package Model.Entities.BaseEntity;

import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public abstract class BaseEntity implements Cloneable {
    private String pathToJsonFile;
    private String name;
    private String icon;
    private double maxWeight;
    private int maxCountInTheLocation;
    private int maxRangeToMove;
    private double foodInKgToFull;
    private int steps;
    private boolean isReproducible = true;
    private boolean isAlive = true;

    public abstract BaseEntity createEntity();

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
