package com.mural_caronas.demo.repository;

import com.mural_caronas.demo.entity.Carona;
import com.mural_caronas.demo.enums.StatusCaronaEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CaronaRepository extends JpaRepository<Carona, Long> {
    List<Carona> findByStatus(StatusCaronaEnum status);

}
