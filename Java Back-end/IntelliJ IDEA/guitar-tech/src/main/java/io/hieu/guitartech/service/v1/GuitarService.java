package io.hieu.guitartech.service.v1;

import io.hieu.guitartech.domain.Guitar;
import io.hieu.guitartech.dto.model.GuitarDto;

import java.util.List;

@Deprecated
public interface GuitarService {
    GuitarDto save(GuitarDto guitarDto);

    List<GuitarDto> findAll();

    GuitarDto findById(Long guitarId);

    GuitarDto update(Long guitarId, GuitarDto guitarDto);

    void delete(Guitar guitar);

    void deleteById(Long guitarId);
}