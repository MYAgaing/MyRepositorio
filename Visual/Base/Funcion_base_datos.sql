/*Funciones en SQL
Funciones Numéricas:

ABS(n): Valor absoluto de n.
EXP(n): Exponente en base e de n.
CEIL(n): Redondeo superior de n.
FLOOR(n): Redondeo inferior de n.
MOD(m, n): Resto de m dividido entre n.
POWER(valor, exponente): Elevar valor a exponente.
ROUND(n, decimales): Redondeo con decimales.
SQRT(n): Raíz cuadrada de n.
TRUNC(m, n): Truncar m a n decimales.
SIGN(n): Devuelve 1 si es positivo, -1 si es negativo, 0 si es cero.
Funciones de Cadenas:

CHR(n): Carácter ASCII de n.
ASCII(c): Código ASCII de c.
CONCAT(cadena1, cadena2): Unión de cadenas.
LOWER(cad), UPPER(cad), INITCAP(cad): Minúsculas, mayúsculas y capitalización inicial.
LPAD(cadena, n, relleno), RPAD(cadena, n, relleno): Rellenar cadena a la izquierda o derecha.
REPLACE(cadena, ant, nue): Reemplazar parte de una cadena.
SUBSTR(cadena, m, n): Extraer n caracteres desde m.
LENGTH(cadena): Longitud de la cadena.
TRIM(cadena), LTRIM(cadena), RTRIM(cadena): Eliminar espacios.
INSTR(cad, cadBus, posIni, nApar): Buscar posición de cadBus en cad.
Funciones de Fechas:

SYSDATE: Fecha y hora actual.
SYSTIMESTAMP: Fecha y hora con precisión extendida.
ADD_MONTHS(fecha, n): Sumar n meses a fecha.
MONTHS_BETWEEN(fecha1, fecha2): Diferencia en meses.
LAST_DAY(fecha): Último día del mes de fecha.
NEXT_DAY(fecha, d): Próximo d desde fecha.
EXTRACT(val FROM fecha): Extraer parte de fecha (día, mes, año, etc.).
Funciones de Conversión:

TO_NUMBER(cadena, formato): Convertir texto a número.
TO_CHAR(d, formato): Convertir número o fecha a texto.
TO_DATE(cadena, formato): Convertir texto a fecha.
Funciones Especiales:

NVL(valor, expresión): Si valor es NULL, devuelve expresión.
DECODE(expresión, cond1, val1, cond2, val2, default): Similar a CASE, devuelve val según cond.
SUM() – Calcula la suma de los valores de una columna.
COUNT() – Cuenta el número de elementos en una columna.
COUNT(columna): Cuenta los valores no nulos.
COUNT(*): Cuenta todas las filas, incluyendo valores nulos.
MIN() – Devuelve el valor mínimo de una columna.
MAX() – Devuelve el valor máximo de una columna.
AVG() – Calcula el promedio de los valores de una columna.*/