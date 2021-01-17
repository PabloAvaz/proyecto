package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.acciones.AccionEquipable;

@Repository
public interface AccionEquipableRepository extends JpaRepository<AccionEquipable, Integer> {

}
