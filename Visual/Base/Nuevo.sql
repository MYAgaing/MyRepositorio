set SERVEROUTPUT on;

DECLARE
    datos  estudiantes.dni%TYPE;
    datos2 estudiantes.apellidos%TYPE;
BEGIN
    SELECT
        dni,
        apellidos
    INTO
        datos,
        datos2
    FROM
        estudiantes
    WHERE
        nombre = 'Ana';

    dbms_output.put_line(datos
                         || ' '
                         || datos2);
--select * into datos from estudiantes where codigo = 1;-
EXCEPTION
    WHEN no_data_found THEN
        dbms_output.put_line('No hay datos');
    WHEN too_many_rows THEN
        dbms_output.put_line('Hay mas de un dato');
END;
/

DECLARE
    datos    estudiantes%rowtype;
    CURSOR cursorestudiantes IS
    SELECT
        *
    FROM
        estudiantes;

    contador INT := 0;
BEGIN
    OPEN cursorestudiantes;
    LOOP
        FETCH cursorestudiantes INTO datos;
        dbms_output.put_line(datos.dni);
        EXIT WHEN cursorestudiantes%notfound;
        contador := contador + 1;
    END LOOP;

    CLOSE cursorestudiantes;
EXCEPTION
    WHEN too_many_rows THEN
        dbms_output.put_line('Hay mas de uno');
END;
/

declare
datos estudiantes%rowtype;
cursor datosEstudiantes is select * from estudiantes;

begin
open datosEstudiantes;
fetch datosEstudiantes into datos;
dbms_output.put_line(datosEstudiantes%rowcount);
close datosEstudiantes;
dbms_output.put_line(datos.nombre || ' ' || datos.apellidos || ' ' || datos.dni);

end;
/

declare
datos estudiantes%rowtype;
cursor datosEstudiantes is select * from estudiantes;

begin
open datosEstudiantes;
loop
fetch datosEstudiantes into datos;
exit when datosEstudiantes%notfound;
dbms_output.put_line(datos.nombre || datos.apellidos || datos.dni);
end loop;
dbms_output.put_line(datosEstudiantes%rowcount);

close datosEstudiantes;

end;
/

declare 
datos estudiantes%rowtype;
cursor datosEs is select * from estudiantes;
begin
open datosEs;
fetch datosEs into datos;
while datosEs%found loop
dbms_output.put_line(datos.nombre || ' ' || datos.fecha_nacimiento);
end loop;
dbms_output.put_line(datosEs%rowcount);
close datosEs;
end;
/

declare
contador int := 0;
begin
for i in (select * from estudiantes) loop
dbms_output.put_line(i.nombre || '|' ||i.fecha_nacimiento);
contador := contador + 1;
end loop;
dbms_output.put_line('Total: ' || contador);


end;
/


declare 
nombres estudiantes.nombre%type := '&nombre';
cursor datos is select * from estudiantes where nombre = nombres ;

begin 
open datos;
while datos%found loop
fetch datos into nombre2,apellidos;
dbms_output.put_line(upper(datos.apellidos)||','||upper(datos.nombre2));
end loop;
close datos;

end;
/

declare
nombre1 estudiantes.nombre%type := '&nombres';

begin
for i in (select * from estudiantes) loop
if(i.nombre = nombre1)then
dbms_output.put_line(i.apellidos||i.nombre);
end if;
end loop;
end;
/