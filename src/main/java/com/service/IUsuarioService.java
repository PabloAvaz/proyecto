package com.service;

import java.util.List;

import com.model.interfaces.Consumible;
import com.model.interfaces.Equipable;
import com.model.producto.Producto;
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
	boolean comprar(Usuario user, Producto prod);
	void usar(Usuario user, Consumible consumible);
	void equipar(Usuario user, Equipable equipo);
	void desequipar(Usuario user, Equipable equipo);

}
