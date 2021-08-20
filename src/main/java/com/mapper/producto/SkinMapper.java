package com.mapper.producto;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import com.domain.entity.producto.Skin;
import com.dto.producto.SkinDto;

/**
 * Mapper de la clase skin
 * @author Pablo
 *
 */

@Mapper(componentModel = "spring")
public interface SkinMapper {
	
	SkinDto toDto(Skin skinEntity);
	List<SkinDto> toDtoList(List<Skin> skinEntity);
	Skin toEntity(SkinDto skinDto);
	List<Skin> toEntityList(List<SkinDto> skinEntity);
	
	Skin merge(SkinDto skinDto, @MappingTarget Skin skin);
}
