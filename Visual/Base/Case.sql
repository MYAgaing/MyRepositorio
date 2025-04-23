set serveroutput on;

DECLARE
    nota INT := &nota;
BEGIN
    CASE
        WHEN nota < 5 THEN
            dbms_output.put_line('Suspenso');
        WHEN nota = 5 THEN
            dbms_output.put_line('Aprobado');
        WHEN nota = 6 THEN
            dbms_output.put_line('Bien');
        WHEN nota = 7
        OR nota = 8 THEN
            dbms_output.put_line('Notable');
        WHEN nota = 9
        OR nota = 10 THEN
            dbms_output.put_line('Sobresaliente');
        WHEN nota > 10
        OR nota < 0 THEN
            dbms_output.put_line('El valor introducido es incorrecto');
    END CASE;
END;
/

DECLARE
    local     partidos.resultado%TYPE;
    visitante partidos.resultado%TYPE;
BEGIN
    SELECT
        substr(resultado, 1, 2)
    INTO local
    FROM
        partidos
    WHERE
        fecha = '08/01/20';

    SELECT
        substr(resultado, 4, 2)
    INTO visitante
    FROM
        partidos
    WHERE
        fecha = '08/01/20';

    CASE
        WHEN local > visitante THEN
            dbms_output.put_line('El equipo local ha ganado');
        WHEN visitante > local THEN
            dbms_output.put_line('El equipo visitante ha ganadao');
        WHEN local = visitante THEN
            dbms_output.put_line('Empate');
    END CASE;

END;
/

DECLARE
    numero INT;
BEGIN
    LOOP
        numero := numero + 1;
        dbms_output.put_line(numero);
        if (numero > 20)
        then exit;
        end if;
    END LOOP;
END;
/