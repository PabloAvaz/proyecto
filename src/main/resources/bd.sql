CREATE DATABASE lovelive;
USE lovelive;

CREATE TABLE skin (
idSkin int NOT NULL AUTO_INCREMENT,
imagen varchar(50),
sonido varchar(50),
CONSTRAINT pk_skin PRIMARY KEY(idSkin)
);

insert into skin values(1,"default.png","default.wav");

CREATE TABLE usuario(
id int NOT NULL AUTO_INCREMENT,
username varchar(50),
password varchar(50),
nombre varchar(50),
puntos int,
estatus boolean,
skin int default 1,
CONSTRAINT pk_usuarios PRIMARY KEY(id),
CONSTRAINT UC_usuarios UNIQUE (username),
constraint fk_UC_usuarios foreign key (skin) references skin(idSkin)
);

CREATE TABLE producto(
idProducto int NOT NULL AUTO_INCREMENT,
nombre varchar(50),
descripcion varchar(50),
imagen varchar(50),
precio int,
tipo varchar(20),
CONSTRAINT pk_producto PRIMARY KEY(idProducto)
);

CREATE TABLE productoUsuario(
id int not null,
idProducto int not null,
cantidad int default 1,
CONSTRAINT pk_productoUsuario PRIMARY KEY(id,idproducto),
constraint fk_productousuario1 foreign key (id) references usuario(id),
constraint fk_productousuario2 foreign key (idProducto) references producto(idproducto)
);

-- EN DESARROLLO

CREATE TABLE accionEquipable(
id int not null,
idSkin int not null,
CONSTRAINT pk_accion PRIMARY KEY(id),
CONSTRAINT UQ_accion UNIQUE (idSkin),
constraint fk_accionEquipable foreign key (idSkin) references skin(idSkin)
);


-- drop table usuario;
/*
select u.username, p.perfil from UsuarioPerfil up 
					inner join Usuarios u on u.id = up.idUsuario 
					inner join Perfiles p on p.id = up.idPerfil 
					where u.username = "pablo";
					
SELECT username, password, estatus from Usuarios where username="pablo";
*/