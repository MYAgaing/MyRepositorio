create or replace package paquete1 is
   procedure reset_cot (
      v_nuevo_cont number
   );

   function devolver_cont return number;

end paquete1;

create or replace package operaciones is
   function suma (
      num1 int,
      num2 int
   ) return int;
   function resta (
      num1 int,
      num2 int
   ) return int;
   function positivo (
      num1 int
   ) return varchar2;
end operaciones;


create or replace package body operaciones is
   function suma (
      num1 int,
      num2 int
   ) return int is
   begin
      return num1 + num2;
   end suma;
   function resta (
      num1 int,
      num2 int
   ) return int is
   begin
      return num1 - num2;
   end resta;
   function positivo (
      num1 int
   ) return varchar2 is
   begin
      if num1 >= 0 then
         return 'Es positivo';
      elsif num1 < 0 then
         return 'Es negativo';
      end if;
   end positivo;
end operaciones;
/

declare
   suma     int;
   resta    int;
   positivo varchar2(50);
begin
   suma := operaciones.suma(
      5,
      2
   );
   dbms_output.put_line(suma);
   resta := operaciones.resta(
      2,
      5
   );
   dbms_output.put_line(resta);
   positivo := operaciones.positivo(5);
   dbms_output.put_line(positivo);
end;
/

create or replace package gestionemp is
   procedure nuevoempleado (
      emp emp
   );
end gestionemp;

create or replace package body gestionemp is
   procedure nuevoempleado (
      id           emp.empno%type,
      nombre       emp.ename%type,
      puesto       emp.job%type,
      jefe         emp.mgr%type,
      fecha        emp.hiredate%type,
      salario      emp.sal%type,
      comision     emp.comm%type,
      departamento emp.deptno%type
   ) is
      num int;
   begin
      select count(empno)
        into num
        from emp
       where empno = id;
      insert into emp values ( id,
                               nombre,
                               puesto,
                               jefe,
                               fecha,
                               salario,
                               comision,
                               departamento );
      dbms_output.put_line('Insertado correctamente');
   end;
end gestionemp;