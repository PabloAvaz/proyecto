package com.dto.acciones;

import com.enums.TipoEfecto;

import lombok.Data;

@Data
public class EfectoDto {
	private int id;
	private int duracion;
	private int poder;
	private TipoEfecto tipo;

}
