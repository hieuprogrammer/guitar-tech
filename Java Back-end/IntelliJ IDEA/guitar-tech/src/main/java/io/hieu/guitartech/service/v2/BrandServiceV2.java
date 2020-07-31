package io.hieu.guitartech.service.v2;

import io.hieu.guitartech.domain.Brand;
import io.hieu.guitartech.dto.model.BrandDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public interface BrandServiceV2 {
    BrandDto save(BrandDto brandDto);

    List<BrandDto> findAll();

    Optional<BrandDto> findById(Long brandId);

    BrandDto update(Long brandId, BrandDto brandDto);

    void delete(Brand brand);

    void deleteById(Long brandId);

    List<BrandDto> search(String keyword);

//    Iterable<BrandDto> findAll(Sort sort);

//    Page<BrandDto> findAll(Pageable pageable);
}