package io.hieu.guitartech.dto.model;

import io.hieu.guitartech.domain.BaseEntity;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class GuitarDto extends BaseEntity {
    private Long brandId;

    private String brandName;

    private String model;

    private Integer numberOfFrets;

    private Integer numberOfStrings;

    private Integer numberOfPickups;

    private String pickupsType;

    private String imageUrl;

    private Double price;

    public GuitarDto(Long id, Long brandId, String brandName, String model, Integer numberOfFrets, Integer numberOfStrings, Integer numberOfPickups, String pickupsType, String imageUrl, Double price) {
        super(id);
        this.brandId = brandId;
        this.brandName = brandName;
        this.model = model;
        this.numberOfFrets = numberOfFrets;
        this.numberOfStrings = numberOfStrings;
        this.numberOfPickups = numberOfPickups;
        this.pickupsType = pickupsType;
        this.imageUrl = imageUrl;
        this.price = price;
    }
}