create table recintos(
    nombre varchar2(50) primary key,
    capacidad number (6,2),
    direccion varchar2 (50),
    localidad varchar2(100)
);
create table equipos(
    referencia char(5) primary key,
    nombre varchar2(50),
    ano_funcion int,
    localidad varchar2(100),
    nombre_recinto varchar2(50)
);
create table trabajadores(
    Dni char(9) primary key,
    nomre varchar2(50),
    apellidos varchar2(100),
    cod_equipo char(5),
    dorsal_jugador Integer,
    fecha_nacimiento_jugador date,
    tipoTrabajador varchar2(50),
    esAuxiliar char(2),
    esFisico char(2)
);
Create table encuentros(
    id Integer primary key,
    Equipo_local char(5),
    equipo_visitante char(5),
    resultado char(5)
);
create table disputas_encuentro_jugador(
    id_encuentro Integer,
    dni_empleado_jugador char(9),
    minutos int,
    puntuacion Integer,
    primary key (id_encuentro,dni_empleado_jugador)
);
alter table disputas_encuentro_jugador add constraint pk_disputas primary key (id_encuentro,dni_emprleado_jugador);
create table jueces(
    id Integer primary key,
    federacion varchar2(50),
    nombre varchar2(50),
    apellidos varchar2(100),
    fecha_nacimiento date
);
create table jueces_encuentros(
    id_juez Integer,
    id_encuentro Integer,
    primary key (id_juez,id_encuentro)
);
alter table jueces_encuentros add constraint pk_jueces primary key (id_juez,id_encuentro);
alter table equipos add constraint fk_equipos foreign key (nombre_recinto) references recintos(nombre_recintos);
alter table trabajadores add constraint fk_trabajadores foreign key (cod_equipo) references equipos (cod_equipos);
alter table encuentros add constraint fk_encuentros foreign key (equipo_local) references equipos (equipo_local);
alter table encuentros add constraint fk_encuentros2 foreign key (equipo_visitante) references equipos (equipo_visitante);
alter table disputas_encuentro_jugador add constraint fk_disputas2 foreign key (id_encuentro) references encuentros (id);
alter table disputas_encuentro_jugador add constraint fk_disputas3 foreign key (dni_empleado_jugador) references trabajadores (dni);
alter table jueces_encuentros add constraint fk_jueces2 foreign key (id_juez) references jueces (id);
alter table jueces_encuentros add constraint fk_jueces2 foreign key (id_encuentro) references encuentros (id);

alter table equipos add column nombre_fundador date;
alter table equipos modify nombre_fundador char(9);
alter table equipos rename column nombre_fundador to dni_fundador;
alter table equipos add constraint fk_dni_fundador foreign key (dni_fundador) references trabajadores (dni);
alter table equipos rename constraint fk_dni_fundador to fk_fundador_trabajadores_dni;
alter table equipos drop constraint fk_fundador_trabajadores_dni;
alter table equipos drop column dni_fundador;
alter table equipos rename equipos to clubes;


