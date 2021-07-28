package com.service;

import java.util.List;

import com.dto.producto.SkinDto;

public interface ISkinService {
	List<SkinDto> getAll();
	SkinDto getById(Integer id);
	void guardar(SkinDto skin);
	void modificar(SkinDto skin);
	void borrar(SkinDto skin);
	
}
