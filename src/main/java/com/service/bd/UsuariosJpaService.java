package com.service.bd;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.model.acciones.AccionEquipable;
import com.model.producto.Producto;
import com.model.producto.ProductoUsuario;
import com.model.producto.ProductoUsuarioId;
import com.model.user.Usuario;
import com.repository.AccionEquipableRepository;
import com.repository.ProductoUsuarioRepository;
import com.repository.UsuarioRepository;
import com.service.IUsuarioService;

@Service
@Primary
public class UsuariosJpaService implements IUsuarioService {
	@Autowired
	private UsuarioRepository repoUsuarios;
	@Autowired
	private ProductoUsuarioRepository repoProductoUsuario;
	@Autowired
	private AccionEquipableRepository repoAccionEquipable;
	
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
		Optional<Usuario> tmp = repoUsuarios.findById(user.getId());
		if(tmp.isPresent()) {
			Usuario userFinal = tmp.get();
			userFinal.setNombre(user.getNombre());
			userFinal.setUsername(user.getUsername());
			userFinal.setEstatus(user.isEstatus());
			userFinal.setPuntos(user.getPuntos());
			userFinal.setArticulos(user.getArticulos());
			if(!user.getPassword().equals(""))userFinal.setPassword(user.getPassword());
			if(user.getSkin()!=null)userFinal.setSkin(user.getSkin());
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
		if(prod != null && user.getPuntos() >= prod.getPrecio()) {
			if(!user.getArticulos().contains(prod)) {
				user.comprar(prod);
			} else {
				ProductoUsuarioId id = new ProductoUsuarioId(prod,user);
				repoProductoUsuario.save(new ProductoUsuario(id,repoProductoUsuario.findById(id).get().getCantidad()+1));
			}
			user.gastar(prod.getPrecio());
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void usar(Usuario user, Producto producto) {
		switch(producto.getTipo()) {
			case CONSUMIBLE:
				
				break;
				
			case EQUIPABLE:
				Optional<AccionEquipable> accion = repoAccionEquipable.findById(producto.getId());
				if(accion.isPresent()) {
					user.setSkin(accion.get().getSkin());
				}
				break;
				
			default:
				System.out.println("Tipo de producto no válido");
				break;
		}
	}

	@Override
	public List<ProductoUsuario> getProductos(Usuario user) {
		return repoProductoUsuario.findByUsuario(user.getId());
	}




}
