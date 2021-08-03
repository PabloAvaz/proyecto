package com.service;

import java.util.List;

import com.dto.producto.ProductoDto;
import com.dto.user.UsuarioDto;
import com.enums.Tipo;

public interface IProductoService {
	List<ProductoDto> getAll();
	List<ProductoDto> getByTipo(Tipo tipo);
	ProductoDto getById(int id);
	void guardar(ProductoDto producto);
	void eliminar(ProductoDto producto);
	void eliminar(int id);
	void update(ProductoDto producto);
	List<ProductoDto> getListaCompraByUser(UsuarioDto user);
}
