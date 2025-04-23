select nombre from futbolistas;
select posicion from futbolistas;
select distinct posicion from futbolistas;
select * from partidos;
select estadio "Estadio" , id_equipo_casa "ID local" from partidos;
select distinct posicion "Demarcaciones" from futbolistas;
select * from futbolistas;
select * from futbolistas order by 2;
select apellidos from futbolistas where posicion = 'DEFENSA' order by apellidos desc;
select * from futbolistas order by posicion, apellidos;

describe dual;
select * from dual;
select 5*4 "Resultado" from dual;
select nombre from futbolistas where nombre like 'P%';
select nombre from futbolistas where nombre like '_E%';
select nombre from futbolistas where salario >= 150000;
select id from futbolistas where apellidos = 'GOMEZ';
select apellidos from futbolistas where apellidos like 'G%';
select posicion from futbolistas where posicion in ('DEFENSA','POSICION');
select nombre from futbolistas where salario between 100000 and 200000;
select nombre,apellidos,salario*1.10 "Nuevo 
salario" from futbolistas where posicion = 'PORTERO' order by apellidos;
select 'Hola' || sysdate from dual;
select 'La posicion del futbolista ' || nombre ||  ' es ' || posicion from futbolistas;
select * from futbolistas where  salario > 150000 and posicion = 'DEFENSA';
select futbolistas.nombre || ' juegan en  ' || equipos.nombre from futbolistas,equipos where id_equipo = equipos.id;
SELECT nombre,salario,salario*1.5 || 'euros' "Salario bruto" from futbolistas;
select concat(concat(id,' '),concat (nombre || ' ', apellidos)) "Ejemplo concat" from futbolistas; 