--1.1
create table EMPRESAS(
    id int primary key,
    nombre_empresa varchar2(100),
    direccion varchar2(100),
    telefono varchar2(50),
    nif_club_pertenece char(9)
);
alter table empresas add constraint fk_nif foreign key (nif_club_pertenece) references clubes(nif);
--1.2
insert into empresas values (5,'asociacion deporte sl', 'Glorieta real 2',null,'C24154935');
insert into empresas values (6,'ferreteria perez','Principal 33',null,'C31006310');
insert into empresas values (7,'club deportivo gomez',null,'+34111222333','C52766652');
insert into empresas values (8,'complementos alimentarios',null,'123456789','C32808221');
--1.3
update empresas set telefono = '+34640530630' where nombre_empresa = 'asociacion deporte sl';
update empresas set nif_club_pertenece = 'C21767463' where nombre_empresa = 'asociacion deporte sl';
--1.4
delete from empresas where nombre_empresa = 'ferreteria perez';
--2.1
select dorsal from carreras_participan_atletas where mod(dorsal,2) = 0 order by dorsal desc;
--2.2
select initCap(nombre) from entrenamientos where duracion = 39 and dureza in (4,5);
--2.3
select sum(to_number(substr(tiempo,4,2))) from carreras_participan_atletas where codigo_carrera = (select codigo from carreras where nombre = 'Marcha solidaria');
--2.4
select upper(nombre) from clubes where nif = (select nif_club from atletas where fecha_nacimiento = (select max(fecha_nacimiento) from atletas));
--2.5
select DNI,nombre from atletas where atletas.fecha_nacimiento = (select min(fecha_nacimiento) from atletas);
--2.6
select localidad from carreras;
--2.7
select upper(to_char(carreras.f_fin_inscrip,'MONTH'))"MES inicio",upper(to_char(carreras.f_fin_inscrip,'DAY'))"DIA fin" from carreras where localidad != 'MADRID';
--2.8
select atletas.nombre from atletas join atletas_realizan_entrenamientos on atletas_realizan_entrenamientos.dni_atleta = atletas.dni join entrenamientos on entrenamientos.id = atletas_realizan_entrenamientos.id_entrenamiento where atletas_realizan_entrenamientos.dni_atleta = (select dni from atletas);
select nombre from atletas where dni = (select dni_atleta from atletas_realizan_entrenamientos);
--2.9
select * from clubes where clubes.responsable like ('%García%') and clubes.nif like('%8%');
--2.10
select nombre,apellidos,numatletas.num_victorias_profesional from atletas where ;
select count(*) from atletas join carreras_participan_atletas on carreras_participan_atletas.dni_atleta = atletas.dni join carreras on carreras.codigo = carreras_participan_atletas.codigo_carrera where;
select * from carreras;
select nombre from atletas where dni = (select dni_atleta from carreras_participan_atletas);
--2.11
select nombre,apellidos,length(apellidos)"Num. caracteres",num_victorias_profesional from atletas where num_victorias_profesional = (select max(num_victorias_profesional) from atletas);
--2.12
select clubes.nombre,count(*) from atletas join clubes on clubes.nif = atletas.nif_club group by nif_club,clubes.nombre having count(*)<2 order by count(*) asc,clubes.nombre desc;
/*al no tener con que compararlo no se si es lo que pides pero las condiciones pedidas estan hecha*/
--2.13
select atletas.nombre,atletas.apellidos,atletas.fecha_nacimiento from atletas where nif_club = (select nif from clubes where nombre = 'Club Sevilla 2')order by fecha_nacimiento desc;
--2.14
select apellidos ||','|| nombre from atletas where num_victorias_profesional >= 25;
--2.15
select entrenamientos.nombre from entrenamientos join atletas_realizan_entrenamientos on atletas_realizan_entrenamientos.id_entrenamiento = entrenamientos.id join atletas on atletas.dni = atletas_realizan_entrenamientos.dni_atleta where atletas.dni = (select dni_atleta from atletas_realizan_entrenamientos where id_entrenamiento = (select id from entrenamientos)) and nif_club = (select nif from clubes where nombre = 'Madrid sport' ) group by entrenamientos.nombre;
select * from atletas where nif_club = (select nif from clubes where nombre = 'Madrid sport' );
select * from clubes;
--2.16
select count(*)"Total" from atletas where nif_club = (select nif from clubes where nombre = 'Triana Club Deportivo');
--3.1
set serveroutput on;
declare
 fecha date := '&Introduzca_fecha';
begin
dbms_output.put_line(fecha);
end;
/
--3.2
declare
 type misAtletas is record(
 fecha_nacimiento atletas.fecha_nacimiento%type,
 nombre atletas.nombre%type
 );
 datosAtletas misAtletas;
begin
dbms_output.put_line(':)');
end;
/
--3.3 y 3.4 y 3.5
declare
fecha atletas.fecha_nacimiento%type := '&Introduzca_fecha';
 type misAtletas is record(
 fecha_nacimiento atletas.fecha_nacimiento%type,
 nombre atletas.nombre%type
 );
 datosAtletas misAtletas;
 fechas atletas.fecha_nacimiento%type;
 contador int;
 nombreCarrera varchar2(100);
begin
select count(*) into contador from atletas where fecha_nacimiento = fecha;

if contador = 1 then
select carreras.nombre into nombreCarrera from carreras where codigo = (select codigo_carrera from carreras_participan_atletas where dni_atleta = (select dni from atletas where fecha_nacimiento = fecha));
loop
dbms_output.put_line(nombreCarrera);
exit when nombreCarrera = '';
end loop;
elsif contador >1 then
dbms_output.put_line('Hay mas de un atleta con la fecha, concreta una fecha de nacimiento que sea unica ');
else
dbms_output.put_line('No hay atletas con la fecha de nacimiento ' || fecha);
end if;
end;
/
select nombre from carreras where codigo = (select co);