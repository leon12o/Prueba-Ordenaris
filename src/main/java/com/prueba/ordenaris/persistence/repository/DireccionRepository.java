package com.prueba.ordenaris.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prueba.ordenaris.persistence.entity.Direccion;

public interface DireccionRepository extends JpaRepository<Direccion, Long> {

}
