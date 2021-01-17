package com.service.bd;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.acciones.AccionEquipable;
import com.repository.AccionEquipableRepository;
import com.service.IAccionEquipableService;

@Service
public class AccionEquipableServiceJpa implements IAccionEquipableService {
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
