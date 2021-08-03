package com.controller;


import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dto.user.UsuarioDto;
import com.service.IProductoService;
import com.service.IUsuarioService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/perfil")
@RequiredArgsConstructor
public class PerfilController extends BaseController {
	private final IUsuarioService serviceUsuario;
	private final IProductoService serviceProducto;
	
	private boolean logeado;
	private UsuarioDto usr;

	@ModelAttribute
	public void init(Model modelo, HttpSession sesion) {
		usr = (UsuarioDto) sesion.getAttribute("usuario");
		logeado = (usr != null);
		modelo.addAttribute("usuario",usr);

	}
	
	@GetMapping("/list")
	public String productos(Model modelo) {
		if(!logeado) return "redirect:/login";
		modelo.addAttribute("productos",serviceUsuario.getProductos(usr));
		return "/perfil/productoList";
	}
	
	@GetMapping("/usar/{id}")
	public String usar(@PathVariable int id, HttpSession sesion) {
		if(!logeado) return "redirect:/login";
		
		if(serviceUsuario.usar(usr, serviceProducto.getById(id))) {
			sesion.setAttribute("usuario", serviceUsuario.getById(usr.getId()));
		}

		return "redirect:/perfil/list";
	}
}
