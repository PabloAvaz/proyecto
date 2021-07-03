package com.domain.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.domain.entity.user.Perfil;


@Repository
public interface PerfilRepository extends JpaRepository<Perfil, Integer>{

}
