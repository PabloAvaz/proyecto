package com.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.enums.Tipo;
import com.model.producto.Producto;


@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer>{
	public List<Producto> findByTipo(Tipo tipo);
}