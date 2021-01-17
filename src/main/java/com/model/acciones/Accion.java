package com.model.acciones;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;

import com.model.producto.Producto;

@MappedSuperclass
public abstract class Accion {
	@Id
	@Column(name = "idProducto")
	protected int id;	
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idProducto")
	private Producto producto;
	
	public Accion() {
	}
	
	public Accion(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		Accion other = (Accion) obj;
		if (id != other.id)
			return false;
		return true;
	}
	

}
