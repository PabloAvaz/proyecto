package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.service.IAccionEquipableService;

@Controller
@RequestMapping("/action")
public class AccionController {
	@Autowired
	private IAccionEquipableService serviceAccionEquipable;
	
	@GetMapping("/create")
	public String crear() {
		return "";
	}
	@GetMapping("/list")
	public String list(Model modelo) {
		modelo.addAttribute("acciones", serviceAccionEquipable.getAll());
		return "action/actionList.html";
	}
}
