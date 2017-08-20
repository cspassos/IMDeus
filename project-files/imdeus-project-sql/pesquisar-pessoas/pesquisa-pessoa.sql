show databases;

use imdeus;

show tables;

select * from imdeus.complemento_pessoa;
select * from imdeus.endereco;
select * from imdeus.grupo;
select * from imdeus.grupo_pessoa;
select * from imdeus.pessoa;
select * from imdeus.status_grupo;

-- Somente informando idade
select
        this_.id as id1_4_0_,
        this_.celular as celular2_4_0_,
        this_.email as email3_4_0_,
        this_.idade as idade4_4_0_,
        this_.nome as nome5_4_0_ 
    from
        pessoa this_ 
    where
        this_.idade=11
        
-- Somente informando nome        
select
        this_.id as id1_4_0_,
        this_.celular as celular2_4_0_,
        this_.email as email3_4_0_,
        this_.idade as idade4_4_0_,
        this_.nome as nome5_4_0_ 
    from
        pessoa this_ 
    where
        this_.nome='jhonatan'

-- Somente informando o nome da mae
select
        this_.id as id1_4_2_,
        this_.celular as celular2_4_2_,
        this_.email as email3_4_2_,
        this_.idade as idade4_4_2_,
        this_.nome as nome5_4_2_,
        complement1_.id as id1_0_0_,
        complement1_.celular_mae as celular_2_0_0_,
        complement1_.celular_pai as celular_3_0_0_,
        complement1_.nome_mae as nome_mae4_0_0_,
        complement1_.nome_pai as nome_pai5_0_0_,
        complement1_.observacao as observac6_0_0_,
        complement1_.id_pessoa as id_pesso9_0_0_,
        complement1_.qual_alergia as qual_ale7_0_0_,
        complement1_.qual_medicamento as qual_med8_0_0_,
        pessoa4_.id as id1_4_1_,
        pessoa4_.celular as celular2_4_1_,
        pessoa4_.email as email3_4_1_,
        pessoa4_.idade as idade4_4_1_,
        pessoa4_.nome as nome5_4_1_ 
    from
        pessoa this_ 
    inner join
        complemento_pessoa complement1_ 
            on this_.id=complement1_.id_pessoa 
    left outer join
        pessoa pessoa4_ 
            on complement1_.id_pessoa=pessoa4_.id 
    where
        complement1_.nome_mae='Maria';

-- Informando idade, nome e nome da mae
select
        this_.id as id1_4_2_,
        this_.celular as celular2_4_2_,
        this_.email as email3_4_2_,
        this_.idade as idade4_4_2_,
        this_.nome as nome5_4_2_,
        complement1_.id as id1_0_0_,
        complement1_.celular_mae as celular_2_0_0_,
        complement1_.celular_pai as celular_3_0_0_,
        complement1_.nome_mae as nome_mae4_0_0_,
        complement1_.nome_pai as nome_pai5_0_0_,
        complement1_.observacao as observac6_0_0_,
        complement1_.id_pessoa as id_pesso9_0_0_,
        complement1_.qual_alergia as qual_ale7_0_0_,
        complement1_.qual_medicamento as qual_med8_0_0_,
        pessoa4_.id as id1_4_1_,
        pessoa4_.celular as celular2_4_1_,
        pessoa4_.email as email3_4_1_,
        pessoa4_.idade as idade4_4_1_,
        pessoa4_.nome as nome5_4_1_ 
    from
        pessoa this_ 
    inner join
        complemento_pessoa complement1_ 
            on this_.id=complement1_.id_pessoa 
    left outer join
        pessoa pessoa4_ 
            on complement1_.id_pessoa=pessoa4_.id 
    where
        this_.nome='jhonatan' 
        and this_.idade=11 
        and complement1_.nome_mae='maria'    

-- Informando grupo        
select
        this_.id as id1_4_1_,
        this_.celular as celular2_4_1_,
        this_.email as email3_4_1_,
        this_.idade as idade4_4_1_,
        this_.nome as nome5_4_1_,
        grupospess1_.id as id1_3_0_,
        grupospess1_.id_grupo as id_grupo2_3_0_,
        grupospess1_.id_pessoa as id_pesso3_3_0_ 
    from
        pessoa this_ 
    inner join
        grupo_pessoa grupospess1_ 
            on this_.id=grupospess1_.id_pessoa 
    where
        grupospess1_.id_grupo=1

-- Informando idade, nome e grupo        
select
        this_.id as id1_4_1_,
        this_.celular as celular2_4_1_,
        this_.email as email3_4_1_,
        this_.idade as idade4_4_1_,
        this_.nome as nome5_4_1_,
        grupospess1_.id as id1_3_0_,
        grupospess1_.id_grupo as id_grupo2_3_0_,
        grupospess1_.id_pessoa as id_pesso3_3_0_ 
    from
        pessoa this_ 
    inner join
        grupo_pessoa grupospess1_ 
            on this_.id=grupospess1_.id_pessoa 
    where
        this_.nome='jhonatan'
        and this_.idade=11 
        and grupospess1_.id_grupo=1     
        
        
select
        this_.id as id1_4_2_,
        this_.celular as celular2_4_2_,
        this_.email as email3_4_2_,
        this_.idade as idade4_4_2_,
        this_.nome as nome5_4_2_,
        grupospess2_.id as id1_3_0_,
        grupospess2_.id_grupo as id_grupo2_3_0_,
        grupospess2_.id_pessoa as id_pesso3_3_0_,
        complement1_.id as id1_0_1_,
        complement1_.celular_mae as celular_2_0_1_,
        complement1_.celular_pai as celular_3_0_1_,
        complement1_.nome_mae as nome_mae4_0_1_,
        complement1_.nome_pai as nome_pai5_0_1_,
        complement1_.observacao as observac6_0_1_,
        complement1_.id_pessoa as id_pesso9_0_1_,
        complement1_.qual_alergia as qual_ale7_0_1_,
        complement1_.qual_medicamento as qual_med8_0_1_ 
    from
        pessoa this_ 
    inner join
        grupo_pessoa grupospess2_ 
            on this_.id=grupospess2_.id_pessoa 
    inner join
        complemento_pessoa complement1_ 
            on this_.id=complement1_.id_pessoa 
    where
        this_.nome='jhonatan' 
        and this_.idade=11 
        and complement1_.nome_mae='maria' 
        and grupospess2_.id_grupo=1       


