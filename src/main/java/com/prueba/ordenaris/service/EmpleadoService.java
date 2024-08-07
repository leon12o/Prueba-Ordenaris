package com.prueba.ordenaris.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.prueba.ordenaris.dto.request.EmpleadoRequest;
import com.prueba.ordenaris.persistence.entity.Empleado;

public interface EmpleadoService {
    EmpleadoRequest registrarEmpleado(EmpleadoRequest empleado);

    void editarEmpleado(Long id, EmpleadoRequest empleado);

    Page<Empleado> listarEmpleados(Integer pageNo, Integer pageSize, String sortBy);

    List<EmpleadoRequest> listarEmpleadosOrganigrama();
}
