package workshop.db.entity.wheels;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class Rim {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String productId;
    private String product;
    private String brand;
    private String name;
    private String series;
    private String purpose;
    private double weight;
    private String comment;

    private double height;
    private double innerWidth;
    private double outerWidth;
    private int holes;
    private String brakeType;
    private boolean tubeless;
    private int diameter;
    private int erd;
    private String material;

}