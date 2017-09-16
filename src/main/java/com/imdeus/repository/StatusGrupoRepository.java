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
		return (StatusGrupo) manager.unwrap(Session.class).createQuery("from StatusGrupo where id = :id")
				.setCacheable(true).setParameter("id", id).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<StatusGrupo> todosStatusGrupos() {
		return manager.unwrap(Session.class).createQuery("from StatusGrupo").setCacheable(true).list();
	}

	public List<Grupo> carregarNomeGrupo(StatusGrupo statusGrupoPai) {
		return manager.createQuery("from Grupo grupo where grupo.statusGrupo = :status", Grupo.class)
				.setParameter("status", statusGrupoPai).getResultList();
	}

	public List<Grupo> carregarNomeGrupoDe(GrupoFilter filtro) {
		return manager.createQuery("from Grupo grupo where grupo.statusGrupo.nomeStatus = :status", Grupo.class)
				.setParameter("status", filtro.getNomeStatus()).getResultList();
	}
	
	public List<GrupoGraph> statusComTotalDeGrupos(){
		return manager.createQuery("select new com.imdeus.repository.GrupoGraph(s.nomeStatus, count(*) as qtdeGrupos) "
				+ "from StatusGrupo s join s.grupo g group by s.nomeStatus", GrupoGraph.class)
			.setMaxResults(5).getResultList();
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
