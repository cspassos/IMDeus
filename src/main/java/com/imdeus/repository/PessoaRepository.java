package com.imdeus.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.imdeus.model.Pessoa;
import com.imdeus.repository.filter.PessoaFilter;
import com.imdeus.util.jpa.Transactional;

public class PessoaRepository implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	// Buscar o status do pessoa pelo ID
	public Pessoa porId(Long id) {
		return manager.find(Pessoa.class, id);
	}

	@Transactional
	public Pessoa salvar(Pessoa pessoa) {
		manager.persist(pessoa);
		return pessoa;
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<Pessoa> todasPessoas(PessoaFilter filtro) {
		// TODO: refazer esta consulta, esta estranha
		// esta realizando joins desnecessarios, e nao trazendo as informacoes de endereco e complemento
		
		Session session = manager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(Pessoa.class,"pessoa");
		criteria.createAlias("pessoa.complementoPessoa", "complementoPessoa");
		criteria.createAlias("pessoa.endereco", "endereco");

		if (StringUtils.isNotBlank(filtro.getNome())) {
			criteria.add(Restrictions.eq("nome", filtro.getNome()));
		}

		if (filtro.getIdade() != null) {
			criteria.add(Restrictions.eq("idade", filtro.getIdade()));
		}

		if (StringUtils.isNotBlank(filtro.getNomeMae())) {
			criteria.add(Restrictions.eq("complementoPessoa.nomeMae", filtro.getNomeMae()));
		}

		if (filtro.getGrupo() != null) {
			criteria.createAlias("gruposPessoas", "gruposPessoas");
			criteria.add(Restrictions.eq("gruposPessoas.grupo.id", filtro.getGrupo().getId()));
		}

		return criteria.list();
	}

}
