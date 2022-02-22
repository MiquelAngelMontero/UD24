DROP table IF EXISTS cliente;

create table empleado(
    id int auto_increment,
    nombre varchar(250),
    trabajo enum ('Dev', 'Sistemas', 'Tester'),
    salario double,
    fecha date
);

insert into empleado (nombre, trabajo,salario,fecha)values('Jose','Dev',1234.56, NOW());
insert into empleado (nombre, trabajo,salario,fecha)values('Juan','Sistemas',4321, NOW());
insert into empleado (nombre, trabajo,salario,fecha)values('Pedro','Dev',3456, NOW());
insert into empleado (nombre, trabajo,salario,fecha)values('Jordi','Tester',2345, NOW());
insert into empleado (nombre, trabajo,salario,fecha)values('Jonatan','Dev',2134, NOW());