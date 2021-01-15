package com.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.model.user.Usuario;
import com.service.IUsuarioService;

@Controller
public class UserController {
	@Autowired
	private IUsuarioService serviceUsuarios;
	
	private Usuario usuario;
	
	@ModelAttribute
	public void init(Model modelo, HttpSession sesion) {
		usuario =  (Usuario) sesion.getAttribute("usuario");
		modelo.addAttribute("usuario", usuario);
	}
	
	@GetMapping("/list")
	private String listar(Model modelo) {
		modelo.addAttribute("usuarios", serviceUsuarios.getAll());
		return "userList.html";
	}
	

}
