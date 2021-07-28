package com.domain.entity.acciones;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.enums.TipoEfecto;

import lombok.Data;

@Entity
@Data
public class Efecto {
	@Id
	@Column(name="idEfecto")
	private int id;
	private int duracion;
	private int poder;
	private TipoEfecto tipo;
}
