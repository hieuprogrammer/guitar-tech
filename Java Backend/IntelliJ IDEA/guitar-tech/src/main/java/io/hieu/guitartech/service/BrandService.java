package io.hieu.guitartech.service;

import io.hieu.guitartech.domain.Brand;
import io.hieu.guitartech.dto.model.BrandDto;

import java.util.List;

public interface BrandService {
    BrandDto save(BrandDto brandDto);

    List<BrandDto> findAll();

    BrandDto findById(Long id);

    BrandDto update(BrandDto brandDto, Long id);

    void delete(Brand brand);

    void deleteById(Long id);
}