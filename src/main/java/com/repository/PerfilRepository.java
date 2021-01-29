package com.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.user.Perfil;


@Repository
public interface PerfilRepository extends JpaRepository<Perfil, Integer>{

}
