package com.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.user.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
	public Optional<Usuario> findByUsernameAndPassword(String username, String password);
	public Optional<Usuario> findByUsername(String username);
	
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
