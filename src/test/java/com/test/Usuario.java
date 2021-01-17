package com.test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.model.producto.Producto;
import com.model.producto.Skin;
import com.model.user.User;

@Entity
@Table(name="usuario")
public class Usuario extends User {
	
	//TEEEEEEEEEMP
    @OneToMany(
            mappedBy = "usuario",
            cascade = CascadeType.ALL,
            orphanRemoval = true
        )
    private List<ProductoUsuario> productos = new ArrayList<>();
    
	

	public List<ProductoUsuario> getProductos() {
		return productos;
	}

	public void setProductos(List<ProductoUsuario> productos) {
		this.productos = productos;
	}

	private int puntos;
	@OneToOne
	@JoinColumn(name = "skin", referencedColumnName ="idSkin")
	private Skin skin;
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(
			name = "productousuario",
			joinColumns = @JoinColumn(name="id"), 
			inverseJoinColumns = @JoinColumn(name="idProducto"))
	private List<Producto> articulos;
	
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
		return "Usuario [puntos=" + puntos + ", skin=" + skin + ", articulos=" + articulos 
				+ ", id=" + id + ", nombre=" + nombre + ", estatus=" + estatus + ", username=" + username
				+ ", password=" + password + "]";
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
