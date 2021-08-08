package com.domain.repository;


import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.domain.entity.user.Usuario;
import com.dto.user.UsuarioDto;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
	public Optional<Usuario> findByUsernameAndPassword(String username, String password);
	public Optional<Usuario> findByUsername(String username);
	
	@Transactional
	@Modifying(flushAutomatically = true, clearAutomatically = true)
	@Query("UPDATE Usuario SET username = :#{#usuario.username}")
	public void update(@Param(value = "usuario") Usuario usuario);
	
	@Modifying(flushAutomatically = true, clearAutomatically = true)
	@Query("UPDATE Usuario SET puntos = :#{#usuario.puntos} WHERE id = :#{#usuario.id}")
	public void gastarPuntos(UsuarioDto usuario);
	/*
    @Transactional
	@Modifying
	@Query(
			  value = 
			  "UPDATE productoUsuario " + 
			  "SET cantidad=?1 WHERE id=?2 AND idProducto=?3",
			  nativeQuery = true)
	public void comprarArticulo(Integer cantidad, Integer idUsr, Integer IdProd);
	@Query(
			  value = 
			  "SELECT cantidad FROM productoUsuario " + 
			  "WHERE id=?1 AND idProducto=?2",
			  nativeQuery = true)
	public Integer countArticulos(Integer idUsr, Integer IdProd);
	*/


}
