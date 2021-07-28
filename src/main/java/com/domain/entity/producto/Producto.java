package com.domain.entity.producto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.enums.Tipo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="producto")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Producto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idProducto")
	private int id;
	private String nombre;
	private String descripcion;
	private String imagen = "default.png";
	private int precio;
	private Tipo tipo;

}
