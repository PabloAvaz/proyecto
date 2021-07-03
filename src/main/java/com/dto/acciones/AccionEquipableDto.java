package com.dto.acciones;

import com.domain.entity.producto.Skin;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccionEquipableDto extends AccionDto {
	private Skin skin;
}
