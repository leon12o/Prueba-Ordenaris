package com.prueba.ordenaris.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prueba.ordenaris.persistence.entity.Puesto;

public interface PuestoRepository extends JpaRepository<Puesto, Long> {

}
