package io.hieu.guitartech.service.v2;

import io.hieu.guitartech.domain.Guitar;
import io.hieu.guitartech.dto.model.GuitarDto;
import java.util.List;
import java.util.Optional;

public interface GuitarServiceV2 {
    GuitarDto save(GuitarDto guitarDto);

    List<GuitarDto> findAll();

    Optional<GuitarDto> findById(Long guitarId);

    GuitarDto update(Long guitarId, GuitarDto guitarDto);

    void delete(Guitar Guitar);

    void deleteById(Long guitarId);

    List<GuitarDto> search(String keyword);

//    Iterable<Guitar> findAll(Sort sort);

//    Page<Guitar> findAll(Pageable pageable);
}