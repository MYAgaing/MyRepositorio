create table alumnos (
    nombre varchar2(50) primary key,
    apellido varchar2(50),
    localidad varchar2(50),
    primary key(nombre)
);
alter table alumnos add constraint id_nombre primary key (nombre);
--siguiente tabla
create table profesor (
    nombre varchar2(50),
    apellido varchar2(50),
    localidad varchar(50),
    fecha_nacimiento date,
    edad number(5)
);
alter table profesor add constraint id_nombre primary key (nombre);
alter table profesor drop constraint id_nombre;
