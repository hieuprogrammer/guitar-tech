package io.hieu.guitartech.controller;

import io.hieu.guitartech.dto.model.GuitarDto;
import io.hieu.guitartech.service.GuitarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = { "http://127.0.0.1:4200" })
@RequestMapping(path = { "/api/v1/guitars", "/api/v1/guitars.html" })
@RestController
public class GuitarController {
    private final GuitarService guitarService;

    @Autowired
    public GuitarController(GuitarService guitarService) {
        this.guitarService = guitarService;
    }

    @GetMapping(path = { "", "/" })
    public List<GuitarDto> getGuitars() {
        return this.guitarService.findAll();
    }

    @GetMapping(path = { "/{guitarId}" })
    public GuitarDto getGuitarById(@PathVariable("guitarId") Long guitarId) {
        return this.guitarService.findById(guitarId);
    }

    @PostMapping(path = { "", "/" })
    public GuitarDto addGuitar(@RequestBody GuitarDto guitarDto) {
        return this.guitarService.save(guitarDto);
    }

    @PutMapping(path = { "/{guitarId}" })
    public GuitarDto updateGuitar(@PathVariable("guitarId") Long guitarId, @RequestBody GuitarDto guitarDto) {
        guitarDto = guitarService.update(guitarDto, guitarId);
        return guitarDto;
    }

    @DeleteMapping(path = { "/{guitarId}" })
    public void deleteGuitar(@PathVariable("guitarId") Long guitarId) {
        guitarService.deleteById(guitarId);
    }
}