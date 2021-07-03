package com.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.domain.entity.acciones.Efecto;

@Repository
public interface EfectoRepository extends JpaRepository<Efecto, Integer> {

}
