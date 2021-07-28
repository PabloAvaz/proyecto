package com.mapper.user;

import java.util.List;

import org.mapstruct.Mapper;

import com.domain.entity.user.Daily;
import com.dto.user.DailyDto;

@Mapper(componentModel = "spring")
public interface DailyMapper {

	
	DailyDto toDto(Daily dailyEntity);
	List<DailyDto> toDtoList(List<Daily> dailyEntity);


	Daily toEntity(DailyDto dailyDto);
	List<Daily> toEntityList(List<DailyDto> dailyDto);
}	
