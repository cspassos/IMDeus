package com.imdeus.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;

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

	public List<Pessoa> todasPessoas(PessoaFilter filtro) {

		CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();
		CriteriaQuery<Pessoa> criteriaQuery = criteriaBuilder.createQuery(Pessoa.class);

		Root<Pessoa> root = criteriaQuery.from(Pessoa.class);
		criteriaQuery.select(root);

		List<Predicate> predicates = new ArrayList<>();

		if (StringUtils.isNotBlank(filtro.getNome())) {
			ParameterExpression<String> nomeExpression = criteriaBuilder.parameter(String.class, "nome");
			predicates.add(criteriaBuilder.equal(root.get("nome"), nomeExpression));
		}

		if (filtro.getIdade() != null) {
			ParameterExpression<Integer> nomeExpression = criteriaBuilder.parameter(Integer.class, "idade");
			predicates.add(criteriaBuilder.equal(root.get("idade"), nomeExpression));
		}

		if (StringUtils.isNotBlank(filtro.getNomeMae())) {
			ParameterExpression<String> nomeMaeExpression = criteriaBuilder.parameter(String.class, "nomeMae");
			predicates.add(criteriaBuilder.equal(root.get("complementoPessoa").get("nomeMae"), nomeMaeExpression));
		}

		criteriaQuery.where(predicates.toArray(new Predicate[0]));
		TypedQuery<Pessoa> query = manager.createQuery(criteriaQuery);

		if (StringUtils.isNotBlank(filtro.getNome())) {
			query.setParameter("nome", filtro.getNome());
		}

		if (filtro.getIdade() != null) {
			query.setParameter("idade", filtro.getIdade());
		}

		if (StringUtils.isNotBlank(filtro.getNomeMae())) {
			query.setParameter("nomeMae", filtro.getNomeMae());
		}

		return query.getResultList();
	}
}
