create or replace procedure becarios as
begin
   for filadept in (
      select *
        from dept
   ) loop
      dbms_output.put_line(filadept.deptno);
      for filaEmpleados in (select * from emp where deptno = filadept.deptno order by hiredate desc) LOOP
      if contador > 2 THEN
      exit;
      contador := contador + 1;
      end loop;
   end loop;
end;
/

declare
año int := &año;
begin
if MOD(año, 4) = 0 and MOD(año , 100) != 0 or mod(anyo,400) = 0 then
dbms_output.put_line('El año es bisiesto')
else
DBMS_OUTPUT.PUT_LINE('El año no es bisiesto');
end;
/