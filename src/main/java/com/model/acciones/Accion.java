package com.model.acciones;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Accion {
	@Id
	@Column(name = "idProducto")
	protected int id;	
	
	public Accion() {}
	
	public Accion(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

}
