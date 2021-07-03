package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.domain.entity.acciones.AccionEquipable;
import com.domain.repository.AccionEquipableRepository;
import com.service.IAccionEquipableService;

@Service
public class AccionEquipableServiceImpl implements IAccionEquipableService {
	@Autowired AccionEquipableRepository repoAcciones;
	
	@Override
	public List<AccionEquipable> getAll() {
		return repoAcciones.findAll();
	}

	@Override
	public void save(AccionEquipable accion) {
		repoAcciones.save(accion);
	}

}
