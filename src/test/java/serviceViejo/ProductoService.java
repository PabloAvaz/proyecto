package serviceViejo;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.model.enums.Tipo;
import com.model.producto.Producto;
import com.model.user.Usuario;
import com.service.IProductoService;

@Service
public class ProductoService implements IProductoService {
	private List<Producto> productos = new LinkedList<Producto>();
	private static int id = 0;
	
	@Override
	public List<Producto> getAll() {
		return productos;
	}

	@Override
	public Producto getById(int id) {
		List<Producto> products = productos.stream().filter(prd->prd.getId() == id).collect(Collectors.toList());
		return products.size() > 0 ? products.get(0) : null;
	}

	@Override
	public void guardar(Producto producto) {
		producto.setId(++id);
		productos.add(producto);
	}
	@Override
	public void eliminar(Producto producto) {
		productos.remove(producto);
		
	}
	@Override
	public void eliminar(int id) {
		Producto p = getById(id);
		if(p != null) eliminar(p);
	}
	@Override
	public void update(Producto producto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Producto> getByTipo(Tipo tipo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Producto> getListaCompraByUser(Usuario user) {
		// TODO Auto-generated method stub
		return null;
	}



}
