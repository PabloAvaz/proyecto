package com.dto.producto;

import java.util.List;

import com.dto.acciones.EfectoDto;
import com.enums.Tipo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductoDto {

	private int id;
	private String nombre;
	private String descripcion;
	private String imagen = "default.png";
	private int precio;
	private Tipo tipo;
	private boolean activo;
	
	private List<EfectoDto> efectos;
	
	public void activar() {
		this.activo = true;
	}
	
	public void desactivar() {
		this.activo = false;
	}
	
	public void toggle() {
		this.activo = !this.activo;
	}

	@Override
	public String toString() {
		return "ProductoDto [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", imagen=" + imagen
				+ ", precio=" + precio + ", tipo=" + tipo + ", efectos=" + efectos + "]";
	}
	
	
}
