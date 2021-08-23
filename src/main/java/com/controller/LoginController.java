package com.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dto.user.UsuarioDto;
import com.dto.util.Alert;
import com.enums.TipoCodigo;
import com.enums.TipoMensaje;
import com.service.IRestaurarService;
import com.service.IUsuarioService;
import com.validator.user.UsuarioValidator;

import lombok.RequiredArgsConstructor;

/**
 * Controlador de la seccion de login y registro de usuarios
 * @author Pablo
 *
 */

@Controller
@RequiredArgsConstructor
public class LoginController {

	private final IUsuarioService serviceUsuarios;
	private final UsuarioValidator validatorUsuarios;
	private final IRestaurarService restaurarService;

	private UsuarioDto usuario;

	@ModelAttribute
	public void init(Model modelo, HttpSession sesion) {
		usuario =  (UsuarioDto) sesion.getAttribute("usuario");
		modelo.addAttribute("newUser", new UsuarioDto());
	}

	@GetMapping("/signup")
	private String registrar(Model modelo) {
	    modelo.addAttribute("user", new UsuarioDto());
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
	private String registro(UsuarioDto newUser, RedirectAttributes atrib, HttpSession sesion, Model modelo) {
		Map<String, String> errores = validatorUsuarios.validarUsuario(newUser);
		if(!errores.isEmpty()) {
			modelo.addAttribute("errores", errores);
		    modelo.addAttribute("user", newUser);
			modelo.addAttribute("action","signup");
			return "/usuarios/userForm.html";
		} else if (serviceUsuarios.existe(newUser)) {
			modelo.addAttribute("usuarioInvalido", new Alert("Ya existe un usuario con el mismo username o email", TipoMensaje.ERROR));
		    modelo.addAttribute("user", newUser);
			modelo.addAttribute("action","signup");
			return "/usuarios/userForm.html";
		}

			serviceUsuarios.crear(newUser);
			restaurarService.generarCodigo(newUser.getEmail(), TipoCodigo.VALIDATE_USER);
			return "redirect:/tokens/generar/confirmation/" + newUser.getEmail();
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
			atrib.addFlashAttribute("msgLogin", new Alert("Error al iniciar sesion: ", TipoMensaje.ERROR));
			return "redirect:/login";
		}
	}
	@GetMapping("/logout")
	private String logout(HttpSession sesion) {
		sesion.invalidate();
		return "redirect:/play";
	}
}
