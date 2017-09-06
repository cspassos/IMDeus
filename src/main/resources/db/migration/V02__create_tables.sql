use imdeus;

create table complemento_pessoa (
    id bigint not null auto_increment,
    celular_mae varchar(17),
    celular_pai varchar(17),
    nome_mae varchar(100) not null,
    nome_pai varchar(100) not null,
    observacao varchar(300),
    qual_alergia varchar(300),
    qual_medicamento varchar(300),
    id_pessoa bigint,
    primary key (id)
) ENGINE=InnoDB default charset=utf8;

create table endereco (
    id bigint not null auto_increment,
    cep varchar(9),
    cidade varchar(60) not null,
    complemento varchar(150),
    logradouro varchar(150) not null,
    numero varchar(10) not null,
    uf varchar(10) not null,
    id_pessoa bigint,
    primary key (id)
) ENGINE=InnoDB default charset=utf8; 

create table grupo (
    id bigint not null auto_increment,
    nome varchar(100) not null,
    id_status_grupo bigint not null,
    primary key (id)
) ENGINE=InnoDB default charset=utf8; 

create table grupo_pessoa (
    id bigint not null auto_increment,
    id_grupo bigint,
    id_pessoa bigint,
    primary key (id)
) ENGINE=InnoDB default charset=utf8; 

create table pessoa (
    id bigint not null auto_increment,
    celular varchar(17) not null,
    cpf varchar(20) not null,
    criacao datetime,
    email varchar(150) not null,
    nascimento date not null,
    nome varchar(100) not null,
    primary key (id)
) ENGINE=InnoDB default charset=utf8;

create table status_grupo (
    id bigint not null auto_increment,
    nome_status varchar(20) not null,
    primary key (id)
) ENGINE=InnoDB default charset=utf8;