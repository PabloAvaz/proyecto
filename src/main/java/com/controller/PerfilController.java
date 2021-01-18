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
@RequestMapping("/perfil")
public class PerfilController {
	@Autowired
	private IUsuarioService serviceUsuario;
	@Autowired
	private IProductoService serviceProducto;

	
	private boolean logeado;
	private Usuario usr;

	@ModelAttribute
	public void init(Model modelo, HttpSession sesion) {
		usr = (Usuario) sesion.getAttribute("usuario");
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
			serviceUsuario.modificar(usr);
			sesion.setAttribute("usuario", usr);
		}

		return "redirect:/perfil/list";
	}
}
