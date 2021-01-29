package com.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.model.producto.ProductoUsuario;
import com.model.producto.ProductoUsuarioId;
import com.model.user.Energia;
import com.model.user.Usuario;
import com.repository.AccionEquipableRepository;
import com.repository.EfectoRepository;
import com.repository.EnergiaRepository;
import com.repository.ProductoUsuarioRepository;
import com.service.IProductoService;
import com.service.ISkinService;
import com.service.IUsuarioService;

@Controller
@RequestMapping("/test")
@SuppressWarnings("unused")
public class TestController {
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
	@Autowired
	private ProductoUsuarioRepository repoProductoUsuario;
	@Autowired
	private EnergiaRepository repoEnergia;
	
	@GetMapping("/")
	private String test(HttpSession sesion) {
		test();
		Usuario usr = ((Usuario)sesion.getAttribute("usuario"));
		
		//usr.getEnergia().aumentarEnergiaMaxima(200);
		usr.getEnergia().recargar(100);
		serviceUsuario.guardar(usr);

		return "/test";
	} 
	
	@GetMapping("/user")
	@ResponseBody
	public String verUser(HttpSession sesion) {
		return sesion.getAttribute("usuario").toString();
	}
	private void test() {
	}
	
	private void testComprarCantidad() {
		ProductoUsuarioId puID = new ProductoUsuarioId();
		ProductoUsuario pu = new ProductoUsuario();

		puID.setUser(serviceUsuario.getById(1));
		puID.setProducto(serviceProducto.getById(3));
		pu.setProductoUsuario(puID);
		pu.setCantidad(6000);
		
		repoProductoUsuario.save(pu);
	}


}
