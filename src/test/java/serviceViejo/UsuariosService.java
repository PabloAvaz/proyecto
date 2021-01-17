package serviceViejo;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.model.producto.Producto;
import com.model.user.Usuario;
import com.service.IUsuarioService;

@Service
public class UsuariosService implements IUsuarioService{
	private List<Usuario> usuarios = new LinkedList<Usuario>();
	private static int id = 0;
	

	@Override
	public List<Usuario> getAll() {
		return usuarios;
	}
	@Override
	public Usuario getById(Integer id) {
		List<Usuario> users = usuarios.stream().filter(usr->usr.getId() == id).collect(Collectors.toList());
		return users.size() > 0 ? users.get(0) : null;
	}
	@Override
	public void guardar(Usuario user) {
		user.setId(id++);
		user.setEstatus(true);
		usuarios.add(user);
	}

	@Override
	public void borrar(Usuario user) {
		usuarios.remove(user);		
	}

	@Override
	public void modificar(Usuario user) {
		
	}

	@Override
	public void punto(Usuario user) {
		user.anotar();
	}
	@Override
	public Usuario validar(Usuario user) {
		List<Usuario> users = usuarios.stream().filter(usr->usr.getUsername().equals(user.getUsername()) && usr.getPassword().equals(user.getPassword()) && usr.isEstatus() == true).collect(Collectors.toList());
		return users.size() > 0 ? users.get(0) : null;
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
	public Usuario getByUserName(String username) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void dar(Usuario user, Producto prod, Integer cantidad) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void usar(Usuario user, Producto producto) {
		// TODO Auto-generated method stub
		
	}

}
