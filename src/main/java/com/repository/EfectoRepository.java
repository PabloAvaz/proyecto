package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.acciones.AccionEquipable;
import com.model.acciones.Efecto;

@Repository
public interface EfectoRepository extends JpaRepository<Efecto, Integer> {

}
