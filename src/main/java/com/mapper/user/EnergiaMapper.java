package com.mapper.user;

import java.util.List;

import org.mapstruct.Mapper;

import com.domain.entity.user.Energia;
import com.dto.user.EnergiaDto;

@Mapper(componentModel = "spring")
public interface EnergiaMapper {
	EnergiaDto toDto(Energia energiaEntity);
	List<EnergiaDto> toDtoList(List<Energia> energiaEntity);


	Energia toEntity(EnergiaDto energiaDto);
	List<Energia> toEntityList(List<EnergiaDto> energiaDto);
}
