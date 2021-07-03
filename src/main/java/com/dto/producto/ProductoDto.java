package com.dto.producto;

import com.constants.Tipo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductoDto {

	private int id;
	private String nombre;
	private String descripcion;
	private String imagen = "default.png";
	private int precio;
	private Tipo tipo;

}
