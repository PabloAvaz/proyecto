package com.dto.producto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class SkinDto {
	private Integer id;
	private String nombre;
	private String imagen;
	private String sonido;


}
