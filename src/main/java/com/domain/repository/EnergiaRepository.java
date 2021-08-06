package com.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.domain.entity.user.Energia;

@Repository
public interface EnergiaRepository extends JpaRepository<Energia, Integer>{

}
