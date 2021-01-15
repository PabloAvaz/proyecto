package com.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.model.user.Usuario;
import com.service.IProductoService;
import com.service.IUsuarioService;

@Controller
@RequestMapping("/tienda")
public class TiendaController {
	@Autowired
	IProductoService serviceProductos;
	@Autowired
	IUsuarioService serviceUsuario;
	
	private Usuario usuario;
	
	@ModelAttribute
	public void init(HttpSession sesion) {
		usuario= (Usuario)  sesion.getAttribute("usuario");		
	}
	@GetMapping("/")
	public String tienda(Model modelo) {
		if(usuario == null) return "redirect:/login";
		
		modelo.addAttribute("usuario", usuario);
		modelo.addAttribute("productos", serviceProductos.getAll());

		return "tienda";
	}
	
	@GetMapping("/comprar/{id}")
	public String comprar(@PathVariable int id, HttpSession sesion) {
		if(usuario == null) return "redirect:/login";
		
		if(serviceUsuario.comprar(usuario, serviceProductos.getById(id))) {
			serviceUsuario.guardar(usuario);
			sesion.setAttribute("usuario", usuario);
		} else {
			
		}
		
		return "redirect:/tienda/";
	}
	
}
