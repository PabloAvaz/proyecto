package com.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.model.user.Usuario;
import com.service.IUsuarioService;



@Controller
public class IndexController {
	@Autowired
	private IUsuarioService serviceUsuario;
	
	@ModelAttribute
	public void init(Model modelo, HttpSession sesion) {
		modelo.addAttribute("usuario",sesion.getAttribute("usuario"));
	}
	
	@GetMapping("/")
	public String defaultIndex() {
		return "redirect:/play";
	}
	
	@GetMapping("/index")
	public String index() {
		return "redirect:/play";
	}
	
	@GetMapping("/play")
	public String play(Authentication auth, HttpSession sesion) {
		if(sesion.getAttribute("usuario")==null && auth != null) {
			Usuario usr = serviceUsuario.getByUserName(auth.getName());
			sesion.setAttribute("usuario", usr);
		}
		return "index.html";
	}

}
