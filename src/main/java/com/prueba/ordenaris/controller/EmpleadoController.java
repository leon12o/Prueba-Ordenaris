package com.prueba.ordenaris.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.ordenaris.dto.request.EmpleadoRequest;
import com.prueba.ordenaris.persistence.entity.Empleado;
import com.prueba.ordenaris.service.EmpleadoService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/empleados")
@RequiredArgsConstructor
public class EmpleadoController {
    private final EmpleadoService empleadoService;

    @PostMapping
    public ResponseEntity<EmpleadoRequest> registrar(@RequestBody @Valid EmpleadoRequest empleadoRequest) {
        return new ResponseEntity<>(empleadoService.registrarEmpleado(empleadoRequest), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmpleadoRequest> editar(@PathVariable Long id,
            @RequestBody @Valid EmpleadoRequest empleadoRequest) {
        return new ResponseEntity<>(empleadoService.registrarEmpleado(empleadoRequest), HttpStatus.CREATED);
    }

    @GetMapping
    public Page<Empleado> listar(@RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "id") String sortBy) {
        return empleadoService.listarEmpleados(pageNo, pageSize, sortBy);
    }

    @GetMapping("/organigrama")
    public ResponseEntity<List<EmpleadoRequest>> listarOrganigrama() {
        return new ResponseEntity<>(empleadoService.listarEmpleadosOrganigrama(), HttpStatus.OK);
    }
}
