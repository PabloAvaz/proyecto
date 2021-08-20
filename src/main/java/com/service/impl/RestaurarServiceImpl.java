package com.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.dto.user.UsuarioDto;
import com.dto.util.Codigo;
import com.enums.TipoCodigo;
import com.service.IRestaurarService;
import com.service.IUsuarioService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RestaurarServiceImpl implements IRestaurarService {
	private final IUsuarioService usuarioService;
	private final PasswordEncoder passwordEncoder;
    private final JavaMailSender emailSender;
	
	private static Map<Codigo, UsuarioDto> usuarios = new HashMap<Codigo, UsuarioDto>();
	
	
	public Codigo generarCodigo(String email, TipoCodigo tipo) {
		UsuarioDto user = usuarioService.getByEmail(email);
		String codigo = null;
		
		if(user != null) {
			codigo = passwordEncoder.encode(user.getUsername() + System.currentTimeMillis()).replaceAll("/","");
			usuarios.put(new Codigo(codigo, tipo), user);
		}

		return new Codigo(codigo, tipo);
	}
	
	public UsuarioDto validarCodigo(Codigo codigo) {
		return usuarios.get(codigo);
	}
	

	/**
	 * Metodo que envia un mail con un enlace para resetear la contraseña
	 */
	public boolean mailNewPass(UsuarioDto user, String ruta) {
		try {
			if(user != null && user.getEmail() != null && !user.getEmail().isEmpty()) {
		        SimpleMailMessage mail = new SimpleMailMessage(); 
		        mail.setTo(user.getEmail());
		        mail.setSubject("Cambia de contraseña!");
		        mail.setText("Para cambiar de contraseña haz click aquí: http://" + ruta);
		        emailSender.send(mail);
				return true;
			}
		} catch (Exception e) {
			System.out.println("No se pudo enviar el mail: " + e.getMessage());
		}
		return false;
	}
	
	/**
	 * Metodo que envia un mail con un enlace para validar a un usuario
	 */
	public boolean mailNewUser(UsuarioDto user, String ruta) {
		try {
			if(user != null && user.getEmail() != null && !user.getEmail().isEmpty()) {
		        SimpleMailMessage mail = new SimpleMailMessage(); 
		        mail.setTo(user.getEmail());
		        mail.setSubject("Verifica tu usuario");
		        mail.setText("Para validar tu usuario haz click aquí: http://" + ruta);
		        emailSender.send(mail);
				return true;
			} 
		} catch (Exception e) {
			System.out.println("No se pudo enviar el mail: " + e.getMessage());
		}
		return false;
	}
	
	/**
	 * Metodo que resetea cada 15 minutos los tokens
	 */
	@Scheduled(cron = "0 0/15 * * * ?")
	private static void reset() {
		usuarios.clear();
	}
}
