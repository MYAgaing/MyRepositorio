select *
  from asignaturas;

   set serveroutput on;

declare
   midescripcion asignaturas.descripcion%type;
   num           int := 4;
   miexcepcion exception;
begin
   if num > 5 then
      raise miexcepcion;
   else
      raise_application_error(
         -20001,
         'Error personalizado',
         true
      );
   end if;
--select descripcion into miDescripcion from asignaturas where codigo = 11;
--dbms_output.put_line(miDescripcion);
--select descripcion into miDescripcion from asignaturas where codigo = 11;
--dbms_output.put_line(miDescripcion);
--dbms_output.put_line(4/0);
exception
   when no_data_found then
      dbms_output.put_line('No hay datos');
   when too_many_rows then
      dbms_output.put_line('Demasiadas lineas');
   when zero_divide then
      dbms_output.put_line('No se divide entre cero');
   when others then
      dbms_output.put_line('Error');
end;
/
--ejercicio1
declare begin
   dbms_output.put_line(4 / 0);
exception
   when others then
      dbms_output.put_line(sqlcode
                           || ' '
                           || substr(
         sqlerrm,
         11,
         length(sqlerrm)
      ));
end;
/

declare
   num_estudiantes int;
   no_alumnos exception;
   muchos_alumnos exception;
begin
   select count(*)
     into num_estudiantes
     from estudiantes;

   if num_estudiantes = 0 then
      raise no_alumnos;
   elsif num_estudiantes >= 5 then
      raise muchos_alumnos;
   else
      dbms_output.put_line(num_estudiantes);
   end if;

exception
   when no_alumnos then
      dbms_output.put_line('No hay alumnos');
   when muchos_alumnos then
      dbms_output.put_line('HAY muchos alumnos');
end;
/
--Boletín ejercicios con excepciones
--1 Pide al usuario que introduzca un código de asignatura y muestra el código junto al curso y descripción. Controla las siguiente excepciones mostrando un mensaje de error: no existe ese código en la tabla asignaturas.
   set SERVEROUTPUT on;
declare
   no_existe exception;
   codige   asignaturas.codigo%type := &codige;
   cursor codigo_asig is
   select *
     from asignaturas
    where codigo = codige;
   contador int;
begin
   for rec in codigo_asig loop
      if rec.codigo = codige then
         dbms_output.put_line(rec.codigo
                              || ' '
                              || rec.curso
                              || ' '
                              || rec.descripcion);
         contador := contador + 1;
      end if;
   end loop;
   if contador = 0 then
      raise no_existe;
   end if;
exception
   when no_existe then
      dbms_output.put_line('No existe ese código de asignatura');
end;
/
UNDEFINE codige;



--2 Se quiere pedir al usuario que introduzca un nivel de curso (primer curso o segundo), introduciendo 1 o 2 por teclado. Una vez se meta el nivel, muestra por la salida todas las descripciones de las asignaturas de ese nivel. Excepciones a tener en cuenta mostrando un mensaje de error: el nivel no es un número válido y el número no existe en la tabla asignaturas. NOTA: para saber si han introduciendo un número, puedes controlarlo con la excepción value_error a la que se accede cuando se produce un error en una conversión (por ejemplo al llamar a to_number() y no puede hacer la conversión).

declare
   invalido exception;
   nivel varchar2(100) := '&nivel';
   cursor c1 is
   select *
     from asignaturas
    where curso = nivel;
begin
   nivel := to_number ( nivel );
   if
      nivel > 0
      and nivel < 2
   then
      for rec in c1 loop
         dbms_output.put_line(rec.descripcion);
      end loop;
   else
      raise invalido;
   end if;
exception
   when value_error then
      dbms_output.put_line('Introduce un numero no una letra');
   when invalido then
      dbms_output.put_line('El nivel no existe');
end;
/
UNDEFINE nivel;

--3 Se quiere una lista donde se muestre el curso y cuántas asignaturas hay en ese curso (una línea por cada curso). Ejemplo: Curso 1: 4 asignaturas. Excepciones a tener en cuenta: crea una excepción personalizada llamada cursoConRedes de forma que si el curso tiene la asignatura con descripción "Redes" no debes mostrarlo por pantalla, terminando la ejecución de tu código y mostrando en tu excepción el siguiente mensaje: "No se puedes mostrar datos porque existe la asignatura de Redes".

declare
   cursor c1 is
   select curso,
          count(curso)
     from asignaturas
    group by curso;
   cursoconredes exception;
   existeredes asignaturas.codigo%type;
begin
   select codigo
     into existeredes
     from asignaturas
    where descripcion = 'Redes';
   for rec in c1 loop
      dbms_output.put_line('Curso '
                           || rec.curso
                           || ': '
                           || rec.cantidad);
   end loop;

exception
   when no_data_found then
      for rec in c1 loop
         dbms_output.put_line('Curso '
                              || rec.curso
                              || ': '
                              || rec.cantidad);
      end loop;
   when cursoconredes then
      dbms_output.put_line('No se pueden mostrar datos porque existe la asignatura de Redes');
end;
/


--4 Se quiere mostrar por la salida el nombre de cada asignatura y la nota media obtenida en las matrículas de esa asignatura por parte de los alumnos. Excepciones a tener en cuenta: crea una excepción personalizada menosDeCinco que, una vez mostradas todas las notas media, si alguna tiene un valor menor a cinco, llamar a esa excepción personalizada indicando el mensaje "Hay alguna asignatura con una media inferior a cinco".

declare
   cursor c1 is
   select descripcion,
          avg(nota) as nota_media
     from matriculas
     join asignaturas
   on matriculas.cod_asignatura = asignaturas.codigo
    group by descripcion;
   menosdecinco exception;
begin
   for f1 in c1 loop
      if f1.nota_media < 5 then
         raise menosdecinco;
      else
         dbms_output.put_line(f1.descripcion
                              || ': '
                              || f1.nota_media);
      end if;
   end loop;
exception
   when menosdecinco then
      dbms_output.put_line('Hay alguna asignatura con una media inferior a 5');
end;
/


--5 Modifica el ejercicio 4 para mostrar por la salida solo las asignaturas que tienen una media superior a 5. A continuación, si has mostrado una o más asignaturas con una media con decimales, llama a una excepción personalizada tienenDecimales que muestre todas esas asignaturas con decimales, separadas por coma. 


declare
   cursor c1 is
   select descripcion,
          avg(nota) as nota_media
     from matriculas
     join asignaturas
   on matriculas.cod_asignatura = asignaturas.codigo
    group by descripcion;
   menosdecinco exception;
   tienedecimales exception;
   notamedia int;
begin
   for f1 in c1 loop
      if f1.nota_media != trunc(f1.nota_media) then
         notamedia := f1.nota_media;
         raise tienedecimales;
      else
         dbms_output.put_line(f1.descripcion
                              || ': '
                              || f1.nota_media);
      end if;
   end loop;
exception
   when menosdecinco then
      dbms_output.put_line('Hay alguna asignatura con una media inferior a 5');
   when tienedecimales then
      dbms_output.put_line(notamedia);
end;
/



--6 Se quiere pedir por teclado el código de una asignatura. Muestra una lista de todos los alumnos que están matriculados (dni y nombre de los almnos) y la nota que han sacado. Ten en cuenta las siguientes excepciones: el código de asignatura es un número, existe en la tabla asignaturas y además hay matrículas de alumnos en esa asignatura. Para esa última excepción, crea una excepción personalizada que se llame noMatriculas.

/*drop table candidates cascade constraints;
create table candidates (
   candidate_id int,
   skill        varchar2(100)
);
insert into candidates values ( 123,
                                'Python' );
insert into candidates values ( 123,
                                'Tableau' );
insert into candidates values ( 123,
                                'PostgreSQL' );
insert into candidates values ( 234,
                                'R' );
insert into candidates values ( 234,
                                'PowerBI' );
insert into candidates values ( 234,
                                'SQL Server' );
insert into candidates values ( 345,
                                'Python' );
insert into candidates values ( 345,
                                'Tableau' );
commit;
select *
  from candidates
 where skill in ( 'Python',
                  'PostgreSQL',
                  'Tableu' )
 group by candidate_id
having count(skill) = 3
 order by candidate_id asc;*/