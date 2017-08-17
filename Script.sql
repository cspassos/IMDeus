show databases;

drop database if exists imdeus;
create database if not exists imdeus;

use imdeus;

show tables;

desc grupo;
desc status_grupo;
desc pessoa;
desc imdeus.complemento_pessoa;
desc imdeus.endereco;

insert into status_grupo(nomeStatus) values
	('GAM'),
	('POM'),
	('MASS');
	
insert into grupo(nome, status_grupo_id) values
	('GAM Grupo', 1),
	('GAM Grupo 2', 1),
	('POM Grupo', 2),
	('POM Grupo 2', 2),
	('POM Grupo 3', 2),
	('MASS Grupo', 3);
	
insert into pessoa(celular, email, idade, nome) values
	('99346554', 'pessoa@gmail.com', 11, 'Jhonatan'),
	('99346554', 'pessoa1@gmail.com', 11, 'Paulo'),
	('99346554', 'pessoa2@gmail.com', 11, 'Douglas'),
	('99346554', 'pessoa3@gmail.com', 11, 'Lucas');

select * from imdeus.status_grupo;
select * from imdeus.grupo;
select * from imdeus.pessoa;
select * from imdeus.grupo_pessoa;