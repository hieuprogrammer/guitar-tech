package io.hieu.guitartech.controller;

import io.hieu.guitartech.dto.model.BrandDto;
import io.hieu.guitartech.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = { "http://127.0.0.1:4200" })
@RequestMapping(path = { "/api/v1/brands", "/api/v1/brands.html" })
@RestController
public class BrandController {
    private final BrandService brandService;

    @Autowired
    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping(path = { "", "/" })
    public List<BrandDto> getBrands() {
        return this.brandService.findAll();
    }

    @GetMapping(path = { "/{brandId}" })
    public BrandDto getBrandById(@PathVariable("brandId") Long brandId) {
        return this.brandService.findById(brandId);
    }

    @PostMapping(path = { "", "/" })
    public BrandDto addBrand(@RequestBody BrandDto brandDto) {
        return this.brandService.save(brandDto);
    }

    @PutMapping(path = { "/{brandId}" })
    public BrandDto updateBrand(@PathVariable("brandId") Long brandId, @RequestBody BrandDto brandDto) {
        brandDto = brandService.update(brandDto, brandId);
        return brandDto;
    }

    @DeleteMapping(path = { "/{brandId}" })
    public void deleteBrand(@PathVariable("brandId") Long brandId) {
        brandService.deleteById(brandId);
    }
}