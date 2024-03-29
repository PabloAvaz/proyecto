package com.domain.entity.user;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.domain.entity.producto.Producto;
import com.domain.entity.producto.Skin;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="usuario")
@Getter
@Setter
public class Usuario extends User {
	
	private int puntos;
	private int total;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "skin")
	private Skin skin;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "energia", referencedColumnName ="idEnergia")
	private Energia energia;
	@OneToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "id", referencedColumnName ="idUsuario")
	private Daily daily;
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(
			name = "productoUsuario",
			joinColumns = @JoinColumn(name="id"), 
			inverseJoinColumns = @JoinColumn(name="idProducto"))
	private List<Producto> articulos;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
			name = "perfilUsuario",
			joinColumns = @JoinColumn(name = "idUsuario"),
			inverseJoinColumns = @JoinColumn(name = "idPerfil")
			)
	@Fetch(FetchMode.SELECT)
	private List<Perfil> perfiles;
	

	
	public Usuario() {
		this(0,"", "", true,"","",0);
		this.skin = new Skin();
	}

	public Usuario(Integer id, String username, String password, boolean estatus, String email, String nombre, int puntos) {
		super(id, nombre, estatus, email, username, password);
		this.username = username;
		this.password = password;
		this.estatus = estatus;
		this.nombre = nombre;
		this.puntos = puntos;
		this.articulos = new LinkedList<Producto>();
		this.energia = new Energia(25,25);
	}

	public void agregarPerfil(Perfil tempPerfil) {
		if(perfiles==null) {
			perfiles = new LinkedList<Perfil>();
		}
		perfiles.add(tempPerfil);
	}
	public void anotar() {
		this.puntos++;
		this.total++;
	}
	public void comprar(Producto articulo) {
			articulos.add(articulo);
	}
	public void darPuntos(int cantidad) {
		this.puntos += cantidad;
		this.total += cantidad;
	}
	public void gastar(int cantidad) {
		this.puntos -= cantidad;
		this.total -= cantidad;
	}

	@Override
	public String toString() {
		return "Usuario [puntos=" + puntos + ", skin=" + skin + ", energia=" + energia + ", daily=" + daily
				+ ", articulos=" + articulos + ", perfiles=" + perfiles + ", id=" + id + ", nombre=" + nombre
				+ ", estatus=" + estatus + ", username=" + username + ", password=" + password + "]";
	}


	

}
