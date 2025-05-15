create table EMPRESAS(
    id int Primary key ,
    nombre_empresa varchar2(100),
    telefono int,
    direccion varchar2(100),
    ref_maquina int,
    constraint fk_maquina foreign key (ref_maquina) references MAQUINAS(ref)
);
insert into empresas values (4,'cortadora slu','111222333',null,1);
insert into empresas values (5,'amasadores compactas sl','123456789',null,4);
insert into empresas values (6,'todo hornos',null,'c/real 5',5);
update empresas set telefono = '640530630' , direccion = 'c/doctor barnard' where id = 6;
delete empresas where id = 4;
select distinct upper(nombre_empresa) from clientes join avances_lineas_fabricacion on avances_lineas_fabricacion.id_cliente = clientes.cif where loc like ('%Par%') and estado = 'PUESTA A PUNTO' AND TO_CHAR(FECHA,'MM') = '12';
select nombre,SUM(CANTIDAD) from maquinas join PIEZAS_MAQUINAS ON PIEZAS_MAQUINAS.ID_MAQUINA = MAQUINAS.REF GROUP BY NOMBRE HAVING SUM(CANTIDAD) >= 100 ORDER BY SUM(CANTIDAD) DESC;
SELECT SUBSTR(NOMBRE || ' ',INSTR(NOMBRE,' '),INSTR(NOMBRE,' ') + 1) AS "CASOS ALIMENTACION" FROM PIEZAS WHERE SUBSTR(NOMBRE,0,INSTR(NOMBRE,' ')) LIKE ('%Alimentacion%');
SELECT ESTADO,FECHA,HORA FROM avances_lineas_fabricacion WHERE ID_MAQUINA IN (SELECT REF FROM MAQUINAS WHERE PRECIO_VENTA > 500 AND PRECIO_VENTA < 1000);
SELECT CIF,SUM(LINEA_FABRICACION) AS "TOTAL" FROM CLIENTES JOIN avances_lineas_fabricacion on avances_lineas_fabricacion.id_cliente = clientes.cif GROUP BY CIF ORDER BY TOTAL DESC;
SELECT FECHA,HORA,CLIENTES.CIF,MAQUINAS.NOMBRE FROM avances_lineas_fabricacion JOIN CLIENTES ON CLIENTES.CIF = AVANCES_LINEAS_FABRICACION.ID_CLIENTE JOIN MAQUINAS ON MAQUINAS.REF = AVANCES_LINEAS_FABRICACION.ID_MAQUINA WHERE TO_CHAR(FECHA,'YYYY') = '2023' AND ESTADO = 'PUESTA A PUNTO';
SELECT NOMBRE,PRECIO_VENTA FROM MAQUINAS WHERE LENGTH(SUBSTR(NOMBRE,INSTR(NOMBRE,' '),1)) = 1 AND PRECIO_VENTA = (SELECT MAX(PRECIO_VENTA) FROM MAQUINAS GROUP BY REF);
SELECT nombre, precio_venta
FROM maquinas
WHERE INSTR(nombre, ' ', 1, 2) = 0
AND precio_venta = (
    SELECT MAX(precio_venta)
    FROM maquinas
    WHERE INSTR(nombre, ' ', 1, 2) = 0
);
SELECT TIPO,COUNT(TIPO) FROM PIEZAS WHERE TIPO LIKE ('%ICO') GROUP BY TIPO ORDER BY COUNT(TIPO) DESC;

CREATE OR REPLACE FUNCTION devuelveDatosPiezas(id piezas.idpie%type) return piezas%rowtype
is
pieza piezas%rowtype;

BEGIN
select * into pieza from piezas where idpie = id;
return pieza;
exception
when no_data_found then
insert into piezas (idpie,nombre) values (id,'Pieza buscada que no existe');
END;
/

CREATE OR REPLACE PROCEDURE mostrarPiezasPorTipos IS
cursor piezas is SELECT tipo from piezas group by tipo;
cursor piezas2 is select nombre,estado from piezas where tipo = piezas.tipo;
BEGIN
for fila in piezas loop
for fila2 in (select nombre,estado from piezas where tipo = fila.tipo) loop
dbms_output.put_line(fila2.nombre || ' ' || fila2.estado);

end loop;
end loop;
 END;
/
set serveroutput on;
declare

begin
mostrarpiezasportipos;
end;
/