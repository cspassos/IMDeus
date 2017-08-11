package com.imdeus.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.imdeus.model.Grupo;
import com.imdeus.model.StatusGrupo;

public class StatusGrupoRepository implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	
	//Buscar o status do grupo pelo ID
	public StatusGrupo porId(Long id) {
		return manager.find(StatusGrupo.class, id);
	}
	
	public List<StatusGrupo> consultaStatusGrupo() {
		
		return manager.createQuery("from StatusGrupo", StatusGrupo.class).getResultList();
	}
	
	public List<StatusGrupo> consultaStatusGrupoPessoa() {
		return manager.createQuery("from StatusGrupo", StatusGrupo.class).getResultList();
	}
	
	public List<Grupo> carregarNomeGrupoDe(StatusGrupo statusGrupoPai) {
		List<Grupo> resultList = manager.createQuery("select grupo from Grupo grupo where grupo.statusGrupo = :status", Grupo.class)		
				.setParameter("status", statusGrupoPai).getResultList();
		return resultList;
	}
	
}
