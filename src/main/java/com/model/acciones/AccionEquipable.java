package com.model.acciones;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.model.producto.Skin;

@Entity
@Table(name = "accionequipable")
public class AccionEquipable extends Accion {
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idSkin")
	private Skin skin;
	
	public AccionEquipable() {
	}

	public AccionEquipable(int id, Skin skin) {
		super(id);
		this.skin = skin;
	}

	public Skin getSkin() {
		return skin;
	}

	public void setSkin(Skin skin) {
		this.skin = skin;
	}
	
}
