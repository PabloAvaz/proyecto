package com.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.domain.entity.acciones.AccionEquipable;
import com.domain.repository.AccionEquipableRepository;
import com.service.IAccionEquipableService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AccionEquipableServiceImpl implements IAccionEquipableService {
	private final AccionEquipableRepository repoAcciones;
	
	@Override
	public List<AccionEquipable> getAll() {
		return repoAcciones.findAll();
	}

	@Override
	public void save(AccionEquipable accion) {
		repoAcciones.save(accion);
	} 
}
