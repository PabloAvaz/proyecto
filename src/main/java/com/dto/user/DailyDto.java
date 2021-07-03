package com.dto.user;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DailyDto {

	private Integer idUsuario;
	private Integer total;
	private Integer consecutivos;
	private boolean reclamado;

	public void reclamar() {
		total++;
		reclamado = true;
	}
	
}
