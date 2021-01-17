package com.test;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.producto.Producto;

@Repository
public interface ProductoUsuarioRepository extends JpaRepository<ProductoUsuario, ProductoUsuarioId>{

}
