package com.service;

import java.util.List;

import com.dto.acciones.EfectoDto;

public interface IEfectoService {
	List<EfectoDto> getAll();
	EfectoDto getById(int id);
	EfectoDto get(EfectoDto efecto);
	void save(EfectoDto efecto);
	void update(EfectoDto efecto);
	public void delete(EfectoDto efecto);
	public void deleteById(int idEfecto);
}
