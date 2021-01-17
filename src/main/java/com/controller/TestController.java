package com.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.model.producto.ProductoUsuario;
import com.model.producto.ProductoUsuarioId;
import com.repository.AccionEquipableRepository;
import com.repository.EfectoRepository;
import com.repository.ProductoUsuarioRepository;
import com.service.IProductoService;
import com.service.ISkinService;
import com.service.IUsuarioService;

@Controller
@RequestMapping("/test")
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
	
	@GetMapping("/")
	@ResponseBody
	private String test(HttpSession sesion) {
		ProductoUsuarioId puID = new ProductoUsuarioId();
		ProductoUsuario pu = new ProductoUsuario();

		puID.setUser(serviceUsuario.getById(1));
		puID.setProducto(serviceProducto.getById(3));
		pu.setProductoUsuario(puID);
		pu.setCantidad(6000);
		
		repoProductoUsuario.save(pu);
		System.out.println(pu);
		return "fin";
	} 
}
