package com.validator.user;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.dto.user.UserDto;

/**
 * Clase para realizar las validaciones de usuarios
 * @author Pablo
 *
 */

@Component
public class UsuarioValidator {
	
	/**
	 * Metodo que devuelve un mapa con los errores de validacion que contenga el usuario pasado como parametro
	 * @param producto
	 * @return
	 */
	public Map<String, String> validarUsuario(UserDto usuario) {
		
		Map<String, String> mensajes = new HashMap<>();
		
		if(usuario.getNombre() == null || usuario.getNombre().equals("")) {
			mensajes.put("nombre.obl", "Campo Apodo obligatorio");
		}
		
		if(usuario.getEmail() == null || usuario.getEmail().equals("")) {
			mensajes.put("email.obl", "Campo Email obligatorio");
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
