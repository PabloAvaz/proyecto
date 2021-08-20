package com.mapper.user;

import java.util.List;

import org.mapstruct.Mapper;

import com.domain.entity.user.Perfil;
import com.dto.user.PerfilDto;

/**
 * Mapper de la clase perfil
 * @author Pablo
 *
 */

@Mapper(componentModel = "spring")
public interface PerfilMapper {
	PerfilDto toDto(Perfil perfilEntity);
	List<PerfilDto> toDtoList(List<Perfil> perfilEntity);
	Perfil toEntity(PerfilDto perfilDto);
	List<Perfil> toEntityList(List<PerfilDto> perfilEntity);
}
