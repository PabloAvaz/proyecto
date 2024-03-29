package com.dto.acciones;

import com.domain.entity.producto.Producto;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Dto de las acciones
 * @author Pablo
 *
 */

@Data
@NoArgsConstructor
public abstract class AccionDto {
	protected int id;	
	private Producto producto;
	
	public AccionDto(int id) {
		this.id = id;
	}


}
