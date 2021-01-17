package com.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;


import com.model.acciones.Efecto;
import com.model.enums.TipoEfecto;
import com.model.user.Usuario;
import com.repository.AccionEquipableRepository;
import com.repository.EfectoRepository;
import com.service.IProductoService;
import com.service.ISkinService;
import com.service.IUsuarioService;


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
	

	@Autowired
	private ISkinService serviceSkin;
	@Autowired
	private IUsuarioService serviceUsuario;
	@Autowired
	private IProductoService serviceProducto;
	
	@Autowired
	private AccionEquipableRepository repoAcciones;
	@Autowired
	private EfectoRepository repoEfectos;
	@GetMapping("/test")
	@ResponseBody
	private String test(HttpSession sesion) {
		Usuario usr = (Usuario)sesion.getAttribute("usuario");
		
		Efecto e = new Efecto();
		e.setId(1);
		e.setDuracion(6000);
		e.setPoder(5);
		e.setTipo(TipoEfecto.VELOCIDAD);
		System.out.println(usr);
		//repoEfectos.save(e);
		return "fin";
	} 
}
