package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.model.producto.ProductoUsuario;
import com.model.producto.ProductoUsuarioId;

@Repository
public interface ProductoUsuarioRepository extends JpaRepository<ProductoUsuario,ProductoUsuarioId>{
	@Query(value = 
			  "SELECT * FROM productoUsuario " + 
			  "WHERE id=?1",
			  nativeQuery = true)
	List<ProductoUsuario> findByUsuario(Integer id);
}
