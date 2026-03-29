package com.pe.atencion.web.mapper;

import com.pe.atencion.persistence.entity.Servicio;
import com.pe.atencion.web.dto.request.ServicioRequestDTO;
import com.pe.atencion.web.dto.response.ServicioResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ServicioMapper {

    @Mapping(source = "area.id", target = "areaId")
    @Mapping(source = "area.nombre", target = "areaNombre")
    ServicioResponseDTO toResponseDTO(Servicio servicio);

    List<ServicioResponseDTO> toResponseDTOList(List<Servicio> servicios);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "area", ignore = true) // El área se asigna en el servicio
    Servicio toEntity(ServicioRequestDTO requestDTO);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "area", ignore = true)
    void updateEntity(@MappingTarget Servicio servicio, ServicioRequestDTO requestDTO);
}
