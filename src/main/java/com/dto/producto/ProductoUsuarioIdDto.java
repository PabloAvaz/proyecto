package com.dto.producto;


import java.io.Serializable;

import com.domain.entity.user.Usuario;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;




@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductoUsuarioIdDto implements Serializable {
	private static final long serialVersionUID = 1L;
	
	protected ProductoDto producto;
	protected Usuario user;
}
