package com.service.bd;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.user.Perfil;
import com.repository.PerfilRepository;
import com.service.IPerfilService;

@Service
public class PerfilService implements IPerfilService {

	@Autowired
	private PerfilRepository repoPerfiles;
	
	@Override
	public Perfil getPerfil(Integer id) {
		Optional<Perfil> perfil = repoPerfiles.findById(id);
		return perfil.isPresent() ? perfil.get() : null;
	}

}
