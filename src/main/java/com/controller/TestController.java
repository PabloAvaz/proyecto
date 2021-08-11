package com.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.domain.entity.producto.ProductoUsuario;
import com.domain.entity.producto.ProductoUsuarioId;
import com.domain.entity.user.Energia;
import com.domain.entity.user.Usuario;
import com.domain.repository.AccionEquipableRepository;
import com.domain.repository.EfectoRepository;
import com.domain.repository.EnergiaRepository;
import com.domain.repository.ProductoUsuarioRepository;
import com.dto.user.UsuarioDto;
import com.service.IProductoService;
import com.service.ISkinService;
import com.service.IUsuarioService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/test")
@SuppressWarnings("unused")
@RequiredArgsConstructor
public class TestController {
	private ISkinService serviceSkin;
	private IUsuarioService serviceUsuario;
	private IProductoService serviceProducto;
	private AccionEquipableRepository repoAcciones;
	private EfectoRepository repoEfectos;
	private ProductoUsuarioRepository repoProductoUsuario;
	private EnergiaRepository repoEnergia;
	
	private UsuarioDto usr;
	
	@GetMapping("/")
	private String test(HttpSession sesion) {
		usr = ((UsuarioDto)sesion.getAttribute("usuario"));
		System.out.println(usr);

		test();

		return "/test";
	} 
	@GetMapping("/energia")
	private String energia(HttpSession sesion) {
		usr = ((UsuarioDto)sesion.getAttribute("usuario"));
		
		test();

		return "/test";
	} 
	
	@GetMapping("/user")
	@ResponseBody
	public String verUser(HttpSession sesion) {
		return sesion.getAttribute("usuario").toString();
	}
	private void test() {
		serviceUsuario.reclamarDaily(usr);
		//serviceUsuario.reiniciarDaily();
	}
	
	private void testComprarCantidad() {
		ProductoUsuarioId puID = new ProductoUsuarioId();
		ProductoUsuario pu = new ProductoUsuario();

		//puID.setUser(serviceUsuario.getById(1));
		//puID.setProducto(serviceProducto.getById(3));
		pu.setProductoUsuarioId(puID);
		pu.setCantidad(6000);
		
		repoProductoUsuario.save(pu);
	}
	private void testEnergia() {
		//usr.getEnergia().aumentarEnergiaMaxima(200);
		usr.getEnergia().recargar(100);
		serviceUsuario.guardar(usr);
	}

}
