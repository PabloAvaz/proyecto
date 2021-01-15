package com.service;

import java.util.List;

import com.model.producto.Skin;

public interface ISkinService {
	List<Skin> getAll();
	void guardar(Skin skin);
	void modificar(Skin skin);
	void borrar(Skin skin);
	
}
