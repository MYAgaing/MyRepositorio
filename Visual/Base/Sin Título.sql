--creamos las tablas
create table productos(
    id int,
    nombre varchar2(100),
    tipo varchar2(50)
);
create table clientes(
    codigo int,
    nombre varchar2(50),
    fecha_nacimiento date
);
create table pedidos(
    id_producto int,
    id_cliente int,
    fecha_compra date
);
-- a continuacion asignamos las pk
alter table productos add constraint id_productos primary key (id);
alter table clientes add constraint codigo_cliente primary key (codigo);
alter table pedidos add constraint id_pedidos primary key (id_produco, id_cliente);

alter table pedidos add constraint fk_pedidos_productos foreign key (id_producto) references productos (id);
alter table pedidos add constraint fk_pedidos_clientes foreign key (id_cliente) references clientes (codigo);
alter table productos drop CONSTRAINT