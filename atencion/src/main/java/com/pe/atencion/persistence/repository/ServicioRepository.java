package com.pe.atencion.persistence.repository;

import com.pe.atencion.persistence.entity.Servicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServicioRepository extends JpaRepository<Servicio, Integer> {
    List<Servicio> findByAreaId(Integer areaId);
    List<Servicio> findByActivoTrue();
}
