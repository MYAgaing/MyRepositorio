CREATE TABLE pilotos (
    id               INT,
    nombre           VARCHAR2(100),
    apellidos        VARCHAR2(100),
    fecha_nacimiento DATE,
    nacionalidad     VARCHAR2(50) CHECK ( nacionalidad = 'ESPAÑOLA'
                                      OR nacionalidad = 'HOLANDESA'
                                      OR nacionalidad = 'BRITANICA' ),
    id_rol           INT,
    id_equipo        INT
);

CREATE TABLE equipos (
    id            INT,
    nombre        VARCHAR2(100),
    sede          VARCHAR2(100),
    director      VARCHAR2(100),
    motor         VARCHAR2(100),
    num_titulos   INT,
    num_empleados INT CHECK ( num_empleados > 0 )
);

CREATE TABLE roles (
    id  INT PRIMARY KEY,
    rol VARCHAR2(100)
);

ALTER TABLE pilotos
    ADD CONSTRAINT fk_equipos FOREIGN KEY ( id_equipo )
        REFERENCES equipos ( id );

ALTER TABLE equipos ADD CONSTRAINT pk_id_equipos PRIMARY KEY ( id );

INSERT INTO pilotos VALUES ( 1,
                             'Fernando',
                             'Alonso',
                             '29/07/1981',
                             'ESPAÑOLA',
                             '',
                             '' );

INSERT INTO pilotos VALUES ( 2,
                             'Max',
                             'Verstappen',
                             '30/09/1997',
                             'HOLANDESA',
                             '',
                             '' );

INSERT INTO pilotos VALUES ( 3,
                             'Lewis',
                             'Hamilton',
                             '07/01/1985',
                             'ESPAÑOLA',
                             '',
                             '' );

INSERT INTO equipos VALUES ( 1,
                             'Aston Martin',
                             'Silverstone',
                             'Adrian Newey',
                             'Mercedes',
                             0,
                             800 );

INSERT INTO equipos VALUES ( 2,
                             'RED BULL',
                             'MILTON KEYNES',
                             'CHRISTIAN HORNER',
                             'HONDA',
                             6,
                             1000 );

INSERT INTO equipos VALUES ( 3,
                             'FERRARI',
                             'MARANELLO',
                             'JOHN ELKANN',
                             'FERRARI',
                             16,
                             1200 );

INSERT INTO equipos VALUES ( 4,
                             'WILLIAMS',
                             'GROVE',
                             'JAMES VOWLES',
                             'MERCEDES',
                             9,
                             750 );

INSERT INTO roles VALUES ( 1,
                           'Primer piloto' );

INSERT INTO roles VALUES ( 2,
                           'Segundo piloto' );

INSERT INTO roles VALUES ( 3,
                           'Piloto pruebas' );

SELECT
    nacionalidad,
    COUNT(*)
FROM
    pilotos
GROUP BY
    nacionalidad
ORDER BY
    COUNT(*) DESC,
    nacionalidad;

SELECT
    pilotos.apellidos,
    pilotos.nombre,
    equipos.nombre
FROM
    futbolistas
    JOIN equipos
WHERE
    id_roles = 1;

SELECT
    *
FROM
    pilotos;

SELECT
    motor,
    num_titulos
FROM
    equipos;

SELECT
    *
FROM
         pilotos
    JOIN roles ON roles.id = id_rol
    JOIN equipos ON equipos.id = id_equipo;

SELECT
    apellidos
    || ','
    || pilotos.nombre
    || '-'
    || equipos.nombre
FROM
         pilotos
    JOIN roles ON roles.id = id_rol
    JOIN equipos ON equipos.id = id_equipo
WHERE
    upper(rol) = 'PRIMER PILOTO';

SELECT
    COUNT(*)
FROM
    pilotos
WHERE
    MOD(TO_NUMBER(to_char(fecha_nacimiento, 'dd')),
        2) = 1;

SELECT
    pilotos.nombre,
    pilotos.apellidos,
    equipos.director,
    roles.rol
FROM
         pilotos
    JOIN equipos ON pilotos.id_equipo = equipos.id
    JOIN roles ON pilotos.id_rol = roles.id;

SELECT
    apellidos,
    length(apellidos) - length(replace(apellidos, 'A', ''))
FROM
    pilotos;

set serveroutput on;

DECLARE
    variable1 equipos.num_titulos%TYPE;
BEGIN
    SELECT
        SUM(num_titulos)
    INTO variable1
    FROM
        equipos;

    dbms_output.put_line('El numero total de campeonatos disputados es de ' || variable1);
END;
/

SELECT
    *
FROM
    equipos;

DECLARE
    masmotores equipos.motor%TYPE;
BEGIN
    SELECT
        motor
    INTO masmotores
    FROM
        equipos
    GROUP BY
        motor
    HAVING
        COUNT(motor) = (
            SELECT
                MAX(COUNT(motor))
            FROM
                equipos
            GROUP BY
                motor
        );

    dbms_output.put_line('El motor mas empleado es ' || masmotores);
END;
/

SELECT
    *
FROM
    equipos;

DECLARE BEGIN END ; /