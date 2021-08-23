package com.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dto.util.Alert;
import com.enums.TipoMensaje;
import com.service.IUsuarioService;

import lombok.RequiredArgsConstructor;

/**
 * Controlador para gestionar la administracion
 * @author Pablo
 *
 */

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {
	
	private final IUsuarioService serviceUsuarios;
	
	@ModelAttribute
	public void init(Model modelo, HttpSession sesion) {
		modelo.addAttribute("usuario",sesion.getAttribute("usuario"));
	}
	
	@GetMapping("/")
	public String indexController() {
		return "/admin/indexAdmin";
	}
	
	@GetMapping("/daily")
	public String admin(RedirectAttributes atrib) {
		return "admin/daily";
	}
	
	@GetMapping("/daily/restart")
	public String adminRestart(RedirectAttributes atrib) {
		serviceUsuarios.reiniciarDaily();
		atrib.addFlashAttribute("msg", new Alert("Recompensas diarias reiniciadas", TipoMensaje.SUCCESS));
		return "redirect:/admin/daily";
	}
}
