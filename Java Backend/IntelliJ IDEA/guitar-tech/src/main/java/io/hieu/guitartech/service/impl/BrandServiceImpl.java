package io.hieu.guitartech.service.impl;

import io.hieu.guitartech.domain.Brand;
import io.hieu.guitartech.dto.mapper.BrandMapper;
import io.hieu.guitartech.dto.model.BrandDto;
import io.hieu.guitartech.repository.BrandRepository;
import io.hieu.guitartech.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class BrandServiceImpl implements BrandService {
    private final BrandRepository brandRepository;

    @Autowired
    public BrandServiceImpl(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public BrandDto save(BrandDto brandDto) {
        Brand brand = BrandMapper.toBrand(brandDto);
        brand = brandRepository.save(brand);
        return BrandMapper.toBrandDto(brand);
    }

    @Override
    public List<BrandDto> findAll() {
        List<Brand> brands = brandRepository.findAll();
        List<BrandDto> brandDtos = new ArrayList<BrandDto>();
        for (Brand brand : brands) {
            brandDtos.add(BrandMapper.toBrandDto(brand));
        }
        return brandDtos;
    }

    @Override
    public BrandDto findById(Long id) {
        Brand brand = brandRepository.findById(id).get(); // If a value is present, returns the value, otherwise throws java.util.NoSuchElementException: No value present. -> This is why using Optional is better.
        return BrandMapper.toBrandDto(brand);
    }

    @Override
    public BrandDto update(Long id, BrandDto brandDto) {
        Brand brand = brandRepository.findById(id).get();
        brand.setName(brandDto.getName());
        brand.setLogoUrl(brandDto.getLogoUrl());
        return BrandMapper.toBrandDto(brand);
    }

    @Override
    public void delete(Brand brand) {
        brandRepository.delete(brand);
    }

    @Override
    public void deleteById(Long id) {
        brandRepository.deleteById(id);
    }
}