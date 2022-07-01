

-- CREAR NUEVA BD
CREATE DATABASE BD_AUTOCAR;

USE BD_AUTOCAR;

-- CREAR TABLAS

CREATE TABLE cliente(
idCli INT auto_increment,
nomCli VARCHAR(20),
apeCli VARCHAR(100),
correo VARCHAR(100) not null,
contra VARCHAR(50),
CONSTRAINT PK_CLIENTE PRIMARY KEY (idCli)
);

CREATE TABLE productos
(
idProd CHAR(5) NOT NULL,
nomProd VARCHAR(50) not null,
descripcion VARCHAR(150) not null,
idCli INT default 1 not null,
precio decimal(5,2) not null,
cantidad INT not null,
CONSTRAINT PK_PRODUCT PRIMARY KEY (idProd),
foreign key (idCli) references cliente(idCli)
);

create table cabeBoleta(
numBoleta char(5) not null,
fechBoleta    date,
idCli  int not null,
primary key (numBoleta),
foreign key (idCli) references cliente(idCli)
);

create table detaBoleta(
numBoleta char(5) not null,
idProd char(5) not null,
cantidad int,
precioVenta decimal(8,2),
primary key (numBoleta,idProd),
foreign key (numBoleta) references cabeBoleta(numBoleta),
foreign key (idProd) references productos(idProd)
);

-- Insertando clientes

insert into cliente values(null,'Jose', 'Galdes', 'josesito12@gmail.com', 'josegaldes');
insert into cliente values(null,'Manuel', 'Paredes', 'manuelito12@gmail.com', 'manuelparedes');
insert into cliente values(null,'Juan', 'Villegas', 'juancito12@gmail.com', 'juanvillegas');

-- INSERTANDO A LA TABLA PRODUCTOS

insert into productos values('A0001','Apoyabrazos','Consola central universal',1,149.00,20);
insert into productos values('A0002','Asiento','Material de cuero',2,400.50,20);
insert into productos values('A0003','Bateria para auto','Material de Polipropileno',1,290.00,20);
insert into productos values('A0004','Bomba de agua eléctrica','Tipo de conexión Monofásico',1,130.00,20);
insert into productos values('A0005','Espejo retrovisor','Marca	OTTOWARE',3,19.00,20);
insert into productos values('A0006','Llanta Tirelli','Material de caucho',1,800.90,20);
insert into productos values('A0007','Palanca de cambio','L22-17899637',2,108.00,20);
insert into productos values('A0008','Precalentador de bujías','Control de temperatura constante',1,900.00,20);
insert into productos values('A0009','Timón Safari','Timón Deportivo PVC',3,110.00,20);

select * from productos;
select *from cliente;

select * from detaBoleta;
select * from cabeBoleta;

select * from productos where idProd = 'A0001';
delete from cabeBoleta where numBoleta ='B0003';


--
select substr(max(numBoleta),2) from cabeBoleta;




