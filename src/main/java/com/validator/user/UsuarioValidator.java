package com.validator.user;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.dto.user.UserDto;


@Component
public class UsuarioValidator {
	
	public Map<String, String> validarUsuario(UserDto usuario) {
		
		Map<String, String> mensajes = new HashMap<>();
		
		if(usuario.getNombre() == null || usuario.getNombre().equals("")) {
			mensajes.put("nombre.obl", "Campo Apodo obligatorio");
		}
		
		if(usuario.getUsername() == null || usuario.getUsername().equals("")) {
			mensajes.put("usr.obl", "Campo Username obligatorio");
		}
		
		if(usuario.getPassword() == null || usuario.getPassword().equals("")) {
			mensajes.put("pass.obl", "Campo Contraseña obligatorio");
		}
		
		
		return mensajes;
	}
}
