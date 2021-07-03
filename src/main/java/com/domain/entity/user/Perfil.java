package com.domain.entity.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "perfil")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Perfil {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idPerfil;
	private String perfil;
	
}
