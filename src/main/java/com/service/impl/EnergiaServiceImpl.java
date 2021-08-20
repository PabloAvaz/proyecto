package com.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.domain.entity.user.Energia;
import com.domain.repository.EnergiaRepository;
import com.dto.user.EnergiaDto;
import com.mapper.user.EnergiaMapper;
import com.service.IEnergiaService;

import lombok.RequiredArgsConstructor;

/**
 * Interfaz con los metodos para gestionar la clase energia
 * @author Pablo
 *
 */

@RequiredArgsConstructor
@Service
public class EnergiaServiceImpl implements IEnergiaService {

	private final EnergiaRepository energiaRepo;
	private final EnergiaMapper energiaMapper;

	@Override
	public List<EnergiaDto> findAll() {
		return energiaMapper.toDtoList(energiaRepo.findAll());
	}

	@Override
	public EnergiaDto findById(Integer id) {
		java.util.Optional<Energia> energia = energiaRepo.findById(id);
		return energia.isPresent() ?  energiaMapper.toDto(energia.get()) : null;
		
	}

	@Override
	public void guardar(EnergiaDto energia) {
		energiaRepo.save(energiaMapper.toEntity(energia));
	}

	@Override
	public void modificar(EnergiaDto energia) {
		energiaRepo.save(energiaMapper.toEntity(energia));
	}


}
