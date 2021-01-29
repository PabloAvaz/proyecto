package com.model.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "perfil")
public class Perfil {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idPerfil;
	private String perfil;
	
	public Perfil() {}
	public Perfil(Integer idPerfil, String perfil) {
		this.idPerfil = idPerfil;
		this.perfil = perfil;
	}
	
	public Integer getIdPerfil() {
		return idPerfil;
	}
	public void setIdPerfil(Integer idPerfil) {
		this.idPerfil = idPerfil;
	}
	public String getPerfil() {
		return perfil;
	}
	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}
	
	@Override
	public String toString() {
		return "Perfil [idPerfil=" + idPerfil + ", perfil=" + perfil + "]";
	}
	
	
}
