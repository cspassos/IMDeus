use imdeus;

insert into status_grupo(nome_status) values('GAM');
insert into status_grupo(nome_status) values('POM');
insert into status_grupo(nome_status) values('Pastoral');

insert into grupo(nome, id_status_grupo) values ('GAM Grupo', 1);
insert into grupo(nome, id_status_grupo) values ('GAM Grupo 2', 1);
insert into grupo(nome, id_status_grupo) values ('POM Grupo', 2);
insert into grupo(nome, id_status_grupo) values ('POM Grupo 2', 2);
insert into grupo(nome, id_status_grupo) values ('POM Grupo 3', 2);
insert into grupo(nome, id_status_grupo) values ('Pastoral Grupo', 3);

insert into pessoa(celular, cpf, email, nascimento, nome, criacao) values ('99346554', '04488289100', 'jhonatan@gmail.com', now(), 'Jhonatan', 	STR_TO_DATE('1-01-2012 00:00:00', '%m-%d-%Y %H:%i:%s'));
insert into pessoa(celular, cpf, email, nascimento, nome, criacao) values ('99346565', '04488289101', 'paulo@gmail.com', 	now(), 'Paulo', 	STR_TO_DATE('1-01-2007 00:00:00', '%m-%d-%Y %H:%i:%s'));
insert into pessoa(celular, cpf, email, nascimento, nome, criacao) values ('91111154', '04488289102', 'douglas@gmail.com', 	now(), 'Douglas', 	STR_TO_DATE('1-01-2016 00:00:00', '%m-%d-%Y %H:%i:%s'));
insert into pessoa(celular, cpf, email, nascimento, nome, criacao) values ('99326554', '04488289103', 'lucas@gmail.com', 	now(), 'Lucas', 	STR_TO_DATE('1-01-2014 00:00:00', '%m-%d-%Y %H:%i:%s'));
insert into pessoa(celular, cpf, email, nascimento, nome, criacao) values ('11234454', '04488289104', 'maria@gmail.com', 	now(), 'Maria', 	STR_TO_DATE('1-01-2013 00:00:00', '%m-%d-%Y %H:%i:%s'));
insert into pessoa(celular, cpf, email, nascimento, nome, criacao) values ('91547894', '04488289105', 'joao@gmail.com', 	now(), 'Joao', 		STR_TO_DATE('1-01-2011 00:00:00', '%m-%d-%Y %H:%i:%s'));
insert into pessoa(celular, cpf, email, nascimento, nome, criacao) values ('91146214', '04488289106', 'adriane@gmail.com', 	now(), 'Adriane', 	STR_TO_DATE('1-01-2011 00:00:00', '%m-%d-%Y %H:%i:%s'));
insert into pessoa(celular, cpf, email, nascimento, nome, criacao) values ('91146264', '04488289107', 'pabline@gmail.com', 	now(), 'Pabline', 	STR_TO_DATE('1-01-2000 00:00:00', '%m-%d-%Y %H:%i:%s'));
insert into pessoa(celular, cpf, email, nascimento, nome, criacao) values ('99342144', '04488289108', 'melia@gmail.com', 	now(), 'Melia', 	STR_TO_DATE('1-01-2015 00:00:00', '%m-%d-%Y %H:%i:%s'));	

insert into endereco(cep, cidade, complemento, logradouro, numero, uf, id_pessoa) values ('73754012', 'Planaltina', 'Casa', 'Quadra 12 Casa 15', '15', 'GO', 1);
insert into endereco(cep, cidade, complemento, logradouro, numero, uf, id_pessoa) values ('73754012', 'Planaltina DF', 'Condimio', 'Quadra 02 Casa 01', '15', 'DF', 2);
insert into endereco(cep, cidade, complemento, logradouro, numero, uf, id_pessoa) values ('73754012', 'Amazonas', 'Prédio', 'Quadra 5 Casa 16', '15', 'AM', 3);
insert into endereco(cep, cidade, complemento, logradouro, numero, uf, id_pessoa) values ('73754012', 'Roraina', 'Casa', 'Quadra 15 Casa 15', '15', 'RR', 4);
insert into endereco(cep, cidade, complemento, logradouro, numero, uf, id_pessoa) values ('73754012', 'Planaltina', 'Casa', 'Quadra 12 Casa 15', '15', 'GO', 5);
insert into endereco(cep, cidade, complemento, logradouro, numero, uf, id_pessoa) values ('73754012', 'Planaltina DF', 'Condimio', 'Quadra 02 Casa 01', '15', 'DF', 6);
insert into endereco(cep, cidade, complemento, logradouro, numero, uf, id_pessoa) values ('73754012', 'Amazonas', 'Prédio', 'Quadra 5 Casa 16', '15', 'AM', 7);
insert into endereco(cep, cidade, complemento, logradouro, numero, uf, id_pessoa) values ('73754012', 'Roraina', 'Casa', 'Quadra 15 Casa 15', '15', 'RR', 8);
insert into endereco(cep, cidade, complemento, logradouro, numero, uf, id_pessoa) values ('73754012', 'Roraina', 'Casa', 'Quadra 15 Casa 15', '15', 'RR', 9);

insert into complemento_pessoa(nome_mae, celular_mae, nome_pai, celular_pai, observacao, qual_alergia, qual_medicamento, id_pessoa) values ('Maria', 	'77345556', 'Lourival', '11232164', 'Testes', 'Nenhum', 	'Nenhum', 1);
insert into complemento_pessoa(nome_mae, celular_mae, nome_pai, celular_pai, observacao, qual_alergia, qual_medicamento, id_pessoa) values ('Celia', 	'77112112', 'Paulo', 	'11211164', 'Testes', 'Nenhum', 	'Nenhum', 2);
insert into complemento_pessoa(nome_mae, celular_mae, nome_pai, celular_pai, observacao, qual_alergia, qual_medicamento, id_pessoa) values ('Marta', 	'77355544', 'Marcio', 	'11223364', 'Testes', 'Coceira', 	'Sabonete', 3);
insert into complemento_pessoa(nome_mae, celular_mae, nome_pai, celular_pai, observacao, qual_alergia, qual_medicamento, id_pessoa) values ('Lucia', 	'77345124', 'Marcos', 	'11123364', 'Testes', 'Nenhum', 	'Nenhum', 4);
insert into complemento_pessoa(nome_mae, celular_mae, nome_pai, celular_pai, observacao, qual_alergia, qual_medicamento, id_pessoa) values ('Marcia', 	'77345552', 'Mendes', 	'11235545', 'Testes', 'Nenhum', 	'Nenhum', 5);
insert into complemento_pessoa(nome_mae, celular_mae, nome_pai, celular_pai, observacao, qual_alergia, qual_medicamento, id_pessoa) values ('Mirla', 	'77311116', 'Ismael', 	'11231121', 'Testes', 'Coceira', 	'Mel', 6);
insert into complemento_pessoa(nome_mae, celular_mae, nome_pai, celular_pai, observacao, qual_alergia, qual_medicamento, id_pessoa) values ('Adria', 	'77347546', 'Fausto', 	'11221443', 'Testes', 'Coceira', 	'Dipirona', 7);
insert into complemento_pessoa(nome_mae, celular_mae, nome_pai, celular_pai, observacao, qual_alergia, qual_medicamento, id_pessoa) values ('Bruna', 	'77344526', 'Silva', 	'11235332', 'Testes', 'Nenhum', 	'Nenhum', 8);
insert into complemento_pessoa(nome_mae, celular_mae, nome_pai, celular_pai, observacao, qual_alergia, qual_medicamento, id_pessoa) values ('Betina', 	'71245556', 'Elvis', 	'11235145', 'Testes', 'Nenhum', 	'Nenhum', 9);

insert into grupo_pessoa(id_grupo, id_pessoa) values (1, 1);
insert into grupo_pessoa(id_grupo, id_pessoa) values (1, 2);
insert into grupo_pessoa(id_grupo, id_pessoa) values (1, 3);
insert into grupo_pessoa(id_grupo, id_pessoa) values (1, 4);

insert into grupo_pessoa(id_grupo, id_pessoa) values (2, 2);
insert into grupo_pessoa(id_grupo, id_pessoa) values (2, 6);
insert into grupo_pessoa(id_grupo, id_pessoa) values (2, 7);

insert into grupo_pessoa(id_grupo, id_pessoa) values (3, 6);
insert into grupo_pessoa(id_grupo, id_pessoa) values (3, 1);
insert into grupo_pessoa(id_grupo, id_pessoa) values (3, 2);

insert into grupo_pessoa(id_grupo, id_pessoa) values (4, 3);
insert into grupo_pessoa(id_grupo, id_pessoa) values (4, 4);
insert into grupo_pessoa(id_grupo, id_pessoa) values (4, 8);
insert into grupo_pessoa(id_grupo, id_pessoa) values (4, 9);

insert into grupo_pessoa(id_grupo, id_pessoa) values (5, 5);
insert into grupo_pessoa(id_grupo, id_pessoa) values (5, 6);
insert into grupo_pessoa(id_grupo, id_pessoa) values (5, 9);

insert into grupo_pessoa(id_grupo, id_pessoa) values (6, 1);
insert into grupo_pessoa(id_grupo, id_pessoa) values (6, 2);
insert into grupo_pessoa(id_grupo, id_pessoa) values (6, 8);