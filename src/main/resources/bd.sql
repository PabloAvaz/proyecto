CREATE DATABASE lovelive;
USE lovelive;

CREATE TABLE usuario(
id int NOT NULL AUTO_INCREMENT,
username varchar(50),
password varchar(50),
nombre varchar(50),
puntos int,
estatus boolean,
CONSTRAINT pk_usuarios PRIMARY KEY(id),
CONSTRAINT UC_usuarios UNIQUE (username)
);

CREATE TABLE producto(
idProducto int NOT NULL AUTO_INCREMENT,
nombre varchar(50),
descripcion varchar(50),
imagen varchar(50),
precio int,
CONSTRAINT pk_producto PRIMARY KEY(idProducto)
);

CREATE TABLE productoUsuario(
id int not null,
idProducto int not null,
constraint fk_productousuario1 foreign key (id) references usuario(id),
constraint fk_productousuario2 foreign key (idProducto) references producto(idproducto)
);

CREATE TABLE skin (
idSkin int NOT NULL AUTO_INCREMENT,
imagen varchar(50),
sonido varchar(50),
CONSTRAINT pk_skin PRIMARY KEY(idSkin)
);

CREATE TABLE skinUsuario(
id int not null,
idSkin int not null,
constraint fk_skinUsuario1 foreign key (id) references usuario(id),
constraint fk_skinUsuario2 foreign key (idSkin) references skin (idSkin)
);