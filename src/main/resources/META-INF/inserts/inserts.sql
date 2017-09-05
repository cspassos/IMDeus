insert into status_grupo(nome_status) values('GAM');
insert into status_grupo(nome_status) values('POM');
insert into status_grupo(nome_status) values('MASS');

insert into grupo(nome, id_status_grupo) values ('GAM Grupo', 1);
insert into grupo(nome, id_status_grupo) values ('GAM Grupo 2', 1);
insert into grupo(nome, id_status_grupo) values ('POM Grupo', 2);
insert into grupo(nome, id_status_grupo) values ('POM Grupo 2', 2);
insert into grupo(nome, id_status_grupo) values ('POM Grupo 3', 2);
insert into grupo(nome, id_status_grupo) values ('MASS Grupo', 3);

insert into pessoa(celular, cpf, email, nascimento, nome, criacao) values ('99346554', '04488289100', 'jhonatan@gmail.com', now(), 'Jhonatan', 	STR_TO_DATE('1-01-2012 00:00:00', '%m-%d-%Y %H:%i:%s'));
insert into pessoa(celular, cpf, email, nascimento, nome, criacao) values ('99346554', '04488289100', 'paulo@gmail.com', 	now(), 'Paulo', 	STR_TO_DATE('1-01-2007 00:00:00', '%m-%d-%Y %H:%i:%s'));
insert into pessoa(celular, cpf, email, nascimento, nome, criacao) values ('99346554', '04488289100', 'douglas@gmail.com', 	now(), 'Douglas', 	STR_TO_DATE('1-01-2016 00:00:00', '%m-%d-%Y %H:%i:%s'));
insert into pessoa(celular, cpf, email, nascimento, nome, criacao) values ('99346554', '04488289100', 'lucas@gmail.com', 	now(), 'Lucas', 	STR_TO_DATE('1-01-2014 00:00:00', '%m-%d-%Y %H:%i:%s'));
insert into pessoa(celular, cpf, email, nascimento, nome, criacao) values ('99346554', '04488289100', 'maria@gmail.com', 	now(), 'Maria', 	STR_TO_DATE('1-01-2013 00:00:00', '%m-%d-%Y %H:%i:%s'));
insert into pessoa(celular, cpf, email, nascimento, nome, criacao) values ('99346554', '04488289100', 'joao@gmail.com', 	now(), 'Joao', 		STR_TO_DATE('1-01-2011 00:00:00', '%m-%d-%Y %H:%i:%s'));
insert into pessoa(celular, cpf, email, nascimento, nome, criacao) values ('99346554', '04488289100', 'adriane@gmail.com', 	now(), 'Adriane', 	STR_TO_DATE('1-01-2011 00:00:00', '%m-%d-%Y %H:%i:%s'));
insert into pessoa(celular, cpf, email, nascimento, nome, criacao) values ('99346554', '04488289100', 'pabline@gmail.com', 	now(), 'Pabline', 	STR_TO_DATE('1-01-2000 00:00:00', '%m-%d-%Y %H:%i:%s'));
insert into pessoa(celular, cpf, email, nascimento, nome, criacao) values ('99346554', '04488289100', 'melia@gmail.com', 	now(), 'Melia', 	STR_TO_DATE('1-01-2015 00:00:00', '%m-%d-%Y %H:%i:%s'));	

insert into endereco(cep, cidade, complemento, logradouro, numero, uf, id_pessoa) values ('73754012', 'Planaltina', 'Casa', 'Quadra 12 Casa 15', '15', 'GO', 1);
insert into endereco(cep, cidade, complemento, logradouro, numero, uf, id_pessoa) values ('73754012', 'Planaltina DF', 'Condimio', 'Quadra 02 Casa 01', '15', 'DF', 2);
insert into endereco(cep, cidade, complemento, logradouro, numero, uf, id_pessoa) values ('73754012', 'Amazonas', 'Prédio', 'Quadra 5 Casa 16', '15', 'AM', 3);
insert into endereco(cep, cidade, complemento, logradouro, numero, uf, id_pessoa) values ('73754012', 'Roraina', 'Casa', 'Quadra 15 Casa 15', '15', 'RR', 4);

insert into complemento_pessoa(nome_mae, celular_mae, nome_pai, celular_pai, observacao, qual_alergia, qual_medicamento, id_pessoa) values ('Maria', '77345556', 'Lourival', '11235564', 'Testes', 'Nenhum', 'Nenhum', 1);
insert into complemento_pessoa(nome_mae, celular_mae, nome_pai, celular_pai, observacao, qual_alergia, qual_medicamento, id_pessoa) values ('Maria', '77345556', 'Paulo', '11235564', 'Testes', 'Nenhum', 'Nenhum', 2);
insert into complemento_pessoa(nome_mae, celular_mae, nome_pai, celular_pai, observacao, qual_alergia, qual_medicamento, id_pessoa) values ('Adriane', '77345556', 'Marcio', '11235564', 'Testes', 'Nenhum', 'Nenhum', 3);
insert into complemento_pessoa(nome_mae, celular_mae, nome_pai, celular_pai, observacao, qual_alergia, qual_medicamento, id_pessoa) values ('Betty', '77345556', 'Marcos', '11235564', 'Testes', 'Nenhum', 'Nenhum', 4);

insert into grupo_pessoa(id_grupo, id_pessoa) values (1, 1);
insert into grupo_pessoa(id_grupo, id_pessoa) values (1, 2);
insert into grupo_pessoa(id_grupo, id_pessoa) values (1, 3);
insert into grupo_pessoa(id_grupo, id_pessoa) values (1, 4);
insert into grupo_pessoa(id_grupo, id_pessoa) values (2, 1);
insert into grupo_pessoa(id_grupo, id_pessoa) values (2, 3);
insert into grupo_pessoa(id_grupo, id_pessoa) values (2, 4);
insert into grupo_pessoa(id_grupo, id_pessoa) values (3, 2);
insert into grupo_pessoa(id_grupo, id_pessoa) values (3, 3);
insert into grupo_pessoa(id_grupo, id_pessoa) values (3, 4);
insert into grupo_pessoa(id_grupo, id_pessoa) values (4, 4);
insert into grupo_pessoa(id_grupo, id_pessoa) values (4, 1);
insert into grupo_pessoa(id_grupo, id_pessoa) values (5, 3);
insert into grupo_pessoa(id_grupo, id_pessoa) values (5, 1);
insert into grupo_pessoa(id_grupo, id_pessoa) values (6, 2);
insert into grupo_pessoa(id_grupo, id_pessoa) values (6, 5);
insert into grupo_pessoa(id_grupo, id_pessoa) values (7, 8);
insert into grupo_pessoa(id_grupo, id_pessoa) values (7, 9);
insert into grupo_pessoa(id_grupo, id_pessoa) values (7, 10);
insert into grupo_pessoa(id_grupo, id_pessoa) values (7, 11);
