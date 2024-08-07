package com.prueba.ordenaris.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.prueba.ordenaris.persistence.entity.Empleado;
import java.util.List;
import java.util.Optional;

public interface EmpleadoRepository
        extends JpaRepository<Empleado, Long>, PagingAndSortingRepository<Empleado, Long> {
    Optional<Empleado> findById(Long id);

    List<Empleado> findByJefeInmediatoId(Long id);
}
