package com.dto.util;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Mensaje {
	private String campo;
	private String contenido;
}
