package com.imdeus.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.validation.constraints.NotNull;

import com.imdeus.model.Grupo;
import com.imdeus.model.StatusGrupo;
import com.imdeus.repository.StatusGrupoRepository;
import com.imdeus.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroGrupoBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private StatusGrupoRepository statusGrupoRepository;
	
	private Grupo grupo;
	
	private List<StatusGrupo> statusGrupoRaizes;
	

	public CadastroGrupoBean() {
		grupo = new Grupo();
	}
	
	public void inicializar() {
		
		if(FacesUtil.isNotPostback()) {
			statusGrupoRaizes = statusGrupoRepository.consultaStatusGrupo();
		}
	}
	
	public void salvar() {
	}
	
//** GET E SET ************************************************************************
	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	public List<StatusGrupo> getStatusGrupoRaizes() {
		return statusGrupoRaizes;
	}

	public void setStatusGrupoRaizes(List<StatusGrupo> statusGrupoRaizes) {
		this.statusGrupoRaizes = statusGrupoRaizes;
	}
	
	public StatusGrupoRepository getStatusGrupoRepository() {
		return statusGrupoRepository;
	}

	public void setStatusGrupoRepository(StatusGrupoRepository statusGrupoRepository) {
		this.statusGrupoRepository = statusGrupoRepository;
	}
	
}
