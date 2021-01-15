package com.model.producto;

import com.model.enums.TipoAccion;

public class Accion {
	private int id;
	private TipoAccion tipo;
	private int cantidad;
	private int duracion;
	private int poder;
	
	public Accion(int id, TipoAccion tipo, int cantidad, int duracion, int poder) {
		this.id = id;
		this.tipo = tipo;
		this.cantidad = cantidad;
		this.duracion = duracion;
		this.poder = poder;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public TipoAccion getTipo() {
		return tipo;
	}
	public void setTipo(TipoAccion tipo) {
		this.tipo = tipo;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
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

}
