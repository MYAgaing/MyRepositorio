--BBDD: motociclismo.sql
 
--Ejercicio 2.
 
--2.1 ¿Cuántos pilotos pertenecen a los equipos 'Equipo Honda'? Recuerda que son Equipo Honda 1 y Equipo Honda 2. Devuelva la cuenta total de los dos equipos en un único valor.
select count(*)
  from pilotos
  join equipos
on codigo = pilotos.id_equipo
 where equipos.nombre like 'Equipo Honda%';
--2.2 Se quiere saber cuál es la marca de neumáticos y nombre de motor que usan menos equipos (la menor cantidad posible de equipos). Ordena el resultado por marca de la Z a la A.
select marca,
       motores.nombre,
       count(*)
  from equipos
  join motores
on ref = id_motor
  join neumaticos
on id = id_neumatico
 group by marca,
          motores.nombre
having count(*) = (
   select min(count(*))
     from equipos
    group by id_motor,
             id_neumatico
)
 order by 1 desc;
--2.3 Se quiere saber el nombre del piloto, sin repetir, y con alias de columna "Piloto" para aquellos pilotos que tengan más de 10 victorias y cuya nacionalidad sea "Español". Devuelve ese nombre de piloto en minúsculas.
select distinct lower(nombre)
  from pilotos
 where num_victorias > 10
   and nacionalidad = 'Español';
--2.4 ¿Cuál es el nombre del mes y el año de la fecha de nacimiento del piloto que está en el equipo 'Equipo Suzuki 1'? No uses join, solo subconsultas. Usa como alias "MES-AÑO". Ej.: ABRIL-2003.
select trim(to_char(
   fecha_nacimiento,
   'month'
))
       || '-'
       || to_char(
   fecha_nacimiento,
   'yyyy'
) "MES-AÑO"
  from pilotos
 where id_equipo = (
   select codigo
     from equipos
    where nombre = 'Equipo Suzuki 1'
);
alter session set nls_language = 'SPANISH';
--2.5 Devuelve el nombre y los apellidos, ambos en mayúsculas, de los pilotos que no tienen equipo.
select upper(nombre),
       upper(apellidos)
  from pilotos
 where id_equipo is null;
--2.6 Indica el nombre del piloto concatenado con el número de letras del segundo apellido de ese piloto que cumple que tiene el SEGUNDO APELLIDO de menor número de letras de todos los pilotos.
select nombre
       || ': '
       || length(substr(
   apellidos,
   instr(
      apellidos,
      ' '
   ) + 1,
   length(apellidos) - instr(
      apellidos,
      ' '
   )
))
  from pilotos
 where length(substr(
   apellidos,
   instr(
      apellidos,
      ' '
   ) + 1,
   length(apellidos) - instr(
      apellidos,
      ' '
   )
)) = (
   select min(length(substr(
      apellidos,
      instr(
         apellidos,
         ' '
      ) + 1,
      length(apellidos) - instr(
         apellidos,
         ' '
      )
   )))
     from pilotos
);
--2.7 Indica el valor medio de la distancia de kms de las carreras agrupado por el año de la fecha.
select to_char(
   fecha,
   'yyyy'
),
       avg(distancia_km)
  from carreras
 group by to_char(
   fecha,
   'yyyy'
);
--2.8 Devuelve todos los campos de la tabla motores de aquellas filas que tienen en la cuarta letra de su nombre la "a". Ordena por la potencia de mayor a menor.
 select * from motores where substr(nombre,4,1) = 'a' order by potencia desc;
--2.9 Indica el nombre del piloto y la fecha del entrenamiento de aquel piloto que no tiene equipo y además la fecha es la más reciente.
 select * from pilotos join PILOTOS_ENTRENAMIENTOS on PILOTOS_ENTRENAMIENTOS.ID_PILOTO;
--2.10 Indica la posición en la que ha quedado un piloto de nacionalidad española en el circuito de Cataluña.
 select posicion from PILOTOS_CARRERAS join pilotos on pilotos.id = id_piloto join carreras on carreras.id = id_carrera where nacionalidad = 'Español' and carreras.CIRCUITO = 'Cataluña';
--2.11 ¿Cuál es el nombre de los motores que usan equipos que tienen un presupuesto que está entre 24000000 y 26000000?
 select motores.nombre from equipos join motores on ref = equipos.id_motor where presupuesto > 24000000 and presupuesto < 26000000;
--2.12 Devuelve el nombre del país y el número de letras i que tiene ese nombre (tabla neumáticos). Ejemplo: Italia tiene 2 letras i.
 select pais || ' tiene ' || (length(pais) - length(replace(pais,'i',''))) || ' Letras i' from neumaticos;
--2.13 ¿Cuál es la marca del motor que usa el equipo que se encuentra en la localidad de Madrid, y el país del motor es Japón? Devuelve la marca con todas sus letras en mayúsculas.
 select upper(motores.nombre) from EQUIPOS join motores on ref = id_motor where localidad = 'Madrid' and pais = 'Japón';
--2.14 Devuelve la resta de la suma de salarios de pilotos españoles menos la suma de los salarios de pilotos italianos.
 select (select sum(salario) from pilotos where nacionalidad = 'Español') -  (select sum(salario) from pilotos where nacionalidad = 'Italiano') from dual;
--2.15 Devuelve el nombre y el responsable del equipo cuando el responsable tiene en su segunda letra una vocal. Devuelve el nombre del equipo en mayúsculas.
 select nombre,responsable from equipos where responsable like '_a%' or responsable like '_e%' or responsable like '_i%' or responsable like '_o%' or responsable like '_u%';
 select upper(nombre), responsabre from equipos where substr(responsabre,2,1) in ('a','e','o','i','u');
--2.16 Devuelve todos los campos de los pilotos cuyo nacimiento sea entre el 12 de marzo de 1994 y el 31 de marzo de 1995.
 select * from pilotos where FECHA_NACIMIENTO BETWEEN '1994-03-12' and '1995-03-31';
--Ejercicio 3.
 
--Se quiere un bloque de código anónimo en plsql que realice lo siguiente: 3.1 Pide que el usuario introduzca dos salarios por teclado. 3.2 Solo vamos a admitir que el salario segundo sea mayor que el primero. En caso contrario, muestra el mensaje "El primer salario debe ser menor que el segundo". 3.3 Si no hay pilotos que tengan un salario entre los valores anteriores, mostrar el mensaje "No hay pilotos". 3.4 Si hay pilotos que tengan un salario entre los valores introducidos, muestra el nombre en mayúsculas de todos los pilotos que lo cumplen. 3.5 Si hay pilotos que tengan un salario entre los valores introducidos, y ya has mostrado todos los nombres de los pilotos, muestra el mensaje "Hay un total de AAA pilotos con diferente salario", siendo AAA el número total de pilotos que NO están en eses caso.
set serveroutput on;
DECLARE
salario1 pilotos.salario%type := &salario1;
salario2 pilotos.salario%type := &salario2;
contador int;
idMin pilotos.ID%TYPE;
idMax pilotos.id%TYPE;
BEGIN
    if salario2 > salario1 then
    select count(*) into contador from pilotos where salario between salario1 and salario2;
        if contador > 0 THEN
        select min(id),max(id) into idmin,idMax from pilotos;
        FOR i IN idmin..idMax LOOP
        select nombre,salario into nombrePiloto,salarioPiloto from pilotos where id = i;
        if salarioPiloto between salario1 and salario2 THEN
        dbms_output.put_line(UPPER(nombrePiloto));
        end if;
        dbms_output.put_line(salario1);
    end loop;
    else 
        dbms_output.put_line('No hay piloto');
    end if;
end;
/
UNdefine salario1;
UNDEFINE salario2;