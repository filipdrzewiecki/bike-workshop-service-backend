package workshop.db.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Frame extends BicyclePart{

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String size;
    private double topHeadSetDiameter;
    private double bottomHeadSetDiameter;
    private String bottomBracketSize;
    private String bottomBracketType;
    private String rearWheelAxleSize;
    private double seatpostSize;
    private double seatpostCaliperDiameter;
    private String discBrakeMount;
    private String brakeType;

    private String headsetType;
    
    private String forkTubeType;

    private String year;

}