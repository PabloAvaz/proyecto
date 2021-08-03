package com.mapper.user;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import com.domain.entity.user.Usuario;
import com.dto.user.UsuarioDto;


@Mapper(componentModel = "spring")
public interface UsuarioMapper {

	
	UsuarioDto toDto(Usuario usuarioEntity);
	List<UsuarioDto> toDtoList(List<Usuario> usuariosEntity);


	Usuario toEntity(UsuarioDto usuariodto);
	List<Usuario> toEntityList(List<UsuarioDto> usuariosDto);
	
	Usuario merge(UsuarioDto usuariodto, @MappingTarget Usuario usuario);
}	
