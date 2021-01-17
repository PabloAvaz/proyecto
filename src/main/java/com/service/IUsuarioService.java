package com.service;

import java.util.List;

import com.model.producto.Producto;
import com.model.producto.ProductoUsuario;
import com.model.user.Usuario;

public interface IUsuarioService {
	List<Usuario> getAll();
	Usuario getById(Integer id);
	Usuario getByUserName(String username);
	void guardar(Usuario user);
	void borrar(Usuario user);
	void modificar(Usuario user);
	void punto(Usuario user);
	Usuario validar(Usuario user);
	void usar(Usuario user, Producto producto);
	boolean comprar(Usuario user, Producto prod);
	List<ProductoUsuario> getProductos(Usuario user);
}
