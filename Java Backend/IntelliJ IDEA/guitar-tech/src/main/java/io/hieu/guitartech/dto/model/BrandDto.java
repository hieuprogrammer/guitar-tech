package io.hieu.guitartech.dto.model;

import io.hieu.guitartech.domain.BaseEntity;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BrandDto extends BaseEntity {
    private String name;

    private String logoUrl;

    public BrandDto(Long id, String name, String logoUrl) {
        super(id);
        this.name = name;
        this.logoUrl = logoUrl;
    }
}