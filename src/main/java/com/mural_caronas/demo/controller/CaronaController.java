package com.mural_caronas.demo.controller;

import com.mural_caronas.demo.dto.CaronaResponseDTO;
import com.mural_caronas.demo.service.CaronaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/caronas")
@CrossOrigin("*")
public class CaronaController {

    @Autowired
    private CaronaService caronaService;

    @GetMapping
    public List<CaronaResponseDTO> findByDisponivel(){
        return caronaService.findByDisponivel();
    }

    @GetMapping("/{id}")
    public Optional<CaronaResponseDTO> findById(@PathVariable Long id){
        return caronaService.findById(id);
    }

    @PostMapping
    public ResponseEntity<CaronaResponseDTO> salvar(@RequestBody CaronaResponseDTO dto){
        CaronaResponseDTO criada = caronaService.salvar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(criada);
    }
}
