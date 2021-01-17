package com.controller;


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
		return "redirect:/play";
	}
	
	@GetMapping("/index")
	public String index() {
		return "redirect:/play";
	}
	
	@GetMapping("/play")
	public String rico() {
		return "index.html";
	}
}
