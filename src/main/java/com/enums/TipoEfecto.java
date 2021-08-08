package com.enums;

import lombok.Getter;

@Getter
public enum TipoEfecto {
	NINGUNO,
	RECARGAR,
	GASTAR,
	CURAR,
	VELOCIDAD;

	public static boolean contiene(String tipo) {

	    for (TipoEfecto c : TipoEfecto.values()) {
	        if (c.name().equals(tipo)) {
	            return true;
	        }
	    }

	    return false;
	}
}
