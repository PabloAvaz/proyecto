package com.dto.util;

import com.enums.TipoMensaje;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Mensaje para gestionar los errores de validacion y mensajes varios
 * @author Pablo
 *
 */

@Data
@AllArgsConstructor
public class Alert {
	private String contenido;
	private TipoMensaje tipo;
}
