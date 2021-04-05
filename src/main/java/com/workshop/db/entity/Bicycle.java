package com.workshop.db.entity;
import com.workshop.config.security.entity.ServiceUser;
import com.workshop.enums.BicycleType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Data
public class Bicycle {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @NotBlank
    private String name;

    private String brand;
    private String model;

    private BicycleType type;

    private Double predefinedWeight;
    private Double countedWeight;

    private Long year;

    private Long imageId;

    private Boolean isOfficial;

    @OneToOne
    @JoinColumn(name = "frame_id")
    private Frame frame;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private ServiceUser serviceUser;
}
