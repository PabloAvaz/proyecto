CREATE DATABASE lovelive;
USE lovelive;

CREATE TABLE skin (
idSkin int NOT NULL AUTO_INCREMENT,
nombre varchar(50),
imagen varchar(50),
sonido varchar(50),
CONSTRAINT pk_skin PRIMARY KEY(idSkin)
);

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

CREATE TABLE accionEquipable(
idProducto int NOT NULL AUTO_INCREMENT,
idSkin int not null,
CONSTRAINT pk_accion PRIMARY KEY(idProducto),
constraint fk_accionEquipable1 foreign key (idSkin) references skin(idSkin),
constraint fk_accionEquipable2 foreign key (idProducto) references producto(idproducto)
);

insert into skin values(1,"DEFAULT","default.png","default.wav");
insert into skin values(2,"Kanan","kanan.webp","cancion1.mp3");
insert into skin values(3,"Woki","woki.jpg","gato.mp3");

insert into usuario values(1,"","","DEFAULT", 0, 1, 1);

insert into producto values(1,"Vestido de rico","El vestido inicial","default.png", 0, 0);
insert into producto values(2,"Vestido de kanan","El vestido kanan","kanan.webp", 10, 0);
insert into producto values(3,"Traje de gato","Woki woki <3","woki.jpg", 10, 0);
insert into producto values(4,"Cereales Crunchy crunchy","Los mejores cereales para el mejor gato","woki.jpg", 10, 1);

insert into productoUsuario values(1,1,1);
insert into productoUsuario values(1,2,1);
insert into productoUsuario values(1,3,1);
insert into productoUsuario values(1,4,10);

insert into accionEquipable values(1,1);
insert into accionEquipable values(2,2);
insert into accionEquipable values(3,3);