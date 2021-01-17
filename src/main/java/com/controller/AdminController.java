package com.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@ModelAttribute
	public void init(Model modelo, HttpSession sesion) {
		modelo.addAttribute("usuario",sesion.getAttribute("usuario"));
	}
	
	@GetMapping("/")
	public String indexController() {
		return "/admin/indexAdmin";
	}
}
