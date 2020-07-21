package io.hieu.guitartech.service;

import io.hieu.guitartech.domain.Guitar;
import io.hieu.guitartech.dto.model.GuitarDto;

import java.util.List;

public interface GuitarService {
    GuitarDto save(GuitarDto guitarDto);

    List<GuitarDto> findAll();

    GuitarDto findById(Long id);

    GuitarDto update(GuitarDto guitarDto, Long id);

    void delete(Guitar guitar);

    void deleteById(Long id);
}