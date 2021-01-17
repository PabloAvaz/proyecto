package com.service.bd;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.producto.Skin;
import com.repository.SkinRepository;
import com.service.ISkinService;
@Service
public class SkinJpaService implements ISkinService {
	@Autowired
	private SkinRepository repoSkin;

	@Override
	public List<Skin> getAll() {
		return repoSkin.findAll();
	}

	@Override
	public void guardar(Skin skin) {
		repoSkin.save(skin);
	}

	@Override
	public void modificar(Skin skin) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void borrar(Skin skin) {
		repoSkin.delete(skin);
	}

	@Override
	public Skin getById(Integer id) {
		Optional<Skin> skin = repoSkin.findById(id);
		return skin.isPresent() ? skin.get() : null;
	}

}
