package com.test;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
public class ProductoUsuarioId implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    @Column(name = "id",table = "productousuario")
	private Integer idUser;
    @Column(name = "idProducto",table = "productousuario")
	private Integer idProducto;
	public ProductoUsuarioId() {}
	public ProductoUsuarioId(Integer idUser, Integer idProducto) {
		super();
		this.idUser = idUser;
		this.idProducto = idProducto;
	}
	public Integer getIdUser() {
		return idUser;
	}
	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}
	public Integer getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idProducto == null) ? 0 : idProducto.hashCode());
		result = prime * result + ((idUser == null) ? 0 : idUser.hashCode());
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
		ProductoUsuarioId other = (ProductoUsuarioId) obj;
		if (idProducto == null) {
			if (other.idProducto != null)
				return false;
		} else if (!idProducto.equals(other.idProducto))
			return false;
		if (idUser == null) {
			if (other.idUser != null)
				return false;
		} else if (!idUser.equals(other.idUser))
			return false;
		return true;
	}
	
	
	

	
	
	
}
