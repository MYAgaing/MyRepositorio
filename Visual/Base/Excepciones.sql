SELECT
    *
FROM
    asignaturas;

set serveroutput on;

DECLARE
    midescripcion asignaturas.descripcion%TYPE;
    num           INT := 4;
    miexcepcion EXCEPTION;
BEGIN
    IF num > 5 THEN
        RAISE miexcepcion;
    ELSE
        raise_application_error(-20001, 'Error personalizado', TRUE);
    END IF;
--select descripcion into miDescripcion from asignaturas where codigo = 11;
--dbms_output.put_line(miDescripcion);
--select descripcion into miDescripcion from asignaturas where codigo = 11;
--dbms_output.put_line(miDescripcion);
--dbms_output.put_line(4/0);
EXCEPTION
    WHEN no_data_found THEN
        dbms_output.put_line('No hay datos');
    WHEN too_many_rows THEN
        dbms_output.put_line('Demasiadas lineas');
    WHEN zero_divide THEN
        dbms_output.put_line('No se divide entre cero');
    WHEN OTHERS THEN
        dbms_output.put_line('Error');
END;
/
--ejercicio1
DECLARE BEGIN
    dbms_output.put_line(4 / 0);
EXCEPTION
    WHEN OTHERS THEN
        dbms_output.put_line(sqlcode
                             || ' '
                             || substr(sqlerrm,
                                       11,
                                       length(sqlerrm)));
END;
/

DECLARE
    num_estudiantes INT;
    no_alumnos EXCEPTION;
    muchos_alumnos EXCEPTION;
BEGIN
    SELECT
        COUNT(*)
    INTO num_estudiantes
    FROM
        estudiantes;

    IF num_estudiantes = 0 THEN
        RAISE no_alumnos;
    ELSIF num_estudiantes >= 5 THEN
        RAISE muchos_alumnos;
    ELSE
        dbms_output.put_line(num_estudiantes);
    END IF;

EXCEPTION
    WHEN no_alumnos THEN
        dbms_output.put_line('No hay alumnos');
    WHEN muchos_alumnos THEN
        dbms_output.put_line('HAY muchos alumnos');
END;
/
--Boletín ejercicios con excepciones
--1 Pide al usuario que introduzca un código de asignatura y muestra el código junto al curso y descripción. Controla las siguiente excepciones mostrando un mensaje de error: no existe ese código en la tabla asignaturas.

--2 Se quiere pedir al usuario que introduzca un nivel de curso (primer curso o segundo), introduciendo 1 o 2 por teclado. Una vez se meta el nivel, muestra por la salida todas las descripciones de las asignaturas de ese nivel. Excepciones a tener en cuenta mostrando un mensaje de error: el nivel no es un número válido y el número no existe en la tabla asignaturas. NOTA: para saber si han introduciendo un número, puedes controlarlo con la excepción value_error a la que se accede cuando se produce un error en una conversión (por ejemplo al llamar a to_number() y no puede hacer la conversión).

--3 Se quiere una lista donde se muestre el curso y cuántas asignaturas hay en ese curso (una línea por cada curso). Ejemplo: Curso 1: 4 asignaturas. Excepciones a tener en cuenta: crea una excepción personalizada llamada cursoConRedes de forma que si el curso tiene la asignatura con descripción "Redes" no debes mostrarlo por pantalla, terminando la ejecución de tu código y mostrando en tu excepción el siguiente mensaje: "No se puedes mostrar datos porque existe la asignatura de Redes".

--4 Se quiere mostrar por la salida el nombre de cada asignatura y la nota media obtenida en las matrículas de esa asignatura por parte de los alumnos. Excepciones a tener en cuenta: crea una excepción personalizada menosDeCinco que, una vez mostradas todas las notas media, si alguna tiene un valor menor a cinco, llamar a esa excepción personalizada indicando el mensaje "Hay alguna asignatura con una media inferior a cinco", sustituyendo AAA por el valor concreto.

--5 Modifica el ejercicio 4 para mostrar por la salida solo las asignaturas que tienen una media superior a 5. A continuación, si has mostrado una o más asignaturas con una media con decimales, llama a una excepción personalizada tienenDecimales que muestre todas esas asignaturas con decimales, separadas por coma. 

--6 Se quiere pedir por teclado el código de una asignatura. Muestra una lista de todos los alumnos que están matriculados (dni y nombre de los almnos) y la nota que han sacado. Ten en cuenta las siguientes excepciones: el código de asignatura es un número, existe en la tabla asignaturas y además hay matrículas de alumnos en esa asignatura. Para esa última excepción, crea una excepción personalizada que se llame noMatriculas.