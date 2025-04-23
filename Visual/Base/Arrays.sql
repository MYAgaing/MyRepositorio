set serveroutput on;
declare
    type tipoTabla is table of varchar2(50) index by binary_integer;
    datos tipoTabla;
begin
datos(1) := 'casa';
datos(2) := 'perro';
dbms_output.put_line(datos(1) || datos(2));
end;
/
--
declare
    type numeros is table of varchar2(50) index by binary_integer;
    numero numeros;
    begin
    for num in 1..10 loop
    numeros(num) := num;
    dbms_output.put_line(numero(num));
    end loop;
end;
/
--
declare
 type personas1 is record(
    nombre varchar2(50),
    apellido1 varchar2(50),
    apellido2 varchar2(50)
 );
  TYPE personas2 IS TABLE OF personas1 INDEX BY BINARY_INTEGER;
  persona1 personas2;
begin
persona1(1).nombre := 'juan';
persona1(1).apellido1 := 'torres';
persona1(1).apellido2 := 'calero';
persona1(2).nombre := persona1(1);
dbms_output.put_line(persona1(1).nombre || ' '|| persona1(1).apellido1 || ' ' || persona1(1).apellido2 || ' ' || personal1(2).nombre);
end;
/
--
declare
    type numeros is table of varchar2(50) index by binary_integer;
    numero numeros;
    begin
    for numba in 1..10 loop
    numero(numba) := numba;
    dbms_output.put_line(numero(numba));
    dbms_output.put_line(numero.count);
    end loop;
    for nume in numero.first..numero.last loop
    numero(nume) := nume;
     dbms_output.put_line(numero(nume));
    end loop;
    numero.DELETE(numero.LAST);
    dbms_output.put_line(numero.count);
    if numero.EXISTS(10) then
    dbms_output.put_line('Si');
    else 
     dbms_output.put_line('NO');
    end if;
end;
/
--
declare
id1 emp.empno%type := '%diga_el_id';
id2 emp.empno%type := '%diga_el_id';
type tabla is table of emp.empno%type index by binary_integer;
misEmpnos tabla;
contador1 int;
contador2 int;
type tablaEmp is table of emp%rowtype index by binary_integer;
datosEmp tablaEmp;

begin
misEmpnos(1) := id1;
misEmpnos(2) := id2;
dbms_output.put_line(misEmpnos(1) || misEmpnos(2));
select count(*) into contador1 from emp where empno = misEmpnos(1);
select count(*) into contador2 from emp where empno = misEmpnos(2);
if contador1 > 0 and contador2 > 0 then
    for i in misEmpnos.first..misEmpnos.last loop
    select * into datosEmp(i) from emp where empno = misEmpnos(i);
    end loop;
    dbms_output.put_line(datosEmp(1).ename);
    else
    dbms_output.put_line('No existe empno');
    end if;
end;
/
