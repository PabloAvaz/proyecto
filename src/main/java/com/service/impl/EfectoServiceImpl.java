package com.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.domain.entity.acciones.Efecto;
import com.domain.repository.EfectoRepository;
import com.dto.acciones.EfectoDto;
import com.mapper.acciones.EfectoMapper;
import com.service.IEfectoService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EfectoServiceImpl implements IEfectoService {
	private final EfectoRepository repoEfectos;
	private final EfectoMapper efectoMapper;

	@Override
	public List<EfectoDto> getAll() {
		return efectoMapper.toDtoList(repoEfectos.findAll());
	}
	
	@Override
	public EfectoDto get(EfectoDto efecto) {
		return getById(efecto.getIdEfecto());
	}
	
	@Override
	public EfectoDto getById(int id) {
		Optional<Efecto> efectoOpt = repoEfectos.findById(id);
		return (efectoOpt.isPresent() ? efectoMapper.toDto(efectoOpt.get()) : null);
	}

	@Override
	public void save(EfectoDto efecto) {
		repoEfectos.save(efectoMapper.toEntity(efecto));
	}
	
	@Override
	public void delete(EfectoDto efecto) {
		deleteById(efecto.getIdEfecto());
	}
	
	@Override
	public void deleteById(int idEfecto) {
		repoEfectos.deleteById(idEfecto);
	}

	@Override
	public void update(EfectoDto efecto) {
		Optional<Efecto> efectoOpt = repoEfectos.findById(efecto.getIdEfecto());
		if(efectoOpt.isPresent()) {
			repoEfectos.save(efectoMapper.merge(efecto, efectoOpt.get()));
		} else {
			repoEfectos.save(efectoMapper.toEntity(efecto));
		}
	}

}
