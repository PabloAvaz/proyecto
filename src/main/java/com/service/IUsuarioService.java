package com.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.dto.producto.ProductoDto;
import com.dto.producto.ProductoUsuarioDto;
import com.dto.user.UsuarioDto;

/**
 * Interfaz con los metodos para gestionar la clase usuario
 * @author Pablo
 *
 */
public interface IUsuarioService {
	//Busqueda
	List<UsuarioDto> getAll();
	Page<UsuarioDto> getAll(Pageable page);
	UsuarioDto getById(Integer id);
	UsuarioDto getByUserName(String username);
	UsuarioDto getByEmail(String email);
	//CRUD
	void crear(UsuarioDto user);
	void guardar(UsuarioDto user);
	void borrar(UsuarioDto user);
	void modificar(UsuarioDto user);
	//Acciones
	boolean usar(UsuarioDto user, ProductoDto producto, Integer cantidad);
	boolean comprar(UsuarioDto user, ProductoDto prod, Integer cantidad);
	void punto(UsuarioDto user);
	UsuarioDto validar(UsuarioDto user);
	void actualizarPuntos(UsuarioDto user);
	//Productos
	List<ProductoUsuarioDto> getProductos(UsuarioDto user);
	//Recompensas diarias
	boolean reclamarDaily(UsuarioDto user);
	void reiniciarDaily();
	//Validaciones
	Boolean existe(UsuarioDto user);
}
