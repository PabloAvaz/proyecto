package com.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.service.IUsuarioService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private IUsuarioService serviceUsuarios;
	
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
		return "redirect:/admin/daily";
	}
}
