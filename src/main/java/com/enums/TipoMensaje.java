package com.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Enumerado con los tipos de mensaje usados en alerts y validacion
 * @author Pablo
 *
 */

@AllArgsConstructor
@Getter
public enum TipoMensaje {
	ERROR("error"),
	SUCCESS("success"),
	INFO("info"),
	WARN("warn");
	
	private String clase;
	
}
