-- drop database oneclick;

CREATE DATABASE oneclick;
USE oneclick;

CREATE TABLE skin (
idSkin int NOT NULL AUTO_INCREMENT,
nombre varchar(50),
imagen varchar(60),
sonido varchar(60),
CONSTRAINT pk_skin PRIMARY KEY(idSkin)
);

CREATE TABLE energia (
idEnergia int NOT NULL AUTO_INCREMENT,
total int not null,
actual int not null,
CONSTRAINT pk_energia PRIMARY KEY(idEnergia)
);

CREATE TABLE usuario(
id int NOT NULL AUTO_INCREMENT,
username varchar(50),
password varchar(100),
nombre varchar(50),
email varchar(50),
puntos int,
total int,
estatus tinyint(1),
skin int default 1,
energia int,
CONSTRAINT pk_usuarios PRIMARY KEY(id),
CONSTRAINT UC_usuarios_Username UNIQUE (username),
CONSTRAINT UC_usuarios_energia UNIQUE (energia),
CONSTRAINT UC_usuarios_email UNIQUE (email),
CONSTRAINT fk_usuarios_skin foreign key (skin) references skin(idSkin) ON DELETE no action,
CONSTRAINT fk_usuarios_energia foreign key (energia) references energia(idEnergia) ON DELETE CASCADE
);

CREATE TABLE perfil(
idPerfil int not null AUTO_INCREMENT,
perfil varchar(15),
constraint pk_perfil primary key(idPerfil)
);

CREATE TABLE perfilUsuario(
idUsuario int not null AUTO_INCREMENT,
idPerfil int not null default 2,
constraint fk_perfilUsuario_usr foreign key(idUsuario) references usuario(id) ON DELETE CASCADE,
constraint fk_perfilUsuario_per foreign key(idPerfil) references perfil(idPerfil) ON DELETE NO ACTION 
);

CREATE TABLE producto(
idProducto int NOT NULL AUTO_INCREMENT,
nombre varchar(50),
descripcion varchar(50),
imagen varchar(50),
precio int,
tipo varchar(20),
activo boolean,
CONSTRAINT pk_producto PRIMARY KEY(idProducto)
);

CREATE TABLE productoUsuario(
id int not null,
idProducto int not null,
cantidad int default 0,
CONSTRAINT pk_productoUsuario PRIMARY KEY(id,idproducto),
constraint fk_productousuario1 foreign key (id) references usuario(id) ON DELETE CASCADE,
constraint fk_productousuario2 foreign key (idProducto) references producto(idproducto) ON DELETE CASCADE
);

CREATE TABLE accionEquipable(
idProducto int NOT NULL AUTO_INCREMENT,
idSkin int not null,
CONSTRAINT pk_accion PRIMARY KEY(idProducto),
constraint fk_accionEquipable1 foreign key (idSkin) references skin(idSkin) ON DELETE CASCADE,
constraint fk_accionEquipable2 foreign key (idProducto) references producto(idproducto) ON DELETE CASCADE
);

create table daily(
idUsuario int not null,
total int default 0 not null,
consecutivos int default 0 not null,
reclamado boolean default false,
constraint pk_recompensaDiaria primary key (idUsuario),
constraint fk_recompensaDiaria foreign key (idUsuario) references usuario(id) ON DELETE CASCADE
);

CREATE TABLE efecto (
idEfecto int NOT NULL AUTO_INCREMENT,
idProducto int,
tipo varchar(20),
duracion int,
poder int,
CONSTRAINT pk_efecto PRIMARY KEY(idEfecto),
constraint fk_efecto_producto foreign key(idProducto) references producto(idProducto) on delete cascade
);
-- drop table accionEquipable;
-- drop table usuario;

insert into skin values(1,"DEFAULT","default.png","default.wav");
insert into skin values(2,"Mikey","mikey.webp","mikey.mp3");
insert into skin values(3,"Evee","evee.jpg","gato.mp3");
insert into skin values(4,"Woki","woki.jpg","woki.mp3");

insert into energia values(1, 100, 50);
insert into energia values(2, 50, 25);
insert into energia values(3, 25, 25);
insert into energia values(4, 1000, 500);

insert into perfil values(1, "ADMIN");
insert into perfil values(2, "USER");

insert into usuario values(1,"","$2a$10$7ZxjsUMq4gkadInXbeQFPunitfypgwBralu0JM2PFlpuFJzl8Y0ty","DEFAULT", "",0, 0, 1, 1, 1);
insert into usuario values(2,"Juan","$2a$10$7ZxjsUMq4gkadInXbeQFPunitfypgwBralu0JM2PFlpuFJzl8Y0ty","Juan", "juan@hotmail.com", 0, 0, 1, 1, 2);
insert into usuario values(3,"Clowdash","$2a$10$7ZxjsUMq4gkadInXbeQFPunitfypgwBralu0JM2PFlpuFJzl8Y0ty","Clowdash", "clowdash@gmail.com", 0, 0, 1, 1, 3);
insert into usuario values(4,"Vosk","$2a$10$7ZxjsUMq4gkadInXbeQFPunitfypgwBralu0JM2PFlpuFJzl8Y0ty","Pablo", "pablo.avaz@hotmail.com", 1000, 1500, 1, 1, 4);

insert into perfilUsuario values(2, 1);
insert into perfilUsuario values(3, 2);
insert into perfilUsuario values(4, 1);

insert into producto values(1,"Traje de luffy","El vestido inicial","default.png", 0, 0, true);
insert into producto values(2,"Traje de Mikey","Mikey god","mikey.webp", 50, 0, true);
insert into producto values(3,"Traje de Eevee","Miau","evee.jpg", 100, 0, true);
insert into producto values(4,"Traje de Woki","Woki woki <3","woki.jpg", 100, 0, true);
insert into producto values(5,"Galletas Shin Chan","Las mejores galletas para el mejor gato","shinchan.png", 10, 1, true);
insert into producto values(6,"Lejía","Lo que no te mata...","lejia.jpg", 25, 1, true);

insert into productoUsuario values(1,1,1);
insert into productoUsuario values(1,2,1);
insert into productoUsuario values(1,3,1);
insert into productoUsuario values(1,4,10);

insert into accionEquipable values(1,1);
insert into accionEquipable values(2,2);
insert into accionEquipable values(3,3);
insert into accionEquipable values(4,4);

insert into daily values(1,0,0,0);
insert into daily values(2,0,0,0);
insert into daily values(3,0,0,0);
insert into daily values(4,0,0,0);

insert into efecto values(1, 4, 'RECARGAR', 0, 5);
insert into efecto values(2, 5, 'GASTAR', 0, 5);
insert into efecto values(5, 5, 'MULTIPLICADOR', 0, 2);


-- Desarrollo



/*
-- Consulta productos tienda por usuario;
select * from producto where idProducto not in (
	select p.idProducto from productousuario p
	join producto prod  ON prod.idProducto = p.idProducto
	where prod.tipo = 0 and id = 2
);

select u.username, p.perfil from UsuarioPerfil up 
					inner join Usuarios u on u.id = up.idUsuario 
					inner join Perfiles p on p.id = up.idPerfil 
					where u.username = "pablo";
					
SELECT username, password, estatus from Usuarios where username="pablo";
*/
