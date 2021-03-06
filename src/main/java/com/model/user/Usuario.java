package com.model.user;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.model.producto.Producto;
import com.model.producto.Skin;

@Entity
@Table(name="usuario")
public class Usuario extends User {
	
	private int puntos;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "skin", referencedColumnName ="idSkin")
	private Skin skin;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "energia", referencedColumnName ="idEnergia")
	private Energia energia;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(
			name = "productousuario",
			joinColumns = @JoinColumn(name="id"), 
			inverseJoinColumns = @JoinColumn(name="idProducto"))
	private List<Producto> articulos;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
			name = "PerfilUsuario",
			joinColumns = @JoinColumn(name = "idUsuario"),
			inverseJoinColumns = @JoinColumn(name = "idPerfil")
			)
	@Fetch(FetchMode.SELECT)
	private List<Perfil> perfiles;
	
	public Usuario() {
		this(0,"","",true,"",0);
		//this.skin = new Skin();
	}

	public Usuario(Integer id, String username, String password, boolean estatus, String nombre, int puntos) {
		super(id,nombre,username,password,estatus);
		this.username = username;
		this.password = password;
		this.estatus = estatus;
		this.nombre = nombre;
		this.puntos = puntos;
		this.articulos = new LinkedList<Producto>();
		this.energia = new Energia(25,25);
	}

	public int getPuntos() {
		return puntos;
	}
	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}
	public List<Producto> getArticulos() {
		return articulos;
	}
	public void setArticulos(List<Producto> articulos) {
		this.articulos = articulos;
	}
	public Skin getSkin() {
		return skin;
	}
	public void setSkin(Skin skin) {
		this.skin = skin;
	}
	public Energia getEnergia() {
		return energia;
	}
	public void setEnergia(Energia energia) {
		this.energia = energia;
	}
	public List<Perfil> getPerfiles() {
		return perfiles;
	}
	public void setPerfiles(List<Perfil> perfiles) {
		this.perfiles = perfiles;
	}

	public void agregarPerfil(Perfil tempPerfil) {
		if(perfiles==null) {
			perfiles = new LinkedList<Perfil>();
		}
		perfiles.add(tempPerfil);
	}
	public void anotar() {
		this.puntos++;
	}
	public void comprar(Producto articulo) {
			articulos.add(articulo);
	}
	public void gastar(int cantidad) {
		this.puntos -= cantidad;
	}

	@Override
	public String toString() {
		return "Usuario [puntos=" + puntos + ", skin=" + skin + ", energia=" + energia + ", articulos=" + articulos
				+ ", perfiles=" + perfiles + ", id=" + id + ", nombre=" + nombre + ", estatus=" + estatus
				+ ", username=" + username + ", password=" + password + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
