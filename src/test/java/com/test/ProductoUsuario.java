package com.test;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.model.producto.Producto;

@Entity
@Table(name="productousuario")
public class ProductoUsuario {
	
	@EmbeddedId
	private ProductoUsuarioId id;
	
	@OneToOne(fetch = FetchType.LAZY)
	@MapsId("idUser")
	private Usuario usuario;
	@OneToOne(fetch = FetchType.LAZY)
	@MapsId("idProducto")
	private Producto producto;

	private Integer cantidad;

	public ProductoUsuarioId getId() {
		return id;
	}

	public void setId(ProductoUsuarioId id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	



	
}
