package com.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.domain.entity.user.Usuario;
import com.dto.user.UsuarioDto;
import com.service.IProductoService;
import com.service.IUsuarioService;

@Controller
@RequestMapping("/tienda")
public class TiendaController {
	@Autowired
	IProductoService serviceProductos;
	@Autowired
	IUsuarioService serviceUsuario;
	
	private UsuarioDto usuario;
	
	@ModelAttribute
	public void init(HttpSession sesion) {
		usuario = (UsuarioDto) sesion.getAttribute("usuario");		
	}
	
	@GetMapping("/")
	public String tienda(Model modelo) {
		modelo.addAttribute("usuario", usuario);
		modelo.addAttribute("productos", serviceProductos.getListaCompraByUser(usuario));

		return "tienda";
	}
	
	@GetMapping("/comprar/{id}")
	public String comprar(@PathVariable int id, HttpSession sesion) {
		if(serviceUsuario.comprar(usuario, serviceProductos.getById(id))) {
			sesion.setAttribute("usuario", serviceUsuario.getById(usuario.getId()));
		} 

		return "redirect:/tienda/";
	}
	
}
