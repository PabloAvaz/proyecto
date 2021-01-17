package com.model.acciones;

import com.model.enums.TipoEfecto;

public class Efecto {
	private TipoEfecto tipo;

	private int duracion;
	private int poder;
		
	public Efecto(int duracion, int poder) {
		this.duracion = duracion;
		this.poder = poder;
	}
	
	public int getDuracion() {
		return duracion;
	}
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
	public int getPoder() {
		return poder;
	}
	public void setPoder(int poder) {
		this.poder = poder;
	}
	public TipoEfecto getTipo() {
		return tipo;
	}
	public void setTipo(TipoEfecto tipo) {
		this.tipo = tipo;
	}

}
