package com.domain.entity.producto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name="skin")
@Data
@AllArgsConstructor
public class Skin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idSkin")
	private Integer id;
	private String nombre;
	private String imagen;
	private String sonido;
	
	public Skin() {
		this(1,"DEFAULT","default.png","default.wav");
	}

}
