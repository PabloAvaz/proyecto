package com.controller;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.domain.entity.user.Usuario;
import com.dto.user.UsuarioDto;
import com.service.IUsuarioService;

@RestController
public class TextoController {
	@Autowired
	private IUsuarioService serviceUsuarios;
	
	@RequestMapping(value="/enviar",produces="application/json")
	public @ResponseBody HashMap<String,Object> sumar(HttpSession sesion) {
		UsuarioDto usr = (UsuarioDto) sesion.getAttribute("usuario");
		HashMap<String, Object> datos = new HashMap<String,Object>();

		serviceUsuarios.punto(usr);
		datos.put("user", usr.getNombre());
		datos.put("puntos", usr.getPuntos());

		return datos;
	}
	
	@RequestMapping("/view/{id}")
	private UsuarioDto verUsuario(@PathVariable int id) {
		return serviceUsuarios.getById(id);
	}
}
