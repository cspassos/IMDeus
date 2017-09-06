use imdeus;

alter table complemento_pessoa 
    add constraint fk_complemento_pessoa_id_pessoa 
    foreign key (id_pessoa) 
    references pessoa (id); 

alter table endereco 
    add constraint fk_endereco_id_pessoa 
    foreign key (id_pessoa) 
    references pessoa (id); 

alter table grupo 
    add constraint fk_grupo_id_status_grupo 
    foreign key (id_status_grupo) 
    references status_grupo (id); 

alter table grupo_pessoa 
    add constraint fk_grupo_pessoa_id_grupo 
    foreign key (id_grupo) 
    references grupo (id);

alter table grupo_pessoa 
    add constraint fk_grupo_pessoa_id_pessoa 
    foreign key (id_pessoa) 
    references pessoa (id);