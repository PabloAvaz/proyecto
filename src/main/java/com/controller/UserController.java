package com.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.domain.entity.user.Usuario;
import com.dto.user.UsuarioDto;
import com.service.ISkinService;
import com.service.IUsuarioService;

@Controller
@RequestMapping("/usuarios")
public class UserController {
	@Autowired
	private IUsuarioService serviceUsuarios;
	@Autowired
	private ISkinService serviceSkins;
	
	private UsuarioDto usuario;
	
	@ModelAttribute
	public void init(Model modelo, HttpSession sesion) {
		usuario = (UsuarioDto) sesion.getAttribute("usuario");
		modelo.addAttribute("usuario", usuario);
	}
	
	@GetMapping("/list")
	private String listar(Model modelo) {
		modelo.addAttribute("usuarios", serviceUsuarios.getAll());
		return "/usuarios/userList.html";
	}
	
	@GetMapping("/adminList")
	private String listarAdmin(Model modelo) {
		modelo.addAttribute("usuarios", serviceUsuarios.getAll());
		return "/usuarios/userListAdmin.html";
	}
	
	@GetMapping("/delete/{id}")
	private String delete(@PathVariable int id) {
		serviceUsuarios.borrar(serviceUsuarios.getById(id));
		return "redirect:/usuarios/adminList";
	}
	
	@GetMapping("/edit/{id}")
	private String edit(@PathVariable int id, Model modelo) {
		modelo.addAttribute("user", serviceUsuarios.getById(id));
		modelo.addAttribute("skins", serviceSkins.getAll());
		modelo.addAttribute("action", "usuarios/edit");
		return "/usuarios/userForm.html";
	}
	
	@PostMapping("/edit")
	private String edit(@ModelAttribute("user") UsuarioDto user) {
		serviceUsuarios.modificar(user);
		return "redirect:/usuarios/adminList";
	}
}
