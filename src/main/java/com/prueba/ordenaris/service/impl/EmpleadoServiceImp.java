package com.prueba.ordenaris.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.prueba.ordenaris.dto.request.DireccionRequest;
import com.prueba.ordenaris.dto.request.EmpleadoRequest;
import com.prueba.ordenaris.mapper.EmpleadoMapper;
import com.prueba.ordenaris.persistence.entity.Direccion;
import com.prueba.ordenaris.persistence.entity.Empleado;
import com.prueba.ordenaris.persistence.entity.Puesto;
import com.prueba.ordenaris.persistence.repository.DireccionRepository;
import com.prueba.ordenaris.persistence.repository.EmpleadoRepository;
import com.prueba.ordenaris.persistence.repository.PuestoRepository;
import com.prueba.ordenaris.service.EmpleadoService;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmpleadoServiceImp implements EmpleadoService {
    private final EmpleadoRepository empleadoRepository;
    private final DireccionRepository direccionRepository;
    private final PuestoRepository puestoRepository;
    // private final EmpleadoMapper empleadoMapper;

    @Override
    public EmpleadoRequest registrarEmpleado(EmpleadoRequest empleado) {
        Empleado empleadoEntity = empleadoRepository.save(convierteToEmpleado(empleado));
        return convierteToEmpleadoRequest(empleadoEntity);
    }

    @Override
    public void editarEmpleado(Long id, EmpleadoRequest empleado) {
        Empleado empleadoActualizar = empleadoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No se encontro el empleado con id " + id));
        empleadoActualizar.setNombre(empleado.nombre());
        empleadoActualizar.setApellidos(empleado.apellidos());
        empleadoActualizar.setPuesto(empleado.puesto() == null ? null : obtienePuesto(empleado.puesto()));
        empleadoActualizar.setJefeInmediato(
                empleado.idJefeInmediato() == null ? null : obtieneEmpleado(empleado.idJefeInmediato()));
        empleadoRepository.save(empleadoActualizar);
    }

    @Override
    public Page<Empleado> listarEmpleados(Integer pageNo, Integer pageSize, String sortBy) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        List<Empleado> empleados = empleadoRepository.findAll();
        return empleadoRepository.findAll(pageable);
    }

    private EmpleadoRequest convierteToEmpleadoRequest(Empleado empleado) {

        return EmpleadoRequest.builder()
                .id(empleado.getId())
                .nombre(empleado.getNombre())
                .apellidos(empleado.getApellidos())
                .curp(empleado.getCurp())
                .puesto(empleado.getPuesto().getId())
                .idJefeInmediato(
                        empleado.getJefeInmediato() == null ? null : empleado.getJefeInmediato().getId())
                // .empleado(empleado.getJefeInmediato() == null ? null
                // : convierteToEmpleadoRequest(empleado.getJefeInmediato()))
                .subordinados(new ArrayList<>())
                .direccion(convierteToDireccionRequest(empleado.getDireccion()))
                .build();
    }

    private DireccionRequest convierteToDireccionRequest(Direccion direccion) {
        return DireccionRequest.builder()
                .calle(direccion.getCalle())
                .noExterior(direccion.getNoExterior())
                .noInterior(direccion.getNoInterior())
                .colonia(direccion.getColonia())
                .municipio(direccion.getMunicipio())
                .estado(direccion.getEstado())
                .pais(direccion.getPais())
                .build();
    }

    private Empleado convierteToEmpleado(EmpleadoRequest empleadoRequest) {
        return Empleado.builder()
                // .id(empleadoRequest.curp().concat(generaDigitosExtra()))
                .nombre(empleadoRequest.nombre())
                .apellidos(empleadoRequest.apellidos())
                .curp(empleadoRequest.curp())
                .puesto(empleadoRequest.puesto() == null ? null : obtienePuesto(empleadoRequest.puesto()))
                .jefeInmediato(
                        empleadoRequest.idJefeInmediato() == null ? null
                                : obtieneEmpleado(empleadoRequest.idJefeInmediato()))
                .direccion(convierteToDireccion(empleadoRequest.direccion()))
                .build();
    }

    private Direccion convierteToDireccion(DireccionRequest direccionRequest) {
        return Direccion.builder()
                .calle(direccionRequest.calle())
                .noExterior(direccionRequest.noExterior())
                .noInterior(direccionRequest.noInterior())
                .colonia(direccionRequest.colonia())
                .municipio(direccionRequest.municipio())
                .estado(direccionRequest.estado())
                .pais(direccionRequest.pais())
                .build();
    }

    private Puesto obtienePuesto(Long id) {
        return puestoRepository.findById(id).orElse(null);
    }

    private Empleado obtieneEmpleado(Long id) {
        return empleadoRepository.findById(id).orElse(null);
    }

    @Override
    public List<EmpleadoRequest> listarEmpleadosOrganigrama() {
        List<EmpleadoRequest> empleadoRequests = empleadoRepository.findAll().stream()
                .map(this::convierteToEmpleadoRequest).collect(Collectors.toList());

        return empleadoRequests.stream().map(empleadoRequest -> {
            List<Empleado> subordinados = empleadoRepository.findByJefeInmediatoId(empleadoRequest.id());
            empleadoRequest.subordinados()
                    .addAll(subordinados == null ? new ArrayList<>()
                            : subordinados.stream().map(this::convierteToEmpleadoRequest).collect(Collectors.toList()));
            return empleadoRequest;
        }).collect(Collectors.toList());
    }

    private String generaDigitosExtra() {
        Random random = new Random();
        int numero1 = random.nextInt();
        int numero2 = random.nextInt();
        return numero1 + "" + numero2;
    }

}
