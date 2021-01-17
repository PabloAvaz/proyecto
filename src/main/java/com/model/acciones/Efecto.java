package com.model.acciones;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.model.enums.TipoEfecto;

@Entity
public class Efecto {
	@Id
	@Column(name="idEfecto")
	private int id;
	private int duracion;
	private int poder;
	private TipoEfecto tipo;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getDuracion() {
		return duracion;
	}
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
	public int getPoder() {
		return poder;
	}
	public void setPoder(int poder) {
		this.poder = poder;
	}
	public TipoEfecto getTipo() {
		return tipo;
	}
	public void setTipo(TipoEfecto tipo) {
		this.tipo = tipo;
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
		Efecto other = (Efecto) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
