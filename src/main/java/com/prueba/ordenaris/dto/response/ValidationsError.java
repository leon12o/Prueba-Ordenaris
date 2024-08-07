package com.prueba.ordenaris.dto.response;

import java.time.LocalDateTime;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class ValidationsError {
    private Map<String, String> errors;
    private LocalDateTime timestamp;
}
