package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.model.acciones.AccionEquipable;
import com.model.enums.Tipo;
import com.service.IAccionEquipableService;
import com.service.IProductoService;
import com.service.ISkinService;

@Controller
@RequestMapping("/action")
public class AccionController {
	@Autowired
	private IAccionEquipableService serviceAccionEquipable;
	@Autowired
	private IProductoService serviceProducto;
	@Autowired
	private ISkinService serviceSkins;
	
	@GetMapping("/create")
	public String crear(Model modelo) {
		modelo.addAttribute("productos", serviceProducto.getByTipo(Tipo.EQUIPABLE));
		modelo.addAttribute("skins", serviceSkins.getAll());
		modelo.addAttribute("accion", new AccionEquipable());

		return "action/actionForm.html";
	}
	@PostMapping("/create")
	public String crearForm(AccionEquipable accion) {
		serviceAccionEquipable.save(accion);

		return "redirect:/action/list";
	}
	@GetMapping("/edit/{id}")
	public String edit(Model modelo, @PathVariable int id) {
		modelo.addAttribute("producto", serviceProducto.getById(id));
		modelo.addAttribute("skins", serviceSkins.getAll());
		modelo.addAttribute("accion", new AccionEquipable());

		return "action/actionUpdateForm.html";
	}
	@GetMapping("/list")
	public String list(Model modelo) {
		modelo.addAttribute("acciones", serviceAccionEquipable.getAll());
		return "action/actionList.html";
	}
}
