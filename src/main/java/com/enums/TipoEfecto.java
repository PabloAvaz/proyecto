package com.enums;

import lombok.Getter;

/**
 * Enumerado con los tipos de efectos
 * @author Pablo
 *
 */

@Getter
public enum TipoEfecto {
	NINGUNO,
	RECARGAR,
	GASTAR,
	CURAR,
	VELOCIDAD,
	MULTIPLICADOR;

	public static boolean contiene(String tipo) {

	    for (TipoEfecto c : TipoEfecto.values()) {
	        if (c.name().equals(tipo)) {
	            return true;
	        }
	    }

	    return false;
	}
}
