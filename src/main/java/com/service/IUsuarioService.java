package com.service;

import java.util.List;

import com.dto.producto.ProductoDto;
import com.dto.producto.ProductoUsuarioDto;
import com.dto.user.UsuarioDto;

public interface IUsuarioService {
	//Busqueda
	List<UsuarioDto> getAll();
	UsuarioDto getById(Integer id);
	UsuarioDto getByUserName(String username);
	//CRUD
	void crear(UsuarioDto user);
	void guardar(UsuarioDto user);
	void borrar(UsuarioDto user);
	void modificar(UsuarioDto user);
	//Acciones
	boolean usar(UsuarioDto user, ProductoDto producto);
	boolean comprar(UsuarioDto user, ProductoDto prod);
	void punto(UsuarioDto user);
	UsuarioDto validar(UsuarioDto user);
	//Productos
	List<ProductoUsuarioDto> getProductos(UsuarioDto user);
	//Recompensas diarias
	boolean reclamarDaily(UsuarioDto user);
	void reiniciarDaily();
}
