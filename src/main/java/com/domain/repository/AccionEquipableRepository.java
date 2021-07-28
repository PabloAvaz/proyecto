package com.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.domain.entity.acciones.AccionEquipable;

@Repository
public interface AccionEquipableRepository extends JpaRepository<AccionEquipable, Integer> {

}
