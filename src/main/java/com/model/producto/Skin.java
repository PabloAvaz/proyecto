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
	private String nombre;

	public Skin() {
		this(1,"DEFAULT","default.png","default.wav");
	}

	public Skin(Integer id,String nombre, String imagen, String sonido) {
		super();
		this.id = id;
		this.imagen = imagen;
		this.sonido = sonido;
	}

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
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Skin other = (Skin) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Skin [id=" + id + ", imagen=" + imagen + ", sonido=" + sonido + ", nombre=" + nombre + "]";
	}
}
