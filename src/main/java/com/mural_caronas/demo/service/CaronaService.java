package com.mural_caronas.demo.service;

import com.mural_caronas.demo.dto.CaronaResponseDTO;
import com.mural_caronas.demo.entity.Carona;
import com.mural_caronas.demo.enums.StatusCaronaEnum;
import com.mural_caronas.demo.mapper.CaronaMapper;
import com.mural_caronas.demo.repository.CaronaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CaronaService {

    @Autowired
    private CaronaRepository caronaRepository;

    @Autowired
    private CaronaMapper caronaMapper;

    public List<CaronaResponseDTO> findByDisponivel(){
        var result = caronaRepository.findByStatus(StatusCaronaEnum.DISPONIVEL);
        return caronaMapper.toResponseDTOList(result);
    }

    public Optional<CaronaResponseDTO> findById(Long id){
        return  caronaRepository.findById(id).map(caronaMapper::toResponseDTO);

    }

    public CaronaResponseDTO salvar(CaronaResponseDTO dto){
        Carona carona = caronaMapper.toEntity(dto);
        Carona salva = caronaRepository.save(carona);
        return caronaMapper.toResponseDTO(salva);
    }
}
