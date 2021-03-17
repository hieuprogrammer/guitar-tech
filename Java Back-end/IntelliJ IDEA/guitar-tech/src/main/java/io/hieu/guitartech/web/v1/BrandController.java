package io.hieu.guitartech.web.v1;

import io.hieu.guitartech.dto.model.BrandDto;
import io.hieu.guitartech.service.v1.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Deprecated
@CrossOrigin(origins = { "http://127.0.0.1:4200" })
@RequestMapping(path = { "/api/v1/brands", "/api/v1/brands.html" })
@RestController
public class BrandController {
    /* Fields */
    private final BrandService brandService;

    /* Constructors */
    @Autowired
    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    /* Request methods */
    /* CREATE (POST mappings) */
    @PostMapping(path = { "", "/" })
    public BrandDto addBrand(@RequestBody BrandDto brandDto) {
        return this.brandService.save(brandDto);
    }

    /* UPDATE (PUT mappings) */
    @PutMapping(path = { "/{brandId}" })
    public BrandDto updateBrand(@PathVariable("brandId") Long brandId, @RequestBody BrandDto brandDto) {
        brandDto = brandService.update(brandId, brandDto);
        return brandDto;
    }

    /* RETRIEVE (GET mappings) */
    @GetMapping(path = { "", "/" })
    public List<BrandDto> getBrands() {
        return this.brandService.findAll();
    }

    @GetMapping(path = { "/{brandId}" })
    public BrandDto getBrandById(@PathVariable("brandId") Long brandId) {
        return this.brandService.findById(brandId);
    }

    /* DELETE (DELETE mappings) */
    @DeleteMapping(path = { "/{brandId}" })
    public void deleteBrand(@PathVariable("brandId") Long brandId) {
        brandService.deleteById(brandId);
    }
}