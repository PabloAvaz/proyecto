package com.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.model.user.Usuario;
import com.service.IPerfilService;
import com.service.ISkinService;
import com.service.IUsuarioService;

@Controller
public class LoginController {

	@Autowired
	private IUsuarioService serviceUsuarios;

	@Autowired
	private ISkinService serviceSkin;

	@Autowired 
	IPerfilService servicePerfil;

	@Autowired
	private PasswordEncoder passwordEncoder;

	private Usuario usuario;

	@ModelAttribute
	public void init(Model modelo, HttpSession sesion) {
		usuario =  (Usuario) sesion.getAttribute("usuario");

	}

	@GetMapping("/signup")
	private String registrar(Model modelo) {
		modelo.addAttribute("user",new Usuario());
		modelo.addAttribute("action","signup");
		return usuario != null ? "redirect:/play" : "/usuarios/userForm.html";
	}
	/**
	 * Método que guarda a un usuario si todo fue bien, codifica su contraseña y ademas le asigna una skin y un perfil por defecto 
	 * @param user
	 * @param atrib
	 * @param sesion
	 * @return
	 */
	@PostMapping("/signup")
	private String registro(Usuario user, RedirectAttributes atrib, HttpSession sesion) {
		if(user.getSkin() == null)user.setSkin(serviceSkin.getById(1));
		user.agregarPerfil(servicePerfil.getPerfil(2));
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		serviceUsuarios.guardar(user);
		return "redirect:/login";
	}

	@GetMapping("/login")
	private String login() {
		return (usuario != null) ? "redirect:/play" : "/usuarios/login";
	}

	@GetMapping("/login/error")
	private String loginForm(Usuario user, Model modelo, HttpSession sesion, RedirectAttributes atrib) {
		Usuario usr = serviceUsuarios.validar(user);
		if(usr != null) {
			sesion.setAttribute("usuario", usr);
			return "redirect:/play";
		} else {
			atrib.addFlashAttribute("msg","Error al iniciar sesion: ");
			return "redirect:/login";
		}
	}
	@GetMapping("/logout")
	private String logout(HttpSession sesion) {
		sesion.invalidate();
		return "redirect:/play";
	}
}
