package com.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.domain.entity.user.Usuario;
import com.dto.producto.SkinDto;
import com.dto.user.UsuarioDto;
import com.service.ISkinService;
import com.service.IUsuarioService;

@Controller
public class LoginController {

	@Autowired
	private IUsuarioService serviceUsuarios;

	@Autowired
	private ISkinService serviceSkin;



	private UsuarioDto usuario;

	@ModelAttribute
	public void init(Model modelo, HttpSession sesion) {
		usuario =  (UsuarioDto) sesion.getAttribute("usuario");
	}

	@GetMapping("/signup")
	private String registrar(Model modelo) {
		modelo.addAttribute("user",new UsuarioDto());
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
	private String registro(UsuarioDto user, RedirectAttributes atrib, HttpSession sesion) {
		serviceUsuarios.crear(user);
		return "redirect:/login";
	}

	@GetMapping("/login")
	private String login() {
		return (usuario != null) ? "redirect:/play" : "/usuarios/login";
	}

	@GetMapping("/login/error")
	private String loginForm(UsuarioDto user, Model modelo, HttpSession sesion, RedirectAttributes atrib) {
		UsuarioDto usr = serviceUsuarios.validar(user);
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
