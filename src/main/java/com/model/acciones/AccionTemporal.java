package com.model.acciones;

import com.model.enums.Operacion;

public class AccionTemporal {
	private Operacion tipo;

	private int cantidad;
	private int duracion;
	private int poder;
		
	public AccionTemporal(int cantidad, int duracion, int poder) {
		this.cantidad = cantidad;
		this.duracion = duracion;
		this.poder = poder;
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
	public Operacion getTipo() {
		return tipo;
	}
	public void setTipo(Operacion tipo) {
		this.tipo = tipo;
	}

}
