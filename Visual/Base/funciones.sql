   set serveroutput on;
create or replace function mifuncion return varchar2 is
begin
   return 'Hola';
end;
/


begin
   mifuncion;
end;
/

create or replace function departametonombre (
   v_name in dept.dname%type
) return int is
   nombre dept.dname%type;
begin
   select deptno
     into nombre
     from dept
    where dname = v_name;
   return nombre;
exception
   when no_data_found then
      dbms_output.put_line('No hay datos');
      return -1;
end;
/

declare
   resultador dept.dname%type := '&DNAME';
begin
   departametonombre('SALES');
end;
/
UNDEFINE DNAME;

create or replace function datofecha (
   fecha        in date,
   datoamostrar in varchar2
) return varchar2 is
begin
   if datoamostrar = 'DIA' then
      return to_char(
         fecha,
         'DAY'
      );
   elsif datoamostrar = 'MES' then
      return to_char(
         fecha,
         'MONTH'
      );
   else
      return 'No es correcto';
   end if;
end;
/

begin
   dbms_output.put_line(datofecha(
      sysdate,
      'DAY'
   ));
   dbms_output.put_line(datofecha(
      '01/01/2025',
      'MONTH'
   ));
   dbms_output.put_line(datofecha(
      '31/12/2025',
      'DAY'
   ));
end;
/

create or replace function nombreestudiante (
   v_codigo in estudiantes.codigo%type
) return varchar2 as
   resultador  varchar2(50);
   v_nombre    varchar2(50);
   v_apellidos varchar2(50);
begin
   select nombre,
          apellidos
     into
      v_nombre,
      v_apellidos
     from estudiantes
    where codigo = v_codigo;
   resultador := v_nombre
                 || ' + '
                 || v_apellidos;
   return resultador;
exception
   when no_data_found then
      dbms_output.put_line('No existe el alumno');
      return null;
end;
/

begin
   if nombreestudiante(6) is not null then
      dbms_output.put_line(nombreestudiante(6));
   end if;
end;
/

create or replace function totalestudiantes return int as
   contador int;
begin
   select count(*)
     into contador
     from estudiantes;
   return contador;
end;
/

declare
   resultado int := totalestudiantes;
begin
   dbms_output.put_line(resultado);
end;
/