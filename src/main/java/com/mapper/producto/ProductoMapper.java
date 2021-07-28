package com.mapper.producto;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import com.domain.entity.producto.Producto;
import com.dto.producto.ProductoDto;

@Mapper(componentModel = "spring")
public interface ProductoMapper {
	
	ProductoDto toDto(Producto productoEntity);
	List<ProductoDto> toDtoList(List<Producto> productoEntity);
	
	Producto toEntity(ProductoDto productoDto);
	List<Producto> toEntityList(List<ProductoDto> productoEntity);
	
	Producto merge(ProductoDto productoDto, @MappingTarget Producto producto);
}
