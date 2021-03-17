package io.hieu.guitartech.web.v2;

import io.hieu.guitartech.dto.model.BrandDto;
import io.hieu.guitartech.service.v2.BrandServiceV2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = { "http://127.0.0.1:4200" })
@RequestMapping(name = "Brand Controller", path = { "/api/v2/brands" })
//@RestController
@Controller
public class BrandControllerV2 {
    /* Fields */
    private final BrandServiceV2 brandServiceV2;

    /* Constructors */
    @Autowired
    public BrandControllerV2(BrandServiceV2 brandServiceV2) {
        this.brandServiceV2 = brandServiceV2;
    }

    /* Request methods */
    /* CREATE (POST mappings) */
    @ResponseBody
    @PostMapping(path = { "" })
    public ResponseEntity<BrandDto> addBrand(@RequestBody BrandDto brandDto) {
        brandDto = brandServiceV2.save(brandDto);
        return new ResponseEntity<BrandDto>(brandDto, HttpStatus.CREATED);
    }

    /* UPDATE (PUT mappings) */
    @ResponseBody
    @PutMapping(path = { "/{brandId}" })
    public ResponseEntity<BrandDto> updateBrand(@PathVariable("brandId") Long brandId, @RequestBody BrandDto brandDto) {
        brandDto = brandServiceV2.update(brandId, brandDto);
        return new ResponseEntity<BrandDto>(HttpStatus.OK);
    }

    /* RETRIEVE (GET mappings) */
    @ResponseBody
    @GetMapping(path = { "" })
    public ResponseEntity<List<BrandDto>> getBrands() {
        List<BrandDto> brandDtos = brandServiceV2.findAll();
        if (brandDtos.isEmpty()) {
            return new ResponseEntity<List<BrandDto>>(brandDtos, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<BrandDto>>(brandDtos, HttpStatus.OK);
    }

    @GetMapping(path = { "/all" })
    public String viewBrands(Model model) {
        List<BrandDto> brandDtos = brandServiceV2.findAll();
        model.addAttribute("brandDtos", brandDtos);
        return "brand/index";
    }

    @ResponseBody
    @GetMapping(path = { "/{brandId}" })
    public ResponseEntity<BrandDto> getBrandById(@PathVariable("brandId") Long brandId) {
        Optional<BrandDto> brandDto = brandServiceV2.findById(brandId);
        if (brandDto.isEmpty()) {
            return new ResponseEntity<BrandDto>(brandDto.get(), HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<BrandDto>(brandDto.get(), HttpStatus.OK);
    }

    @ResponseBody
    @GetMapping(path = { "/search" })
    public ResponseEntity<List<BrandDto>> search(@RequestParam("keyword") String keyword) {
        return new ResponseEntity<List<BrandDto>>(brandServiceV2.search(keyword), HttpStatus.OK);
    }

    /* DELETE (DELETE mappings) */
    @ResponseBody
    @DeleteMapping(path = { "/{brandId}" })
    public ResponseEntity<Void> deleteBrand(@PathVariable("brandId") Long brandId) {
        brandServiceV2.deleteById(brandId);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}