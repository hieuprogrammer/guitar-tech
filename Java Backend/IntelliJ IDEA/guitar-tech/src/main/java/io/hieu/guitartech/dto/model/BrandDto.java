package io.hieu.guitartech.dto.model;

import io.hieu.guitartech.domain.BaseEntity;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BrandDto extends BaseEntity {
    private String name;

    public BrandDto(Long id, String name) {
        super(id);
        this.name = name;
    }
}