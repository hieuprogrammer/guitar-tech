package io.hieu.guitartech.web.v2.api.rest;

import io.hieu.guitartech.dto.model.GuitarDto;
import io.hieu.guitartech.service.v2.GuitarServiceV2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = { "http://127.0.0.1:4200", "http://localhost:4200" })
@RequestMapping(name = "Guitar REST APIs", path = { "/api/v2/guitars" })
@RestController
public class GuitarRestApi {
    /* Fields */
    private final GuitarServiceV2 guitarServiceV2;

    @Autowired
    public GuitarRestApi(GuitarServiceV2 guitarServiceV2) {
        this.guitarServiceV2 = guitarServiceV2;
    }

    /* Request methods */
    /* CREATE (POST mappings) */
    @PostMapping(path = { "" })
    public ResponseEntity<GuitarDto> addGuitar(@RequestBody GuitarDto guitarDto) {
        guitarDto = guitarServiceV2.save(guitarDto);
        return new ResponseEntity<GuitarDto>(guitarDto, HttpStatus.CREATED);
    }

    /* UPDATE (PUT mappings) */
    @PutMapping(path = { "/{guitarId}" })
    public ResponseEntity<GuitarDto> updateGuitar(@PathVariable("guitarId") Long guitarId, @RequestBody GuitarDto guitarDto) {
        guitarDto = guitarServiceV2.update(guitarId, guitarDto);
        return new ResponseEntity<GuitarDto>(guitarDto, HttpStatus.OK);
    }

    /* RETRIEVE (GET mappings) */
    @GetMapping(path = { "" })
    public ResponseEntity<List<GuitarDto>> getGuitars() {
        List<GuitarDto> guitarDtos = guitarServiceV2.findAll();
        if (guitarDtos.isEmpty()) {
            return new ResponseEntity<List<GuitarDto>>(guitarDtos, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<GuitarDto>>(guitarDtos, HttpStatus.OK);
    }

    @GetMapping(path = { "/all" })
    public String viewBrands(Model model) {
        List<GuitarDto> guitarDtos = guitarServiceV2.findAll();
        model.addAttribute("guitarDtos", guitarDtos);
        return "guitar/index";
    }

    @GetMapping(path = { "/{guitarId}" })
    public ResponseEntity<GuitarDto> getGuitarById(@PathVariable("guitarId") Long guitarId) {
        Optional<GuitarDto> guitarDto = guitarServiceV2.findById(guitarId);
        if (guitarDto.isEmpty()) {
            return new ResponseEntity<GuitarDto>(guitarDto.get(), HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<GuitarDto>(guitarDto.get(), HttpStatus.OK);
    }

    @GetMapping(path = { "/search" })
    public ResponseEntity<List<GuitarDto>> search(@RequestParam("keyword") String keyword) {
        return new ResponseEntity<List<GuitarDto>>(guitarServiceV2.search(keyword), HttpStatus.OK);
    }

    /* DELETE (DELETE mappings) */
    @DeleteMapping(path = { "/{guitarId}" })
    public ResponseEntity<Void> deleteGuitar(@PathVariable("guitarId") Long guitarId) {
        guitarServiceV2.deleteById(guitarId);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}