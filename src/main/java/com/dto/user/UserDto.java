package com.dto.user;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class UserDto {
	

	protected Integer id;
	protected String nombre;
	protected boolean estatus;

	protected String username;
	protected String password;
	
	public UserDto(Integer id, String nombre, String username, String password, boolean estatus) {
		this.id = id;
		this.nombre = nombre;
		this.estatus = estatus;
		this.username = username;
		this.password = password;
	}
	
}
