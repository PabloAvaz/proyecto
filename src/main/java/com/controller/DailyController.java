package com.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dto.user.UsuarioDto;
import com.dto.util.Alert;
import com.enums.TipoMensaje;
import com.service.IUsuarioService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/daily")
@RequiredArgsConstructor
public class DailyController {
	private final IUsuarioService serviceUsuario;
	
	private UsuarioDto usr;
	
	@ModelAttribute
	private void init(HttpSession sesion) {
		usr = (UsuarioDto) sesion.getAttribute("usuario");
	}
	
	@GetMapping("/claim")
	public String claim(RedirectAttributes atrib) {

	if(serviceUsuario.reclamarDaily(usr)) {
		atrib.addFlashAttribute("msgDaily", new Alert("Recompensa reclamada con éxito", TipoMensaje.SUCCESS));
	} else {
		atrib.addFlashAttribute("msgDaily", new Alert("Error al reclamar la recompensa diaria", TipoMensaje.ERROR));
	}
	
	
	return "redirect:/play";
	}
	
	@Scheduled(cron = "0 0 0 * * *")
	private void restart() {
		System.out.println("Reiniciando recompensas diarias: " + new Date());
		serviceUsuario.reiniciarDaily();
	}
}
