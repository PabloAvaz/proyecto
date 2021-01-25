package com.model.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Energia")
public class Energia {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idEnergia")
	private int id;
	private int total;
	private int actual;
	
	public Energia() {}
	public Energia(int total, int actual) {
		this.total = total;
		this.actual = actual;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getActual() {
		return actual;
	}
	public void setActual(int actual) {
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
	
	@Override
	public String toString() {
		return "Energia [id=" + id + ", total=" + total + ", actual=" + actual + "]";
	}
	
}
