package com.service;

import java.util.List;

import com.model.producto.Producto;

public interface IProductoService {
	List<Producto> getAll();
	Producto getById(int id);
	void guardar(Producto producto);
	void eliminar(Producto producto);
	void eliminar(int id);
	void update(Producto producto);
}
