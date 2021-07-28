package com.dto.user;

import java.util.LinkedList;
import java.util.List;

import com.constants.Constants;
import com.dto.producto.ProductoDto;
import com.dto.producto.SkinDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioDto extends UserDto {
	
	private int puntos;
	private SkinDto skin;
	private EnergiaDto energia;
	private List<ProductoDto> articulos;
	private List<PerfilDto> perfiles;
	
	public UsuarioDto() {
		this(0, "", "", true, "", 0);
		this.skin = Constants.DEFAULT_SKIN;
	}

	public UsuarioDto(Integer id, String username, String password, boolean estatus, String nombre, int puntos) {
		super(id,nombre,username,password,estatus);
		this.username = username;
		this.password = password;
		this.estatus = estatus;
		this.nombre = nombre;
		this.puntos = puntos;
		this.articulos = new LinkedList<ProductoDto>();
		this.energia = new EnergiaDto(25,25);
	}

	public void agregarPerfil(PerfilDto tempPerfil) {
		if(perfiles==null) {
			perfiles = new LinkedList<PerfilDto>();
		}
		perfiles.add(tempPerfil);
	}
	public void anotar() {
		this.puntos++;
	}
	public void comprar(ProductoDto articulo) {
			articulos.add(articulo);
	}
	public void darPuntos(int cantidad) {
		this.puntos += cantidad;
	}
	public void gastar(int cantidad) {
		this.puntos -= cantidad;
	}

}
