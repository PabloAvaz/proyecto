package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.domain.entity.acciones.AccionEquipable;
import com.dto.acciones.EfectoDto;
import com.enums.Tipo;
import com.service.IAccionEquipableService;
import com.service.IEfectoService;
import com.service.IProductoService;
import com.service.ISkinService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/efecto")
@RequiredArgsConstructor
public class EfectoController {
	private final IEfectoService serviceEfecto;
	private final IProductoService serviceProducto;
	private final ISkinService serviceSkins;
	
	@GetMapping("/add/{idProducto}")
	public String crear(Model modelo, @PathVariable int idProducto) {
		EfectoDto efecto = new EfectoDto();
		efecto.setIdProducto(idProducto);
		modelo.addAttribute("efecto", efecto);

		return "efecto/efectoForm";
	}
	@PostMapping("/add")
	public String crearForm(EfectoDto efecto) {
		serviceEfecto.update(efecto);
		return "redirect:/efecto/edit/" + efecto.getIdProducto();
	}
	@GetMapping("/edit/{idProducto}")
	public String editProducto(Model modelo, @PathVariable int idProducto) {
		modelo.addAttribute("producto", serviceProducto.getById(idProducto));

		return "efecto/edit.html";
	}
	@GetMapping("/edit/{idProducto}/{idEfecto}")
	public String editEfecto(Model modelo, @PathVariable int idEfecto) {
		modelo.addAttribute("efecto", serviceEfecto.getById(idEfecto));
		return "efecto/efectoForm";
	}
	@GetMapping("/delete/{idProducto}/{idEfecto}")
	public String deleteEfecto(Model modelo, @PathVariable int idProducto, @PathVariable int idEfecto) {
		serviceEfecto.deleteById(idEfecto);

		return "redirect:/efecto/edit/" + idProducto;
	}
}
