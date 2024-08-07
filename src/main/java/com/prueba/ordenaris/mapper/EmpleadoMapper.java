package com.prueba.ordenaris.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.prueba.ordenaris.dto.request.EmpleadoRequest;
import com.prueba.ordenaris.persistence.entity.Empleado;

@Mapper(componentModel = "spring")
public interface EmpleadoMapper {
    EmpleadoMapper INSTANCE = Mappers.getMapper(EmpleadoMapper.class);

    EmpleadoRequest empleadoToEmpleadoRequest(Empleado empleado);

    Empleado empleadoRequestToEmpleado(EmpleadoRequest empleadoRequest);
}
