package com.model.producto;


import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="productousuario")
public class ProductoUsuario {
	
	@EmbeddedId
	private ProductoUsuarioId productoUsuarioId;
		
	private int cantidad;


	public ProductoUsuario() {
		super();
	}
	public ProductoUsuario(ProductoUsuarioId productoUsuarioId, int cantidad) {
		super();
		this.productoUsuarioId = productoUsuarioId;
		this.cantidad = cantidad;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	public void aumentarCantidad(int cantidad) {
		this.cantidad += cantidad;
	}
	public void disminuirCantidad(int cantidad) {
		this.cantidad -= cantidad;
	}

	public ProductoUsuarioId getProductoUsuario() {
		return productoUsuarioId;
	}

	public void setProductoUsuario(ProductoUsuarioId productoUsuario) {
		this.productoUsuarioId = productoUsuario;
	}

	public ProductoUsuarioId getProductoUsuarioId() {
		return productoUsuarioId;
	}

	public void setProductoUsuarioId(ProductoUsuarioId productoUsuarioId) {
		this.productoUsuarioId = productoUsuarioId;
	}

	@Override
	public String toString() {
		return "ProductoUsuario [productoUsuarioId=" + productoUsuarioId + ", cantidad=" + cantidad + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((productoUsuarioId == null) ? 0 : productoUsuarioId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductoUsuario other = (ProductoUsuario) obj;
		if (productoUsuarioId == null) {
			if (other.productoUsuarioId != null)
				return false;
		} else if (!productoUsuarioId.equals(other.productoUsuarioId))
			return false;
		return true;
	}
	
}
