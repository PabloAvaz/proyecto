package com.domain.entity.producto;


import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="productousuario")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductoUsuario {
	
	@EmbeddedId
	private ProductoUsuarioId productoUsuarioId;
	
	private int cantidad;
	
	public void aumentarCantidad(int cantidad) {
		this.cantidad += cantidad;
	}
	public void disminuirCantidad(int cantidad) {
		this.cantidad -= cantidad;
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
