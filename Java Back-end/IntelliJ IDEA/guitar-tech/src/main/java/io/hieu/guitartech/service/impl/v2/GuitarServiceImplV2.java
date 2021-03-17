package io.hieu.guitartech.service.impl.v2;

import io.hieu.guitartech.domain.Brand;
import io.hieu.guitartech.domain.Guitar;
import io.hieu.guitartech.dto.mapper.GuitarMapper;
import io.hieu.guitartech.dto.model.GuitarDto;
import io.hieu.guitartech.repository.GuitarRepository;
import io.hieu.guitartech.service.v2.GuitarServiceV2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class GuitarServiceImplV2 implements GuitarServiceV2 {
    private final GuitarRepository guitarRepository;

    @Autowired
    public GuitarServiceImplV2(GuitarRepository guitarRepository) {
        this.guitarRepository = guitarRepository;
    }

    @Override
    public GuitarDto save(GuitarDto guitarDto) {
        Guitar guitar = GuitarMapper.toGuitar(guitarDto);
        guitar = guitarRepository.save(guitar);

        return GuitarMapper.toGuitarDto(guitar);
    }

    @Override
    public List<GuitarDto> findAll() {
        List<Guitar> guitars = guitarRepository.findAll();
        List<GuitarDto> guitarDtos = new ArrayList<GuitarDto>();
        for (Guitar guitar : guitars) {
            guitarDtos.add(GuitarMapper.toGuitarDto(guitar));
        }

        return guitarDtos;
    }

    @Override
    public Optional<GuitarDto> findById(Long guitarId) {
//        Guitar guitar = guitarRepository.findById(guitarId).get();
//        GuitarDto guitarDto = GuitarMapper.toGuitarDto(guitar);
//        Optional<GuitarDto> guitarDtoOptional = Optional.of(guitarDto);
//        return guitarDtoOptional;

        return guitarRepository.findById(guitarId).map(guitarOptional -> GuitarMapper.toGuitarDto(guitarOptional));
    }

    @Override
    public List<GuitarDto> search(String keyword) {
        List<Guitar> guitars = guitarRepository.search(keyword);
        List<GuitarDto> guitarDtos = new ArrayList<GuitarDto>();
        for (Guitar guitar : guitars) {
            guitarDtos.add(GuitarMapper.toGuitarDto(guitar));
        }

        return guitarDtos;
    }

    @Override
    public GuitarDto update(Long guitarId, GuitarDto guitarDto) {
        Guitar guitar = guitarRepository.findById(guitarId).get();
        guitar.setBrand(new Brand(guitarDto.getBrandId()));
        guitar.setModel(guitarDto.getModel());
        guitar.setNumberOfFrets(guitarDto.getNumberOfFrets());
        guitar.setNumberOfStrings(guitarDto.getNumberOfStrings());
        guitar.setNumberOfPickups(guitarDto.getNumberOfPickups());
        guitar.setPickupsType(guitarDto.getPickupsType());
        guitar.setImage(guitarDto.getImageUrl());
        guitar.setPrice(guitarDto.getPrice());

        return GuitarMapper.toGuitarDto(guitar);
    }

    @Override
    public void delete(Guitar guitar) {
        guitarRepository.delete(guitar);
    }

    @Override
    public void deleteById(Long guitarId) {
        guitarRepository.deleteById(guitarId);
    }
}