package com.service.bd;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.model.interfaces.Consumible;
import com.model.interfaces.Equipable;
import com.model.producto.Producto;
import com.model.user.Usuario;
import com.repository.UsuarioRepository;
import com.service.IUsuarioService;

@Service
@Primary
public class UsuariosJpaService implements IUsuarioService {
	@Autowired
	private UsuarioRepository repoUsuarios;
	@Override
	public List<Usuario> getAll() {
		return repoUsuarios.findAll();
	}

	@Override
	public Usuario getById(Integer id) {
		Optional<Usuario> user = repoUsuarios.findById(id);
		return user.isPresent() ? user.get() : null;
	}

	@Override
	public Usuario getByUserName(String username) {
		Optional<Usuario> user = repoUsuarios.findByUsername(username);
		return user.isPresent() ? user.get() : null;
	}

	@Override
	public void guardar(Usuario user) {
		repoUsuarios.save(user);
	}

	@Override
	public void borrar(Usuario user) {
		repoUsuarios.delete(user);
	}

	@Override
	public void modificar(Usuario user) {
		Optional<Usuario> tmp = repoUsuarios.findByUsername(user.getUsername());
		if(tmp.isPresent()) {
			Usuario userFinal = tmp.get();
			userFinal.setNombre(user.getNombre());
			userFinal.setUsername(user.getUsername());
			userFinal.setPassword(user.getPassword());
			userFinal.setEstatus(user.isEstatus());
			userFinal.setPuntos(user.getPuntos());
			repoUsuarios.save(userFinal);
		}
	}

	@Override
	public void punto(Usuario user) {
		user.anotar();
		Optional<Usuario> tmp = repoUsuarios.findById(user.getId());
		if(tmp.isPresent()) {
			Usuario userFinal = tmp.get();
			userFinal.setPuntos(user.getPuntos());
			repoUsuarios.save(userFinal);
		}
	}

	@Override
	public Usuario validar(Usuario user) {
		Optional<Usuario> tmp =  repoUsuarios.findByUsernameAndPassword(user.getUsername(), user.getPassword());
		return tmp.isPresent() ? tmp.get() : null;
	}

	@Override
	public boolean comprar(Usuario user, Producto prod) {
		if(user.getPuntos() >= prod.getPrecio()) {
			user.gastar(prod.getPrecio());
			user.comprar(prod);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void usar(Usuario user, Consumible consumible) {
		
	}

	@Override
	public void equipar(Usuario user, Equipable equipo) {
		
	}

	@Override
	public void desequipar(Usuario user, Equipable equipo) {
		
	}


}
