package com.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.AsyncHandlerInterceptor;

/**
 * Controlador generico del que se puede extender en caso de necesitar la misma funcionaliadad el muchos sitios
 * @author Pablo
 *
 */
@Component
public class BaseController implements AsyncHandlerInterceptor {
	
}
