package com.validator.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.dto.user.UserDto;
import com.dto.util.Mensaje;

@Component
public class UsuarioValidator {
	
	public List<Mensaje> validarUsuario(UserDto usuario) {
		
		List<Mensaje> mensajes = new ArrayList<Mensaje>();
		
		if(usuario.getNombre() == null || usuario.getNombre().equals("")) {
			mensajes.add(new Mensaje("e", "e"));
		}
		return null;
	}
}
