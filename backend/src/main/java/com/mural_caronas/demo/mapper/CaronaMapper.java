package com.mural_caronas.demo.mapper;

import com.mural_caronas.demo.dto.CaronaResponseDTO;
import com.mural_caronas.demo.entity.Carona;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring",
        uses = CaronaMapper.class)
public interface CaronaMapper {
    List<CaronaResponseDTO> toResponseDTOList(List<Carona> entities);

    CaronaResponseDTO toResponseDTO(Carona entity);

    Carona toEntity(CaronaResponseDTO dto);
}
