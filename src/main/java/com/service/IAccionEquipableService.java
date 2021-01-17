package com.service;

import java.util.List;

import com.model.acciones.AccionEquipable;

public interface IAccionEquipableService {
	List<AccionEquipable> getAll();
	void save(AccionEquipable accion);
}
