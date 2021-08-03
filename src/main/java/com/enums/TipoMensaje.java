package com.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TipoMensaje {
	ERROR("error"),
	SUCCESS("success"),
	INFO("info"),
	WARN("warn");
	
	private String clase;
	
}
