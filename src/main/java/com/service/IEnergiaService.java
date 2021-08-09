package com.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dto.user.EnergiaDto;

@Service
public interface IEnergiaService {
	
	public List<EnergiaDto>  findAll();
	public EnergiaDto findById(Integer id);
	public void guardar(EnergiaDto energia);
	public void modificar(EnergiaDto energia);

}
