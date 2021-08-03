package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.domain.entity.acciones.AccionEquipable;
import com.enums.Tipo;
import com.service.IAccionEquipableService;
import com.service.IProductoService;
import com.service.ISkinService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/action")
@RequiredArgsConstructor
public class AccionController {
	private final IAccionEquipableService serviceAccionEquipable;
	private final IProductoService serviceProducto;
	private final ISkinService serviceSkins;
	
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
