drop table agencias cascade constraints;
drop table empleados cascade constraints;
drop table inmobiliarias cascade constraints;
create table agencias (
    id int,
    direccion varchar2(100),
    telefono char(13),
    nombre varchar2(50),
    num_empleados int
);
create table empleados(
    codigo_empleados int,
    nombre varchar2(50),
    fecha_nac date,
    id_agencia int
);
alter table agencias add constraint id_pk primary key (id);
alter table empleados add constraint id_empleados_pk primary key (codigo_empleados);
alter table empleados add constraint fk_agencias_e foreign key (id_agencia) references agencias (id); 
rename agencias to inmobiliarias;
alter table empleados rename constraint fk_agencias_e to fk_agencias_emp;
alter table empleados
	add salario number(8,2) check(salario>0);
alter table empleados add constraint salario check (regex_like(salario>0));
alter table inmobiliarias
	add constraint ck_agencias_telefono 
    check(regexp_like(telefono,'0034[0-9]{9}'));