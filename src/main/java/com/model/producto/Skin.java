package com.model.producto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="skin")
public class Skin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idSkin")
	private Integer id;
	private String imagen;
	private String sonido;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public String getSonido() {
		return sonido;
	}
	public void setSonido(String sonido) {
		this.sonido = sonido;
	}

}
