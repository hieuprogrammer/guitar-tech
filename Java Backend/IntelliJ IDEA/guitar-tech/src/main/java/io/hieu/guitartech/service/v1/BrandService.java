package io.hieu.guitartech.service.v1;

import io.hieu.guitartech.domain.Brand;
import io.hieu.guitartech.dto.model.BrandDto;

import java.util.List;

@Deprecated
public interface BrandService {
    BrandDto save(BrandDto brandDto);

    List<BrandDto> findAll();

    BrandDto findById(Long brandId);

    BrandDto update(Long brandId, BrandDto brandDto);

    void delete(Brand brand);

    void deleteById(Long brandId);
}