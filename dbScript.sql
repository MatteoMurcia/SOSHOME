create database soshome;

use soshome;

create table cliente (
cedulac varchar(255),
nombre varchar (255),
apellido varchar (255),
clave varchar(255),
genero varchar(255),
telefono varchar(255),
calificacion integer, 
correo varchar(255),
direccion varchar(255),
primary key (cedulac)

);



create table proveedor (
cedulap varchar(255),
nombre varchar (255),
apellido varchar (255),
clave varchar(255),
genero varchar(255),
telefono varchar(255),
calificacion integer, 
correo varchar(255),
localidad varchar(255),
profesion varchar(255),
primary key (cedulap)

);

create table servicio (

nombres varchar(255),
idservice varchar(255),
cedulac varchar(255),
descripcion varchar(255),
fecha date,
primary key (idservice),
foreign key (cedulac) references cliente (cedulac)
);

create table listaenviados(
id integer,
idservice varchar(255),
cedulap varchar(255),
primary key (id),
foreign key (idservice) references servicio (idservice),
foreign key (cedulap) references proveedor (cedulap)
);



create table cotizacion (

idcoti varchar(255),
cedulap varchar(255),
estado varchar(255),
estimaciontiempo varchar(255),
comentario varchar(255),
idservice varchar(255),
foreign key (idservice) references servicio (idservice),
primary key (idcoti),
foreign key (cedulap) references proveedor (cedulap)

);

create table materiales (

idmaterial varchar(255),
idcoti varchar(255),
cedulac varchar(255),
material varchar(255),
cantidad varchar (255),
valor integer,
primary key (idmaterial),
foreign key (cedulac) references cliente (cedulac),
foreign key (idcoti) references cotizacion (idcoti)
);

insert into cliente(cedulac,nombre,apellido,clave,genero,telefono,calificacion,correo,direccion) values
('2347850910','mario','casas','123','masculino','3008219077',5,'ejemplo@prueba.com','cra 1 no 32 b 51'),
('2347850500','maria','molina','1234','femenino','300820000',4,'ejemplo2@prueba.com','cll6 34 12 '),
('2347859000','jose','perez','12345','masculino','3118219000',3,'ejemplo3@prueba.com','av 13 no 34 63 ');

insert into proveedor(cedulap,nombre,apellido,clave,genero,telefono,calificacion,correo,localidad,profesion)values
('2347849484','fernando','lorenz','321','masculino','300800000',5,'ejemplo4@prueba.com','chapinero','carpinteria'),
('2347868494','diana','alvarez','4321','femenino','300824567',3,'ejemplo5@prueba.com','suba','carpinteria'),
('2347850911','claudia','rodriguez','54321','femenino','300875849',4,'ejemplo6@prueba.com','fontibon','carpinteria');

