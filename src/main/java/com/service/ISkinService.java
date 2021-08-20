package com.service;

import java.util.List;
import com.dto.producto.SkinDto;

/**
 * Interfaz con los metodos para gestionar la clase skin
 * @author Pablo
 *
 */

public interface ISkinService {
	List<SkinDto> getAll();
	SkinDto getById(Integer id);
	void guardar(SkinDto skin);
	void modificar(SkinDto skin);
	void borrar(SkinDto skin);
	
}
