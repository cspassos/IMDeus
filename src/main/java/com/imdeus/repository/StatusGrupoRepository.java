package com.imdeus.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.imdeus.model.Grupo;
import com.imdeus.model.StatusGrupo;
import com.imdeus.repository.filter.GrupoFilter;

public class StatusGrupoRepository implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public StatusGrupo porId(Long id) {
		return manager.find(StatusGrupo.class, id);
	}

	public List<StatusGrupo> todosStatusGrupos() {
		return manager.createQuery("from StatusGrupo", StatusGrupo.class)
				.getResultList();
	}

	public List<Grupo> carregarNomeGrupo(StatusGrupo statusGrupoPai) {
		return manager.createQuery("from Grupo grupo where grupo.statusGrupo = :status", Grupo.class)
				.setParameter("status", statusGrupoPai)
				.getResultList();
	}

	public List<Grupo> carregarNomeGrupoDe(GrupoFilter filtro) {
		return manager.createQuery("from Grupo grupo where grupo.statusGrupo.nomeStatus = :status", Grupo.class)
				.setParameter("status", filtro.getNomeStatus())
				.getResultList();
	}

	@SuppressWarnings({ "unchecked" })
	public List<Grupo> pesquisarGrupo(GrupoFilter filtro) {
		Session session = manager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(Grupo.class);
		criteria.createAlias("statusGrupo", "statusGrupo");

		if (StringUtils.isNotBlank(filtro.getNomeStatus())) {
			criteria.add(Restrictions.eq("statusGrupo.nomeStatus", filtro.getNomeStatus()));
		}

		if (StringUtils.isNotBlank(filtro.getNomeGrupo())) {
			criteria.add(Restrictions.eq("nome", filtro.getNomeGrupo()));
		}

		return criteria.addOrder(Order.asc("nome")).list();
	}

}
