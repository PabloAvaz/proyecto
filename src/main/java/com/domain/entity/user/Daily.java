package com.domain.entity.user;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "daily")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Daily {
	@Id
	private Integer idUsuario;
	private Integer total;
	private Integer consecutivos;
	private boolean reclamado;

	public void reclamar() {
		total++;
		reclamado = true;
	}
	
}
