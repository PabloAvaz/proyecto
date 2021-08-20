package com.validator.producto;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.dto.producto.ProductoDto;
import com.enums.Tipo;

/**
 * Clase para realizar las validaciones de productos
 * @author Pablo
 *
 */

@Component
public class ProductoValidator {
	
	private final List<Tipo> TIPOS_VALIDOS = Arrays.asList(Tipo.values()); 

	/**
	 * Metodo que devuelve un mapa con los errores de validacion que contenga el producto pasado como parametro
	 * @param producto
	 * @return
	 */
	public Map<String, String> validarProducto(ProductoDto producto) {
		
		
		Map<String, String> mensajes = new HashMap<>();
		
		if(!StringUtils.hasText(producto.getNombre())) {
			mensajes.put("prod.nombre.obl", "Campo Nombre obligatorio");
		}
		
		if(!StringUtils.hasText(producto.getDescripcion())) {
			mensajes.put("prod.descr.obl", "Campo Descripcion obligatorio");
		}
		
		if(!TIPOS_VALIDOS.contains(producto.getTipo())) {
			mensajes.put("prod.tipo.obl", "Campo tipo obligatorio");
		}
		
		if(producto.getPrecio() < 0) {
			mensajes.put("prod.precio.neg", "El precio no puede ser negativo");
		}
		
		return mensajes;
	}
}
