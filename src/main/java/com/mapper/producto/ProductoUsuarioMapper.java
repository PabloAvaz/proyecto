package com.mapper.producto;

import java.util.List;

import org.mapstruct.Mapper;

import com.domain.entity.producto.ProductoUsuario;
import com.dto.producto.ProductoUsuarioDto;

@Mapper(componentModel = "spring")
public interface ProductoUsuarioMapper {
	
	ProductoUsuarioDto toDto(ProductoUsuario productoUsuarioEntity);
	List<ProductoUsuarioDto> toDtoList(List<ProductoUsuario> productoUsuarioEntity);
	
	ProductoUsuario toEntity(ProductoUsuarioDto productoUsuarioDto);
	List<ProductoUsuario> toEntityList(List<ProductoUsuarioDto> productoUsuarioEntity);
}
