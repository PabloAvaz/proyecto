package com.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dto.user.UsuarioDto;

import lombok.RequiredArgsConstructor;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

/**
 * Controlador para gestionar los errores de la app
 * @author Pablo
 *
 */
@Controller
@RequiredArgsConstructor
public class ErrorControllerPro implements ErrorController {

	@ModelAttribute
	public void init(Model model) {
	    model.addAttribute("newUser", new UsuarioDto());
	}
	
	@RequestMapping("/error")
	public String controlarErrores(HttpServletRequest request){
	    Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
	    if (status != null) {
	        Integer statusCode = Integer.valueOf(status.toString());
	    
	        if(statusCode == HttpStatus.NOT_FOUND.value()) {
	            return "/error/error-404";
	        }
	        if(statusCode == HttpStatus.FORBIDDEN.value()) {
	            return "/error/error-403";
	        }
	        else if(statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
	            return "/error/error-500";
	        }
	    }
	    return "/error/error";
	}

	@Override
	public String getErrorPath() {
		return null;
	}

}
