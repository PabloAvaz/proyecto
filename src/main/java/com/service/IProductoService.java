package com.service;

import java.util.List;

import com.dto.producto.ProductoDto;
import com.dto.user.UsuarioDto;
import com.enums.Tipo;

/**
 * Interfaz con los metodos para gestionar la clase producto
 * @author Pablo
 *
 */

public interface IProductoService {
	List<ProductoDto> getAll();
	List<ProductoDto> getByTipo(Tipo tipo);
	ProductoDto getById(int id);
	ProductoDto guardar(ProductoDto producto);
	void eliminar(ProductoDto producto);
	void eliminar(int id);
	void update(ProductoDto producto);
	List<ProductoDto> getListaCompraByUser(UsuarioDto user);
	public void toggle(ProductoDto producto);
}
