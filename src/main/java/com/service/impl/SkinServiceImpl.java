package com.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.domain.entity.producto.Skin;
import com.domain.repository.SkinRepository;
import com.dto.producto.SkinDto;
import com.mapper.producto.SkinMapper;
import com.service.ISkinService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SkinServiceImpl implements ISkinService {
	private final SkinRepository repoSkin;
	private final SkinMapper skinMapper;

	@Override
	public List<SkinDto> getAll() {
		return skinMapper.toDtoList(repoSkin.findAll());
	}

	@Override
	public void guardar(SkinDto skin) {
		repoSkin.save(skinMapper.toEntity(skin));
	}

	@Override
	public void modificar(SkinDto skin) {
		Skin skinEntity =  repoSkin.findById(skin.getId()).get();
		skinMapper.merge(skin, skinEntity);
		repoSkin.save(skinEntity);
	}

	@Override
	public void borrar(SkinDto skin) {
		repoSkin.delete(skinMapper.toEntity(skin));
	}

	@Override
	public SkinDto getById(Integer id) {
		Optional<Skin> skin = repoSkin.findById(id);
		return skin.isPresent() ? skinMapper.toDto(skin.get()) : null;
	}

}
