package com.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.user.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
	public Optional<Usuario> findByUsernameAndPassword(String username, String password);
	public Optional<Usuario> findByUsername(String username);
}
