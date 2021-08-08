package com.mapper.user;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;
import org.springframework.data.domain.Page;

import com.domain.entity.user.Usuario;
import com.dto.user.UsuarioDto;
import com.mapper.producto.ProductoMapper;
import com.mapper.producto.SkinMapper;


@Mapper(componentModel = "spring", uses = {SkinMapper.class})
public interface UsuarioMapper {

	
	UsuarioDto toDto(Usuario usuarioEntity);
	List<UsuarioDto> toDtoList(List<Usuario> usuariosEntity);

	Usuario toEntity(UsuarioDto usuariodto);
	List<Usuario> toEntityList(List<UsuarioDto> usuariosDto);
	
	@Mappings ({
		@Mapping(target="password", expression = "java(usuariodto.getPassword() != null ? usuariodto.getPassword() : usuario.getPassword())"),
		@Mapping(target="username", expression = "java(usuariodto.getUsername() != null ? usuariodto.getUsername() : usuario.getUsername())"),
		@Mapping(target="nombre", expression = "java(usuariodto.getNombre() != null ? usuariodto.getNombre() : usuario.getNombre())")
	})
	Usuario merge(UsuarioDto usuariodto, @MappingTarget Usuario usuario);
}	
