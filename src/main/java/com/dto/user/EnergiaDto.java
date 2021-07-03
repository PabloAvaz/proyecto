package com.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnergiaDto {
	private int id;
	private int total;
	private int actual;
	
	public EnergiaDto(int total, int actual) {
		this.total = total;
		this.actual = actual;
	}
	
	public void aumentarEnergiaMaxima(int cantidad) {
		this.total += cantidad;
	}
	public void rellenar() {
		this.actual = total;
	}
	public void vaciar() {
		this.actual = 0;
	}
	public void gastar(int cantidad) {
		this.actual = actual - cantidad < 0 ? 0 : actual - cantidad;
	}
	public void recargar(int cantidad) {
		this.actual = actual + cantidad > total ? total : actual + cantidad;
	}
	
}
