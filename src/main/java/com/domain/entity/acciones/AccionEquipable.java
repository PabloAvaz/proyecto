package com.domain.entity.acciones;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


import com.domain.entity.producto.Skin;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "accionEquipable")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class AccionEquipable extends Accion {
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idSkin")
	private Skin skin;
	
	public AccionEquipable(int id, Skin skin) {
		super(id);
		this.skin = skin;
	}
	
}
