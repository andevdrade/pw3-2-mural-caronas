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
    public CaronaResponseDTO atualizar(Long id,CaronaResponseDTO dto){
        Carona caronaExistente = caronaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Carona não encontrada"));
        caronaExistente.setNome(dto.nome());
        caronaExistente.setStatus(dto.status());
        caronaExistente.setBairroOirgem(dto.bairroOrigem());
        caronaExistente.setVagasDisponiveis(dto.vagasDisponiveis());
        caronaExistente.setHorarioSaida(dto.horarioSaida());
        Carona salva = caronaRepository.save(caronaExistente);
        return caronaMapper.toResponseDTO(salva);
    }
    public void deletar(Long id){
        caronaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Carona não encontrada"));
        caronaRepository.deleteById(id);
    }
    public CaronaResponseDTO reservarVaga(Long id) {
        Carona carona = caronaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Carona não encontrada"));

        if (carona.getVagasDisponiveis() <= 0 || carona.getStatus() == StatusCaronaEnum.LOTADO) {
            throw new RuntimeException("Não há vagas disponíveis para esta carona!");
        }
        carona.setVagasDisponiveis(carona.getVagasDisponiveis() - 1);
        if (carona.getVagasDisponiveis() == 0) {
            carona.setStatus(StatusCaronaEnum.LOTADO);
        }
        Carona salva = caronaRepository.save(carona);
        return caronaMapper.toResponseDTO(salva);
    }
}
