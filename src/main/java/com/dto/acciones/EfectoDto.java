package com.dto.acciones;

import com.enums.TipoEfecto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class EfectoDto {
	private int idEfecto;
	private int idProducto;
	private int duracion;
	private int poder;
	private TipoEfecto tipo;
		
	public void setTipo(String tipo) {
		this.tipo = TipoEfecto.contiene(tipo) ? TipoEfecto.valueOf(tipo): TipoEfecto.NINGUNO;
	}
}
