package com.imdeus.repository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.transform.Transformers;

import com.imdeus.model.Grupo;

public class GrupoRepository implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public Grupo porId(Long id) {
		return manager.find(Grupo.class, id);
	}

	public Grupo salvar(Grupo grupo) {
		return manager.merge(grupo);
	}

	public List<Grupo> gruposPor(String nome) {
		return manager.createQuery("from Grupo where nome = :nomeGrupo", Grupo.class)
				.setParameter("nomeGrupo", nome)
				.getResultList();
	}

	public List<Grupo> gruposContendo(String nome) {
		return manager.createQuery("from Grupo g join fetch g.statusGrupo where nome like :nomeGrupo", Grupo.class)
				.setParameter("nomeGrupo", "%" + nome + "%")
				.getResultList();
	}
	
	public Grupo comStatusPorId(Long id) {
		return manager.createQuery("from Grupo grupo join fetch grupo.statusGrupo where grupo.id = :id", Grupo.class)
				.setParameter("id", id)
				.getSingleResult();
	}
	
	public List<GrupoPessoaGraph> grupoPessoaGrafico(){
		return manager.createQuery("select new com.imdeus.repository.GrupoPessoaGraph(count(*) as qtdePessoas, gp.grupo.nome as nomeGrupo) from Pessoa p join p.gruposPessoas gp"
				+ "	group by gp.grupo.nome order by gp.grupo.nome", GrupoPessoaGraph.class)
				.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<GrupoPessoaGraph> grupoPessoaGrafico2(){
		Session session = manager.unwrap(Session.class);
		return session.createQuery("select count(*) as qtdePessoas, gp.grupo.nome as nomeGrupo from Pessoa p join p.gruposPessoas gp"
				+ "	group by gp.grupo.nome order by gp.grupo.nome")
			.setResultTransformer(Transformers.aliasToBean(GrupoPessoaGraph.class))
			.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<GrupoPessoaGraph> grupoPessoaGrafico3(){
		Session session = manager.unwrap(Session.class);
		return session.createQuery("select map(gp.grupo.nome, map(year(p.criacao), count(*))) from Pessoa p join p.gruposPessoas gp"
				+ "	group by gp.grupo.nome order by gp.grupo.nome")
				.list();
	}
	
	public Optional<Grupo> porNome(String nomes) {
		return gruposPor(nomes).stream().findFirst();
	}

	public List<Grupo> todos() {
		return manager.createQuery("from Grupo", Grupo.class).getResultList();
	}

	public void deletar(Grupo grupo) {
		manager.remove(grupo);
		manager.flush();
	}

}
