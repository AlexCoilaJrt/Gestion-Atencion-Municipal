package com.pe.atencion.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * Entidad que representa una oficina o área municipal (Ej: Tesorería, Catastro).
 */
@Entity
@Table(name = "areas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Area {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = false, unique = true, length = 1)
    private String prefijo;

    @Column(name = "color_hex", length = 7)
    @Builder.Default
    private String colorHex = "#3b82f6";

    @Column(length = 50)
    private String icono;

    @Column(nullable = false)
    @Builder.Default
    private Boolean activo = true;
}
