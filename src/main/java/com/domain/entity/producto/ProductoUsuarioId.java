package com.domain.entity.producto;


import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.domain.entity.user.Usuario;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductoUsuarioId implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idProducto", table="productoUsuario")
	protected Producto producto;
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id", table="productoUsuario")
	protected Usuario user;
}
