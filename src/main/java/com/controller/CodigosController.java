package com.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dto.user.UsuarioDto;
import com.dto.util.Alert;
import com.dto.util.Codigo;
import com.enums.TipoCodigo;
import com.enums.TipoMensaje;
import com.service.IRestaurarService;
import com.service.IUsuarioService;

import lombok.RequiredArgsConstructor;


@Controller
@RequiredArgsConstructor
@RequestMapping("/tokens")
public class CodigosController {
	
	private final IRestaurarService restaurarService;
	private final IUsuarioService usuarioService;
	private final PasswordEncoder passwordEncoder;

	/**
	 * Endpoint para generar un correo con el que cambiar la contraseña
	 * @param request
	 * @param email
	 */
	@GetMapping("/generar/newPass")
	private String generarPass(HttpServletRequest request, String email, RedirectAttributes atrib) {
		Codigo codigo = restaurarService.generarCodigo(email, TipoCodigo.NEW_PASS);
		
		if(codigo != null && restaurarService.mailNewPass(restaurarService.validarCodigo(codigo), request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/tokens/newPass/" + codigo.getValor())) {
			atrib.addFlashAttribute("msgLogin", new Alert("Se ha enviado un correo a la dirección indicada para restaurar la contraseña", TipoMensaje.SUCCESS));
		} else {
			atrib.addFlashAttribute("msgLogin", new Alert("No se pudo enviar el mensaje al correo del usuario", TipoMensaje.ERROR));
		}
		
		return "redirect:/login";
	}
	
	/**
	 * Endpoint para generar un correo con el que confirmar el usuario
	 * @param request
	 * @param email
	 */
	@GetMapping("/generar/confirmation/{email}")
	private String generarUser(HttpServletRequest request, @PathVariable String email, RedirectAttributes atrib) {

		Codigo codigo = restaurarService.generarCodigo(email, TipoCodigo.VALIDATE_USER);
		
		if(codigo != null && restaurarService.mailNewUser(restaurarService.validarCodigo(codigo), request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/tokens/confirmation/" + codigo.getValor())) {
			atrib.addFlashAttribute("msg", new Alert("Se ha enviado un correo al email introducido para activar el usuario", TipoMensaje.SUCCESS));
		} else {
			atrib.addFlashAttribute("msg", new Alert("No se pudo enviar el codigo de confirmación al email introducido", TipoMensaje.ERROR));
		}
		
		return "redirect:/signup";
	}
	
	/**
	 * Endpoint para confirmar el usuario
	 * @param request
	 * @param email
	 */
	@GetMapping("/confirmation/{codigo}")
	private String validarUsuario(@PathVariable String codigo, Model modelo) {
		UsuarioDto user = restaurarService.validarCodigo(new Codigo(codigo,TipoCodigo.VALIDATE_USER));
		
		if(user != null ) {
			user.setEstatus(true);
			usuarioService.modificar(user);
			return "redirect:/login";
		}
		
		return "redirect:/";
		
	}
	
	/**
	 * Endpoint con el formulario para cambiar la contraseña
	 * @param request
	 * @param email
	 */
	@GetMapping("/newPass/{codigo}")
	private String obtener(@PathVariable String codigo, Model modelo) {
		modelo.addAttribute("codigo", codigo);
		modelo.addAttribute("valido", restaurarService.validarCodigo(new Codigo(codigo,TipoCodigo.NEW_PASS)) != null);
		return "/tokens/passForm";
	}
	
	/**
	 * Endpoint para cambiar la contraseña
	 * @param request
	 * @param email
	 */
	@PostMapping("/newPass/{codigo}")
	private String actualizar(String newPass, @PathVariable String codigo) {
		UsuarioDto usr = restaurarService.validarCodigo(new Codigo(codigo,TipoCodigo.NEW_PASS));
		if(usr != null) {
			usr.setPassword(passwordEncoder.encode(newPass));
			usuarioService.modificar(usr);
			return "redirect:/";
		} else {
			return "/tokens/passForm";
		}
	}
	
	@GetMapping("/newPass")
	private String newPassForm() {
		return "/tokens/newPass";
	}
	
}
