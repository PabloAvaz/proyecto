package com.controller;


import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dto.user.UsuarioDto;
import com.dto.util.Alert;
import com.enums.TipoMensaje;
import com.service.IProductoService;
import com.service.IUsuarioService;

import lombok.RequiredArgsConstructor;

/**
 * Controlador para gestionar el perfil de los usuarios
 * @author Pablo
 *
 */

@Controller
@RequestMapping("/perfil")
@RequiredArgsConstructor
public class PerfilController {
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
		modelo.addAttribute("productos", serviceUsuario.getProductos(usr));
		return "/perfil/productoList";
	}
	
	@GetMapping("/usar/{id}")
	public String usar(@PathVariable int id, Integer cantidad, HttpSession sesion, RedirectAttributes atrib) {
		if(!logeado) return "redirect:/login";
		
		if(serviceUsuario.usar(usr, serviceProducto.getById(id), cantidad)) {
			sesion.setAttribute("usuario", serviceUsuario.getById(usr.getId()));
			atrib.addFlashAttribute("msgUsar", new Alert("Producto utilizado con éxito", TipoMensaje.SUCCESS));
		} else {
			atrib.addFlashAttribute("msgUsar", new Alert("Error al utilizar el producto", TipoMensaje.ERROR));
		}

		return "redirect:/perfil/list";
	}
}
