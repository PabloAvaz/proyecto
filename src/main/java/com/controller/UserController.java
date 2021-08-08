package com.controller;


import javax.servlet.http.HttpSession;

import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dto.user.UsuarioDto;
import com.service.ISkinService;
import com.service.IUsuarioService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UserController extends BaseController {
	private final IUsuarioService serviceUsuarios;
	private final ISkinService serviceSkins;
	private final PasswordEncoder passwordEncoder;

	private UsuarioDto usuario;
	
	@ModelAttribute
	public void init(Model modelo, HttpSession sesion) {
		usuario = (UsuarioDto) sesion.getAttribute("usuario");
		modelo.addAttribute("usuario", usuario);
		modelo.addAttribute("newUser", new UsuarioDto());
	}
	
	
	@GetMapping("/list")
	private String listar(Model modelo, Pageable page) {
		modelo.addAttribute("usuarios", serviceUsuarios.getAll(page));
		return "/usuarios/userList";
	}
	
	@GetMapping("/delete/{id}")
	private String delete(@PathVariable int id) {
		serviceUsuarios.borrar(serviceUsuarios.getById(id));
		return "redirect:/usuarios/list";
	}
	
	@GetMapping("/edit/{id}")
	private String edit(@PathVariable int id, Model modelo) {
		modelo.addAttribute("newUser", serviceUsuarios.getById(id));
		modelo.addAttribute("skins", serviceSkins.getAll());
		modelo.addAttribute("action", "usuarios/edit");
		return "/usuarios/userForm";
	}
	
	@PostMapping("/edit")
	private String edit(@ModelAttribute("newUser") UsuarioDto newUser) {
		UsuarioDto usrModificado = serviceUsuarios.getById(newUser.getId());

		usrModificado.setUsername(StringUtils.hasText(newUser.getUsername()) ? newUser.getUsername() : null);
		usrModificado.setPassword(StringUtils.hasText(newUser.getPassword()) ? passwordEncoder.encode(newUser.getPassword()) : null);
		usrModificado.setNombre(StringUtils.hasText(newUser.getNombre()) ? newUser.getNombre() : null);
		
		serviceUsuarios.modificar(usrModificado);
		return "redirect:/usuarios/list";
	}
}
