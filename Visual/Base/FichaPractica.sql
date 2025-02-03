--crear una tabla
create table tabla(
    --poner campos
    --campo caracteres
    nombre varchar2(50),
    numero int, --numeros enteros
    numeros number(4 , 2), --numeros normales y decimales
    fecha date, --datatype fecha
    numer char(50),
    numeroide nvarchar2(50),
    caracteres char(50)
);
alter table tabla 
    add atributo varchar2(50);--crea un atributo en la tabla
alter table tabla
    drop column columna;--borra la columna de la tabla
alter table tabla
    rename column columna to columnas;--cambia el nombre de la columna
drop table tabla cascade constraint;--borra una tabla y sus restrigciones
create table restricciones(
    DNI varchar2(50) primary key,--crea una primary key
    Nombre varchar2(50),
    constraint claveprimaria primary key (DNI),--otra forma de hacer primary key
    foreign key (Nombre) references tabla (Nombre)--otra forma de hacer foreign key
);
alter table restricciones add primary key (DNI);--otra forma de primry key
alter table restricciones add constraint nombreRestriccion primary key (DNI);--otra forma de primary key
alter table restricciones add foreign key (Nombre) references/*aqui es donde es pk*/ tabla (Nombre);--Una forma de hacer foreign key
alter table resticciones add constraint nombreRestriccion foreign key (Nombre) references tabla (Nombre);--otra forma de hacer foreign key 
alter table restricciones drop constraint nombreRestriccion;--como borrar una restriccion sea Pk o Fk
alter table restricciones rename constraint nombreRestriccion to nombrerestriccion;--renombrar una restriccion
create table condiciones(
    ID varchar2(50),
    nombre varchar2(50),
    numero int
);
alter table condiciones add constraint edadAlumnos check(numero>=18);--restringe a que el campo numero sea igual o mayor a 18
alter table condiciones add constraint edadAlumnos check(regexp_like(ID, '[0-9]'*{8},'[a-Z]'));--crear una restriccion para que los 8 primeros seand numero del 0 al 9 y el ultimo de a a la z mayus o minus
alter table condiciones add check (nombre in ('Tornillo','Arandela','Tuerca'));--hacer que un campo se escriba en concreto algo

drop table agencias cascade constraints;
create table agencias (
    id int primary key,
    direccion varchar2(100),
    telefono char(13),
    nombre varchar2(50),
    num_empleados int
);
insert into agencias (id,direccion,telefono,nombre,num_empleados)
    values(1,'doctor barnard','+34640530630','Nicolas',3);
    
insert into agencias (id,nombre) values (2,'Nueva bormujos');
insert into agencias values (4,'Avda. italia 4','+34640530633',null,10);