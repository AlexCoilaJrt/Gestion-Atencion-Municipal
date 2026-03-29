package com.pe.atencion.area.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AreaResponseDTO {
    private Integer id;
    private String nombre;
    private String prefijo;
    private String colorHex;
    private String icono;
    private Boolean activo;
}
