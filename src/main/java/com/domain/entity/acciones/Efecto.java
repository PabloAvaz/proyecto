package com.domain.entity.acciones;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.enums.TipoEfecto;

import lombok.Data;

@Entity
@Data
@Table(name="efecto")
public class Efecto {
	@Id
	private int idEfecto;
	private int idProducto;

	private int duracion;
	private int poder;
	private String tipo;
	
	public void setTipo(TipoEfecto tipoEfecto) {
		this.tipo = tipoEfecto.name();
	}
	
	@Override
	public String toString() {
		return "Efecto [idEfecto=" + idEfecto + ", idProducto=" + idProducto + ", duracion=" + duracion + ", poder="
				+ poder + ", tipo=" + tipo + "]";
	}
	
	
}
