package com.service;

import java.util.List;

import com.domain.entity.acciones.AccionEquipable;

public interface IAccionEquipableService {
	List<AccionEquipable> getAll();
	void save(AccionEquipable accion);
}
