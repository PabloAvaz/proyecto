package com.domain.entity.user;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.Data;
import lombok.NoArgsConstructor;



@NoArgsConstructor
@MappedSuperclass
@Data
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Integer id;
	protected String nombre;
	protected boolean estatus;

	protected String username;
	protected String password;
	
	public User(Integer id, String nombre, String username, String password, boolean estatus) {
		this.id = id;
		this.nombre = nombre;
		this.estatus = estatus;
		this.username = username;
		this.password = password;
	}
	
}
