package com.mapper.acciones;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import com.domain.entity.acciones.Efecto;
import com.dto.acciones.EfectoDto;

@Mapper(componentModel = "spring")
public interface EfectoMapper {
	
	EfectoDto toDto(Efecto efectoEntity);
	List<EfectoDto> toDtoList(List<Efecto> efectoEntity);
	
	Efecto toEntity(EfectoDto efectoDto);
	List<Efecto> toEntityList(List<EfectoDto> efectoEntity);
	
	Efecto merge(EfectoDto efectoDto, @MappingTarget Efecto efecto);
}
	
	