package com.imdeus.repository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.persistence.EntityManager;

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
