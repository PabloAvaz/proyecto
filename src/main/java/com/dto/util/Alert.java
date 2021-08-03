package com.dto.util;

import com.enums.TipoMensaje;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Alert {
	private String contenido;
	private TipoMensaje tipo;
}
