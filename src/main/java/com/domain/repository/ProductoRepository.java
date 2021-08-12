package com.domain.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.domain.entity.producto.Producto;
import com.enums.Tipo;


@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer>{
	public List<Producto> findByTipo(Tipo tipo);
	@Query(
			value= "select * from producto p where idProducto not in ( " +
					"select p.idProducto from productoUsuario p " +
					"join producto prod  ON prod.idProducto = p.idProducto " +
					"where prod.tipo = 0 and id = ?1) and p.activo = 1",
					nativeQuery = true)
	public List<Producto> getListaCompra(Integer idUser);
}