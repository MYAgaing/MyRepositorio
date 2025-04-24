create or replace procedure consultarempleado (
   v_empno in emp.empno%type,
   v_ename out emp.ename%type,
   v_job   out emp.job%type
) as
begin
   select ename,
          job
     into
      v_ename,
      v_job
     from emp
    where empno = v_empno;
exception
   when no_data_found then
      dbms_output.put_line('NO SE ENCONTRARON DATOS');
end consultarempleado;
/

declare
   v_empno emp.empno%type := 7839;
   v_ename emp.ename%type;
   v_job   emp.job%type;
begin
   consultarempleado(
      v_empno,
      v_ename,
      v_job
   );
   dbms_output.put_line(v_ename
                        || ' '
                        || v_job);
end;
/

create or replace procedure is_today as
begin
   dbms_output.put_line(sysdate);
end;
/

begin
   is_today;
end;
/

create or replace procedure is_today2 as
begin
    is_today;
end;
/

declare

 begin
   is_today2;
end;
/

create or replace procedure mostrarBecarios AS
cursor cursorBe is select * from emp ;
BEGIN
FOR fila IN cursorBe LOOP

END LOOP;
end;
/