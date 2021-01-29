package com.model.producto;


import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.model.user.Usuario;



@Embeddable
public class ProductoUsuarioId implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idProducto", table="productousuario")
	protected Producto producto;
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id", table="productousuario")
	protected Usuario user;
	
	public ProductoUsuarioId() {
	}
	
	public ProductoUsuarioId(Producto producto, Usuario user) {
		this.producto = producto;
		this.user = user;
	}


	public Usuario getUser() {
		return user;
	}
	public void setUser(Usuario user) {
		this.user = user;
	}
	
	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	@Override
	public String toString() {
		return "ProductoUsuarioId [producto=" + producto + ", user=" + user + "]";
	}

}
