create or replace package misfunciones is
   function cuentavocales (
      palabra varchar2
   ) return int;
   procedure mostrarempmas1vocal;
end misfunciones;

create or replace package body misfunciones is
   function cuentavocales (
      palabra varchar2
   ) return int is
      contadorvocales int := 0;
      letra           char(1);
   begin
      for i in 1..length(palabra) loop
         letra := substr(
            palabra,
            i,
            1
         );
         if lower(letra) in ( 'a',
                              'e',
                              'i',
                              'o',
                              'u' ) then
            contadorvocales := contadorvocales + 1;
         end if;
      end loop;
      return contadorvocales;
   end;

   procedure mostrarempmas1vocal is
   begin
      for fila in (
         select ename
           from emp
      ) loop
         if cuentavocales(fila.ename) > 1 then
            dbms_output.put_line(fila.ename);
         end if;
      end loop;
   end;
end misfunciones;
/



begin
   dbms_output.put_line(misfunciones.cuentavocales('pruebaaaaaaaop'));
   misfunciones.mostrarempmas1vocal;
end;

create or replace package micrud is
   function insertar (
      dept dept%rowtype
   ) return varchar2;

   function actualizar (
      dept dept%rowtype
   ) return varchar2;

   function eliminar (
      pk dept.deptno%type
   ) return varchar2;
end;
/