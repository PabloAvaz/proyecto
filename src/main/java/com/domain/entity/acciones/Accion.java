package com.domain.entity.acciones;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;

import com.domain.entity.producto.Producto;

import lombok.Data;
import lombok.NoArgsConstructor;


@MappedSuperclass
@Data
@NoArgsConstructor
public abstract class Accion {
	@Id
	@Column(name = "idProducto")
	protected int id;	
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idProducto")
	private Producto producto;
	
	public Accion(int id) {
		this.id = id;
	}
	
}
