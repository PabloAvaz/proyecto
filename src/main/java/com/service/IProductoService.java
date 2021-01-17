package com.service;

import java.util.List;

import com.model.enums.Tipo;
import com.model.producto.Producto;

public interface IProductoService {
	List<Producto> getAll();
	List<Producto> getByTipo(Tipo tipo);
	Producto getById(int id);
	void guardar(Producto producto);
	void eliminar(Producto producto);
	void eliminar(int id);
	void update(Producto producto);
}
