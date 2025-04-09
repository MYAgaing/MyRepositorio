--Boletín ejercicios con cursores
--1 Se quiere visualizar el nombre y la fecha de alta de todos los empleados, ordenados por el nombre de Z a A.
   set SERVEROUTPUT on;

declare
   cursor c_empleados is
   select ename,
          hiredate
     from emp
    order by ename desc;
begin
   for r_empleado in c_empleados loop
      dbms_output.put_line('Nombre: '
                           || r_empleado.ename
                           || ' - Fecha de Alta: '
                           || to_char(
         r_empleado.hiredate,
         'DD-MON-YYYY'
      ));
   end loop;
end;
/

--2 Encuentra el primer empleado con un sueldo mayor que 2000�. Muestra su nombre y su salario (solo del primero). NOTA: siempre puedes salir de un bucle con exit;
declare
   cursor c_empleados is
   select ename,
          sal
     from emp
    where sal > 2000;
begin
   for r_empleado in c_empleados loop
      dbms_output.put_line('Nombre: '
                           || r_empleado.ename
                           || ' - Salario: '
                           || r_empleado.sal);
      exit;
   end loop;
end;
/


--3 Pide al usuario que introduzca un empno y te muestre por la salida el empno, ename y la loc del departamento en el que trabaja
declare
   miempno emp.empno%type := &meteempno;
   cursor datosempleados is
   select empno,
          ename,
          loc
     from emp
     join dept
   on dept.deptno = emp.deptno
    where empno = miempno;
begin
   for fila in datosempleados loop
      dbms_output.put_line(fila.empno
                           || ' '
                           || fila.ename
                           || ' '
                           || fila.loc);
   end loop;
end;
/
undefine meteEmpno;
--4 En la tabla EMP incrementar el salario el 10% a los empleados que tengan una comisi�n superior al 5% del salario. Para ello recorre cada uno de los empleados, y en caso de que se de esa condici�n del 5%, realiza el update y muestra un mensaje con el nombre del empleado con sal actualizado.

declare
   cursor empleados is
   select ename,
          sal,
          empno
     from emp
    where comm > (
      select sal * 0.05
        from dual
   );
begin
   for fila in empleados loop
      update emp
         set
         sal = sal * 1.10
       where empno = fila.empno;
      select sal
        into salnuevo
        from emp
       where empno = fila.empno;
      dbms_output.put_line(fila.ename
                           || ' '
                           || fila.sal);
   end loop;
end;
/

--5 Modifica el ejercicio anterior para, tras actualizar el salario, mostrar el nombre del empleado, la comisi�n, el salario antiguo y el salario nuevo. Adem�s, cuando no se actualice el salario, indicar un mensaje "El empleado XXX no ha tenido subida en su salario".

declare
   cursor empleados is
   select ename,
          sal,
          comm,
          empno
     from emp
    where comm > (
      select sal * 0.05
        from dual
   );
   cursor empleados2 is
   select ename,
          sal,
          comm,
          empno
     from emp
    where comm < sal * 0.05;
begin
   for fila in empleados loop
      update emp
         set
         sal = sal * 1.10
       where empno = fila.empno;

      dbms_output.put_line(fila.ename
                           || ' '
                           || fila.sal
                           || ' '
                           || fila.comm
                           || ' '
                           || fila.sal * 1.10);
   end loop;
end;
/

--6 Pide que introduzca el usuario una cadena de caracteres por teclado. Muestra el empno y el ename de todos los empleados que tengan en su ename esa cadena introducida. Al finalizar, muestra un mensaje con el n�mero total de empleados que lo tienen.

declare
   texto    varchar2(100) := '&meterCadena';
   contador int := 0;
   cursor empleados is
   select empno,
          ename
     from emp
    where ename like '%'
                     || texto
                     || '%';
begin
   for fila in empleados loop
      dbms_output.put_line(fila.ename
                           || ' '
                           || fila.empno);
   end loop;
   select count(empno)
     into contador
     from emp
    where ename like '%'
                     || texto
                     || '%';
   dbms_output.put_line('Hay '
                        || contador
                        || ' empleados');
end;
/
UNDEFINE meterCadena;
--7 Muestra el nombre de cada departamento junto al n�mero de empleados que tiene, incluso si no tiene empleados.

declare
   cursor departamentos is
   select dname,
          count(empno) as contador
     from emp right
     join dept
   on dept.deptno = emp.deptno
    group by dname;
begin
   for fila in departamentos loop
      dbms_output.put_line(fila.dname
                           || ' '
                           || fila.contador);
   end loop;
end;
/

--8 Busca todos los empleados que tienen salario + comisi�n mayor a 2000, y asignarles como salario esa suma. Solo puedes hacerlo si tienen comisi�n. Muestra por la salida el nombre de todos los empleados que modifiquen su salario, as� como el n�mero total de empleados que se han actualizados.

--9 Muestra el ename y sal de los cinco empleados con el salario m�s alto.

--10 Por cada puesto de trabajo (job), muestra el puesto y luego los dos empleados que tienen ese puesto y cobran menos. Si hay menos de dos empleados, muestra los que haya.