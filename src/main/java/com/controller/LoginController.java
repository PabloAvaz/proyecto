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
public class LoginController {
	
	@Autowired
	private IUsuarioService serviceUsuarios;
	
	private boolean logeado;
	
	@ModelAttribute
	public void init(Model modelo, HttpSession sesion) {
		logeado =  sesion.getAttribute("usuario") != null;

	}
	
	
	@GetMapping("/signup")
	private String registrar() {
		return logeado ? "redirect:/rico" : "userForm.html";
	}
	
	@PostMapping("/signup")
	private String registro(Usuario user, RedirectAttributes atrib, HttpSession sesion) {
		serviceUsuarios.guardar(user);
		sesion.setAttribute("usuario",serviceUsuarios.getByUserName(user.getUsername()));
		return "redirect:/rico";
	}
	
	@GetMapping("/login")
	private String login() {
		return logeado ? "redirect:/rico" : "login.html";
	}
	
	@PostMapping("/login")
	private String loginForm(Usuario user, Model modelo, HttpSession sesion, RedirectAttributes atrib) {
		Usuario usr = serviceUsuarios.validar(user);
		if(usr != null) {
			sesion.setAttribute("usuario", usr);
			modelo.addAttribute("usuario",usr);
			return "rico.html";
		} else {
			atrib.addFlashAttribute("msg","Error al iniciar sesion");
			return "redirect:/login";
		}
	}
	@GetMapping("/logout")
	private String logout(HttpSession sesion) {
		sesion.invalidate();
		return "redirect:/rico";
	}
}
