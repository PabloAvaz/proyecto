package com.conf;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.AsyncHandlerInterceptor;

/**
 * Clase que se ejecuta siempre que hay que procesar una peticion
 * @author Pablo
 *
 */

@Component
public class MiddleWare implements AsyncHandlerInterceptor {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		//Este codigo se ejectuta cada vez q alguien hace una peticion a la web TODO
		
		return true;
	}
}
