package com.prueba.ordenaris.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;

@Builder
public record DireccionRequest(@NotEmpty(message = "{notempty.field}") String calle,
        @NotEmpty(message = "{notempty.field}") String noExterior,
        String noInterior,
        @NotEmpty(message = "{notempty.field}") String colonia,
        @NotEmpty(message = "{notempty.field}") String municipio,
        @NotEmpty(message = "{notempty.field}") String estado,
        @NotEmpty(message = "{notempty.field}") String pais) {

}
