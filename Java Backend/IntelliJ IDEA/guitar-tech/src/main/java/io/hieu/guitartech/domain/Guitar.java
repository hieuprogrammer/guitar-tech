package io.hieu.guitartech.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

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

    private String model;

    private Integer numberOfFrets;

    private Integer numberOfStrings;

    private Integer numberOfPickups;

    private String pickupsType;

    private Double price;
}