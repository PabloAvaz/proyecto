package com.dto.producto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductoUsuarioDto {
	
	private ProductoUsuarioIdDto productoUsuarioId;
	
	private int cantidad;
	
	public void aumentarCantidad(int cantidad) {
		this.cantidad += cantidad;
	}
	public void disminuirCantidad(int cantidad) {
		this.cantidad -= cantidad;
	}


}
