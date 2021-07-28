package com.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.domain.entity.producto.Producto;
import com.domain.entity.user.Usuario;
import com.domain.repository.ProductoRepository;
import com.dto.producto.ProductoDto;
import com.dto.user.UsuarioDto;
import com.enums.Tipo;
import com.mapper.producto.ProductoMapper;
import com.service.IProductoService;

import lombok.RequiredArgsConstructor;

@Service
@Primary
@RequiredArgsConstructor
public class ProductoServicempl implements IProductoService {
	private final ProductoRepository repoProductos;
	private final ProductoMapper productoMapper;

	@Override
	public List<ProductoDto> getAll() {
		return productoMapper.toDtoList(repoProductos.findAll());
	}
	
	@Override
	public List<ProductoDto> getByTipo(Tipo tipo) {
		return productoMapper.toDtoList(repoProductos.findByTipo(tipo));
	}
	@Override
	public ProductoDto getById(int id) {
		Optional<Producto> p = repoProductos.findById(id);
		return p.isPresent() ? productoMapper.toDto(p.get()) : null;
	}

	@Override
	public void guardar(ProductoDto producto) {
		repoProductos.save(productoMapper.toEntity(producto));
	}

	@Override
	public void eliminar(ProductoDto producto) {
		repoProductos.delete(productoMapper.toEntity(producto));
	}

	@Override
	public void eliminar(int id) {
		repoProductos.deleteById(id);
	}

	@Override
	public void update(ProductoDto producto) {
		Optional<Producto> p = repoProductos.findById(producto.getId());
		
		if(p.isPresent()) {
			Producto pFinal = p.get();
			productoMapper.merge(producto, pFinal);
			repoProductos.save(pFinal);
		}
	}
	@Override
	public List<ProductoDto> getListaCompraByUser(UsuarioDto user) {
		return productoMapper.toDtoList(repoProductos.getListaCompra(user.getId()));
	}

}
