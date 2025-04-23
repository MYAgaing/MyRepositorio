set serveroutput on;

DECLARE
    variable1 VARCHAR2(100) := '&nombre';
    variable2 VARCHAR2(100) := '&apellidos';
BEGIN
    dbms_output.put_line('Hola '
                         || variable1
                         || ' '
                         || variable2);
END;
/

DECLARE
    num1 INT := 8;
    num2 INT := 4;
BEGIN
    dbms_output.put_line(num1 + num2);
    dbms_output.put_line(num1 - num2);
    dbms_output.put_line(num1 * num2);
    dbms_output.put_line(num1 / num2);
END;
/

DECLARE
    num1 INT := 7;
    num2 INT := 3;
BEGIN
    IF num1 > num2 THEN
        dbms_output.put_line(num1 + num2);
    END IF;
END;
/

DECLARE
    num1 INT := 8;
    num2 INT := 4;
BEGIN
    dbms_output.put_line(num1 + num2);
    dbms_output.put_line(num1 - num2);
    dbms_output.put_line(num1 * num2);
    dbms_output.put_line(num1 / num2);
END;
/

DECLARE
    num1 INT := 7;
    num2 INT := 3;
BEGIN
    IF num1 > num2 THEN
        dbms_output.put_line(num1 - num2);
    ELSE
        dbms_output.put_line(num1
                             || ' es menor que '
                             || num2);
    END IF;
END;
/
/*
declare
variable1 int;
begin
variable1 := &numero;
if variable1 < 5 then dbms_output.put_line('Suspenso'); elsif variable1 = 5 then dbms_output.put_line('Aprobado');
elsif variable1 = 6 then dbms_output.put_line('Bien'); elsif variable1 BETWEEN 7 and 8 then dbms_output.put_line('Notable');
else
IF variable1 BETWEEN 9 AND 10 THEN
    dbms_output.put_line('Sobresaliente');
ELSE
    dbms_output.put_line('Numero comprendido entre 0 y 10');
END IF;

end;
/*/
declare
numero_departamento dept.deptno%type;
nombre dept.dname%type;
localizacion dept.loc%type;
begin
numero_departamento := &numero_departamento;
nombre := '&nombre';
localizacion := '&localizacion';
insert into dept values(numero_departamento,nombre,localizacion);
dbms_output.put_line('Fila insertada correctamente: ' || numero_departamento || ' ' || nombre || ' ' || localizacion);
end;
/