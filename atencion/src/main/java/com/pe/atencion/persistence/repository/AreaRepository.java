package com.pe.atencion.persistence.repository;

import com.pe.atencion.persistence.entity.Area;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AreaRepository extends JpaRepository<Area, Integer> {
    Optional<Area> findByPrefijo(String prefijo);
}
