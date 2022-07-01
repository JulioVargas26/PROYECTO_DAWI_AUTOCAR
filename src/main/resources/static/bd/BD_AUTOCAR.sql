-- borra la bd si existe
DROP DATABASE IF EXISTS BD_AUTOCAR;

-- CREAR NUEVA BD
CREATE DATABASE BD_AUTOCAR;

USE BD_AUTOCAR;

-- CREAR TABLAS

CREATE TABLE tb_usuarios(
id_usu INT auto_increment,
nom_usu VARCHAR(20) not null,
ape_usu VARCHAR(60) not null,
usr_usu VARCHAR(60) not null unique,
cla_usu VARCHAR(40) not null,
CONSTRAINT PK_USUARIO PRIMARY KEY (id_usu)
);

CREATE TABLE tb_proveedor
(
id_provee CHAR(5) NOT NULL,
nom_provee CHAR(50) NOT NULL,
dir_provee CHAR(50) NOT NULL,
pais VARCHAR(30) NOT NULL,
CONSTRAINT PK_PROVEEDOR PRIMARY KEY (id_provee)
);

CREATE TABLE tb_productos
(
id_prod CHAR(5) NOT NULL,
nom_prod VARCHAR(50) not null,
descripcion_prod VARCHAR(150) not null,
id_provee CHAR(5) NOT NULL,
precio_prod decimal(5,2) not null,
cantidad_prod INT not null,
CONSTRAINT PK_PRODUCT PRIMARY KEY (id_prod),
foreign key (id_provee) references tb_proveedor(id_provee)
);

create table tb_cabeBoleta
(
num_boleta char(5) not null,
fech_boleta    date,
id_usu  int not null,
primary key (num_boleta),
foreign key (id_usu) references tb_usuarios(id_usu)
);

create table tb_detaBoleta(
num_boleta char(5) not null,
id_prod char(5) not null,
id_provee CHAR(5) NOT NULL,
cantidad_prod int,
precio_venta decimal(8,2),
primary key (num_boleta,id_prod),
foreign key (num_boleta) references tb_cabeBoleta(num_boleta),
foreign key (id_prod) references tb_productos(id_prod),
foreign key (id_provee) references tb_proveedor(id_provee)
);

-- Insertando clientes

insert into tb_usuarios values(null,'Jose', 'Galdes', 'josesito12@gmail.com', 'josegaldes');
insert into tb_usuarios values(null,'Manuel', 'Paredes', 'manuelito12@gmail.com', 'manuelparedes');
insert into tb_usuarios values(null,'Juan', 'Villegas', 'juancito12@gmail.com', 'juanvillegas');
insert into tb_usuarios values(null,'Admin', 'Adm', 'admin@gmail.com', 'admin');

-- INSERTANDO A LA TABLA PROVEEDOR

insert into tb_proveedor values('PR001','Jp Cars','LIMA - LIMA',"Perú");
insert into tb_proveedor values('PR002','Radiadores Industriales Soto E.I.R.L.','LIMA - LIMA',"Perú");
insert into tb_proveedor values('PR003','Reycor Rent a Car','LIMA - LIMA',"Perú");

-- INSERTANDO A LA TABLA PRODUCTOS

insert into tb_productos values('P0001','Apoyabrazos','Consola central universal','PR001',149.00,20);
insert into tb_productos values('P0002','Asiento','Material de cuero','PR002',400.50,20);
insert into tb_productos values('P0003','Bateria para auto','Material de Polipropileno','PR003',290.00,20);
insert into tb_productos values('P0004','Bomba de agua eléctrica','Tipo de conexión Monofásico','PR003',130.00,20);
insert into tb_productos values('P0005','Espejo retrovisor','Marca	OTTOWARE','PR002',19.00,20);
insert into tb_productos values('P0006','Llanta Tirelli','Material de caucho','PR001',800.90,20);
insert into tb_productos values('P0007','Palanca de cambio','L22-17899637','PR002',108.00,20);
insert into tb_productos values('P0008','Precalentador de bujías','Control de temperatura constante','PR003',900.00,20);
insert into tb_productos values('P0009','Timón Safari','Timón Deportivo PVC','PR001',110.00,20);

select * from tb_productos;
select *from tb_usuarios;
select * from tb_proveedor;
select * from tb_detaBoleta;
select * from tb_cabeBoleta;

--
select substr(max(num_boleta),2) from tb_cabeBoleta;
