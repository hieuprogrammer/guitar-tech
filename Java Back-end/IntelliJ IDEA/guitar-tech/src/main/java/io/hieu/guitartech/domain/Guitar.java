package io.hieu.guitartech.domain;

import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = true, exclude = { "brand", "model", "numberOfFrets", "numberOfStrings", "numberOfPickups", "pickupsType", "price" })
@ToString(exclude = "brand")
@Entity
public class Guitar extends BaseEntity {
    @ManyToOne(
            fetch = FetchType.LAZY,
            cascade = CascadeType.MERGE
    )
    private Brand brand;

    @NotBlank(message = "Guitar model is required!")
    private String model;

    private Integer numberOfFrets;

    private Integer numberOfStrings;

    private Integer numberOfPickups;

    private String pickupsType;

    private String imageUrl;

    private Double price;
}