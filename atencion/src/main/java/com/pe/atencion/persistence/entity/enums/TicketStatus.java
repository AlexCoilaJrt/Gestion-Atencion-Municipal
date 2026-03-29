package com.pe.atencion.persistence.entity.enums;

/**
 * Estados posibles de un ticket en el sistema.
 */
public enum TicketStatus {
    ESPERA,
    LLAMANDO,
    ATENDIENDO,
    FINALIZADO,
    CANCELADO,
    DERIVADO,
    NO_PRESENTADO
}
