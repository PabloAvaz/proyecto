package com.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class IndexController {
	@ModelAttribute
	public void init(Model modelo, HttpSession sesion) {
		modelo.addAttribute("usuario",sesion.getAttribute("usuario"));
	}
	
	@GetMapping("/")
	public String defaultIndex() {
		return "redirect:/rico";
	}
	
	@GetMapping("/index")
	public String index(Model modelo) {
		modelo.addAttribute("hora", new Date());
		return "index.html";
	}
	
	@GetMapping("/rico")
	public String rico() {
		return "rico.html";
	}
}
