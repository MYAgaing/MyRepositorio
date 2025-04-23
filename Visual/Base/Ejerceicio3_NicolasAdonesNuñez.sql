create table tiendas(
    id int,
    fundador varchar2(100),
    localidad varchar2(50),
    pais varchar2(50),
    num_productos int,
    precuo_medio number(6,2),
    telefono char(14)
);
create table dependientes (
    dni char(9),
    nombre varchar2(50),
    primer_apellido varchar2(50),
    segundo_apellido varchar2(50),
    f_nacimiento date,
    puesto varchar2(50),
    id_tienda int
);
alter table tiendas add constraint pk_tiendas primary key id;