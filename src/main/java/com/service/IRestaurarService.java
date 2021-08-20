package com.service;

import org.springframework.stereotype.Service;

import com.dto.user.UsuarioDto;
import com.dto.util.Codigo;
import com.enums.TipoCodigo;

@Service
public interface IRestaurarService {
	
	Codigo generarCodigo(String email, TipoCodigo tipo);
	UsuarioDto validarCodigo(Codigo codigo);
	boolean mailNewPass(UsuarioDto user, String ruta);
	boolean mailNewUser(UsuarioDto user, String ruta);
}
