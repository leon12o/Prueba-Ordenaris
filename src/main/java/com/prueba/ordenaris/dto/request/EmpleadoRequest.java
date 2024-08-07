package com.prueba.ordenaris.dto.request;

import java.util.List;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;

@Builder
public record EmpleadoRequest(Long id, @NotEmpty(message = "{notempty.field}") String nombre,
        @NotEmpty(message = "{notempty.field}") String apellidos,
        @NotEmpty(message = "{notempty.field}") String curp,
        Long puesto,
        Long idJefeInmediato,
        @Valid DireccionRequest direccion,
        List<EmpleadoRequest> subordinados) {

}
