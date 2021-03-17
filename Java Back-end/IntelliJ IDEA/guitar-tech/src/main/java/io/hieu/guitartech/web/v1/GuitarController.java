package io.hieu.guitartech.web.v1;

import io.hieu.guitartech.dto.model.GuitarDto;
import io.hieu.guitartech.service.v1.GuitarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Deprecated
@CrossOrigin(origins = { "http://127.0.0.1:4200" })
@RequestMapping(path = { "/api/v1/guitars", "/api/v1/guitars.html" })
@RestController
public class GuitarController {
    /* Fields */
    private final GuitarService guitarService;

    /* Constructors */
    @Autowired
    public GuitarController(GuitarService guitarService) {
        this.guitarService = guitarService;
    }

    /* Request methods */
    /* CREATE (POST mappings) */
    @PostMapping(path = { "", "/" })
    public GuitarDto addGuitar(@RequestBody GuitarDto guitarDto) {
        return this.guitarService.save(guitarDto);
    }

    /* UPDATE (PUT mappings) */
    @PutMapping(path = { "/{guitarId}" })
    public GuitarDto updateGuitar(@PathVariable("guitarId") Long guitarId, @RequestBody GuitarDto guitarDto) {
        guitarDto = guitarService.update(guitarId, guitarDto);
        return guitarDto;
    }

    /* RETRIEVE (GET mappings) */
    @GetMapping(path = { "", "/" })
    public List<GuitarDto> getGuitars() {
        return this.guitarService.findAll();
    }

    @GetMapping(path = { "/{guitarId}" })
    public GuitarDto getGuitarById(@PathVariable("guitarId") Long guitarId) {
        return this.guitarService.findById(guitarId);
    }

    /* DELETE (DELETE mappings) */
    @DeleteMapping(path = { "/{guitarId}" })
    public void deleteGuitar(@PathVariable("guitarId") Long guitarId) {
        guitarService.deleteById(guitarId);
    }
}