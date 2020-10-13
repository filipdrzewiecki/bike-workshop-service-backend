package workshop.db.entity.seatpost;

import lombok.Data;
import lombok.NoArgsConstructor;
import workshop.db.entity.BicyclePart;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class SeatpostClamp extends BicyclePart {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private double setapostDiameter;
    private double frameDiameter;

}