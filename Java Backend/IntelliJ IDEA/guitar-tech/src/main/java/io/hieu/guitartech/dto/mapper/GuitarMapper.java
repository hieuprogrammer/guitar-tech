package io.hieu.guitartech.dto.mapper;

import io.hieu.guitartech.domain.Brand;
import io.hieu.guitartech.domain.Guitar;
import io.hieu.guitartech.dto.model.GuitarDto;

public class GuitarMapper {
    public static GuitarDto toGuitarDto(Guitar guitar) {
        return new GuitarDto(
                guitar.getId(),
                guitar.getBrand().getId(),
                guitar.getBrand().getName(),
                guitar.getModel(),
                guitar.getNumberOfFrets(),
                guitar.getNumberOfStrings(),
                guitar.getNumberOfPickups(),
                guitar.getPickupsType(),
                guitar.getImageUrl(),
                guitar.getPrice());
    }

    public static Guitar toGuitar(GuitarDto guitarDto) {
        Guitar guitar = new Guitar();
        guitar.setBrand(new Brand(guitarDto.getBrandId()));
        guitar.setModel(guitarDto.getModel());
        guitar.setNumberOfFrets(guitarDto.getNumberOfFrets());
        guitar.setNumberOfStrings(guitarDto.getNumberOfStrings());
        guitar.setNumberOfPickups(guitarDto.getNumberOfPickups());
        guitar.setPickupsType(guitarDto.getPickupsType());
        guitar.setImageUrl(guitarDto.getImageUrl());
        guitar.setPrice(guitarDto.getPrice());
        return guitar;
    }
}