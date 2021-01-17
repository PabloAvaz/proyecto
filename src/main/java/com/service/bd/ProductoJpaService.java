package com.service.bd;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.model.enums.Tipo;
import com.model.producto.Producto;
import com.repository.ProductoRepository;
import com.service.IProductoService;

@Service
@Primary
public class ProductoJpaService implements IProductoService {
	@Autowired
	private ProductoRepository repoProductos;

	@Override
	public List<Producto> getAll() {
		return repoProductos.findAll();
	}
	
	@Override
	public List<Producto> getByTipo(Tipo tipo) {
		return repoProductos.findByTipo(tipo);
	}
	@Override
	public Producto getById(int id) {
		Optional<Producto> p = repoProductos.findById(id);
		return p.isPresent() ? p.get() : null;
	}

	@Override
	public void guardar(Producto producto) {
		repoProductos.save(producto);
	}

	@Override
	public void eliminar(Producto producto) {
		repoProductos.delete(producto);
	}

	@Override
	public void eliminar(int id) {
		repoProductos.deleteById(id);
	}

	@Override
	public void update(Producto producto) {
		Optional<Producto> p = repoProductos.findById(producto.getId());
		if(p.isPresent()) {
			Producto pFinal = p.get();
			pFinal.setNombre(producto.getNombre());
			pFinal.setDescripcion(producto.getDescripcion());
			pFinal.setImagen(producto.getImagen());
			pFinal.setPrecio(producto.getPrecio());
		}
	}

}
