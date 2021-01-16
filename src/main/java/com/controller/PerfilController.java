package com.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.model.user.Usuario;
import com.service.IProductoService;
import com.service.IUsuarioService;

@Controller
@RequestMapping("/perfil")
public class PerfilController {
	@Autowired
	private IUsuarioService serviceUsuario;
	@Autowired
	private IProductoService serviceProducto;
	
	private boolean logeado;
	
	@ModelAttribute
	public void init(Model modelo, HttpSession sesion) {
		Usuario usr = (Usuario) sesion.getAttribute("usuario");
		System.out.println(usr);
		if(usr != null) {
			logeado = true;
			modelo.addAttribute("usuario",usr);
			modelo.addAttribute("productos",usr.getArticulos());
		} else {
			logeado = false;
		}
	}
	
	@GetMapping("/list")
	public String productos() {
		if(!logeado) return "redirect:/login";
		return "/perfil/productoList";
	}
}
