package io.hieu.guitartech.service.impl.v2;

import io.hieu.guitartech.domain.Brand;
import io.hieu.guitartech.dto.mapper.BrandMapper;
import io.hieu.guitartech.dto.model.BrandDto;
import io.hieu.guitartech.repository.BrandRepository;
import io.hieu.guitartech.service.v2.BrandServiceV2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class BrandServiceImplV2 implements BrandServiceV2 {
    private final BrandRepository brandRepository;

    @Autowired
    public BrandServiceImplV2(BrandRepository brandRepository) {
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
    public Optional<BrandDto> findById(Long brandId) {
//        Brand brand = brandRepository.findById(brandId).get();
//        BrandDto brandDto = BrandMapper.toBrandDto(brand);
//        Optional<BrandDto> brandDtoOptional = Optional.of(brandDto);
//        return brandDtoOptional;

        return brandRepository.findById(brandId).map(brandOptional -> BrandMapper.toBrandDto(brandOptional));
    }

    @Override
    public List<BrandDto> search(String keyword) {
        List<Brand> brands = brandRepository.search(keyword);
        List<BrandDto> brandDtos = new ArrayList<BrandDto>();
        for (Brand brand : brands) {
            brandDtos.add(BrandMapper.toBrandDto(brand));
        }

        return brandDtos;
    }

    @Override
    public BrandDto update(Long brandId, BrandDto brandDto) {
        Brand brand = brandRepository.findById(brandId).get();
        brand.setName(brandDto.getName());
        brand.setLogoUrl(brandDto.getLogoUrl());

        return BrandMapper.toBrandDto(brand);
    }

    @Override
    public void delete(Brand brand) {
        brandRepository.delete(brand);
    }

    @Override
    public void deleteById(Long brandId) {
        brandRepository.deleteById(brandId);
    }
}