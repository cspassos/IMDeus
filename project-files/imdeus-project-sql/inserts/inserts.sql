use imdeus;

insert into status_grupo(nome_status) values
	('GAM'),
	('POM'),
	('MASS');
	
insert into grupo(nome, id_status_grupo) values
	('GAM Grupo', 1),
	('GAM Grupo 2', 1),
	('POM Grupo', 2),
	('POM Grupo 2', 2),
	('POM Grupo 3', 2),
	('MASS Grupo', 3);
	
insert into pessoa(celular, email, idade, nome) values
	('99346554', 'jhonatan@gmail.com', 11, 'Jhonatan'),
	('99346554', 'paulo@gmail.com', 11, 'Paulo'),
	('99346554', 'douglas@gmail.com', 11, 'Douglas'),
	('99346554', 'lucas@gmail.com', 11, 'Lucas');

insert into endereco(cep, cidade, complemento, logradouro, numero, uf, id_pessoa) values
	('73754012', 'Planaltina', 'Casa', 'Quadra 12 Casa 15', '15', 'GO', 1),
	('73754012', 'Planaltina DF', 'Condimio', 'Quadra 02 Casa 01', '15', 'DF', 2),
	('73754012', 'Amazonas', 'Prédio', 'Quadra 5 Casa 16', '15', 'AM', 3),
	('73754012', 'Roraina', 'Casa', 'Quadra 15 Casa 15', '15', 'RR', 4);
	
insert into imdeus.complemento_pessoa(nome_mae, celular_mae, nome_pai, celular_pai, observacao, qual_alergia, qual_medicamento, id_pessoa) values
	('Maria', '77345556', 'Lourival', '11235564', 'Testes', 'Nenhum', 'Nenhum', 1),
	('Maria', '77345556', 'Paulo', '11235564', 'Testes', 'Nenhum', 'Nenhum', 2),
	('Adriane', '77345556', 'Marcio', '11235564', 'Testes', 'Nenhum', 'Nenhum', 3),
	('Betty', '77345556', 'Marcos', '11235564', 'Testes', 'Nenhum', 'Nenhum', 4);
	
insert into imdeus.grupo_pessoa(id_grupo, id_pessoa) values
	(1, 1),
	(1, 2),
	(1, 3),
	(1, 4),
	(2, 1),
	(2, 3),
	(2, 4),
	(3, 2),
	(3, 3),
	(3, 4);