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
import com.service.ISkinService;
import com.service.IUsuarioService;

@Controller
public class LoginController {
	
	@Autowired
	private IUsuarioService serviceUsuarios;
	
	@Autowired
	private ISkinService serviceSkin;
	
	private boolean logeado;
	
	@ModelAttribute
	public void init(Model modelo, HttpSession sesion) {
		logeado =  sesion.getAttribute("usuario") != null;

	}
	
	
	@GetMapping("/signup")
	private String registrar(Model modelo) {
		modelo.addAttribute("user",new Usuario());
		modelo.addAttribute("action","signup");
		return logeado ? "redirect:/play" : "/usuarios/userForm.html";
	}
	
	@PostMapping("/signup")
	private String registro(Usuario user, RedirectAttributes atrib, HttpSession sesion) {
		if(user.getSkin() == null)user.setSkin(serviceSkin.getById(1));
		System.out.println(user);
		serviceUsuarios.guardar(user);
		sesion.setAttribute("usuario",serviceUsuarios.getByUserName(user.getUsername()));
		return "redirect:/play";
	}
	
	@GetMapping("/login")
	private String login() {
		return logeado ? "redirect:/play" : "/usuarios/login.html";
	}
	
	@PostMapping("/login")
	private String loginForm(Usuario user, Model modelo, HttpSession sesion, RedirectAttributes atrib) {
		Usuario usr = serviceUsuarios.validar(user);
		if(usr != null) {
			sesion.setAttribute("usuario", usr);
			return "redirect:/play";
		} else {
			atrib.addFlashAttribute("msg","Error al iniciar sesion");
			return "redirect:/login";
		}
	}
	@GetMapping("/logout")
	private String logout(HttpSession sesion) {
		sesion.invalidate();
		return "redirect:/play";
	}
}
