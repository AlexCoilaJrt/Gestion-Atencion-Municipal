package com.pe.atencion.area.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AreaRequestDTO {
    @NotBlank(message = "El nombre es obligatorio")
    @Size(max = 100)
    private String nombre;

    @NotBlank(message = "El prefijo es obligatorio")
    @Size(min = 1, max = 1)
    private String prefijo;

    @Size(max = 7)
    private String colorHex;

    @Size(max = 50)
    private String icono;

    private Boolean activo;
}
