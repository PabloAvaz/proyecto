package com.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.dto.producto.SkinDto;
import com.service.ISkinService;
import com.util.Utilidades;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/skin")
@RequiredArgsConstructor
public class SkinController extends BaseController {
	@Value("${ruta.imagenes}")
	private String rutaImagen;
	@Value("${ruta.sonidos}")
	private String rutaSonido;
	
	private final ISkinService serviceSkin;
	
	@GetMapping("/list")
	public String list(Model modelo) {
		modelo.addAttribute("skins",serviceSkin.getAll());
		return "skin/skinList.html";
	}
	
	@GetMapping("/create")
	public String create(Model modelo) {
		modelo.addAttribute("skin", new SkinDto());
		return "skin/skinForm.html";
	}
	@PostMapping("/create")
	public String crear(Model modelo,@ModelAttribute SkinDto skin, MultipartFile archivoImagen, BindingResult resultadoImg, MultipartFile archivoSonido, BindingResult resultadoAudio) {
		if(resultadoImg.hasErrors() || resultadoAudio.hasErrors()) {
			return "redirect:/skin/create";
		}
		
		String img = Utilidades.guardarArchivo(archivoImagen, rutaImagen);
		String audio = Utilidades.guardarArchivo(archivoSonido, rutaSonido);
		
		if(!img.endsWith("_")) {
			skin.setImagen(img);
		}
		if(!audio.endsWith("_")) {
			skin.setSonido(audio);
		}
		serviceSkin.guardar(skin);
		
		return "redirect:/skin/list";
	}
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable int id, Model modelo) {
		modelo.addAttribute("skin", serviceSkin.getById(id));
		return "/skin/skinForm";
	}
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		serviceSkin.borrar(serviceSkin.getById(id));
		return "redirect:/skin/list";
	}
}
