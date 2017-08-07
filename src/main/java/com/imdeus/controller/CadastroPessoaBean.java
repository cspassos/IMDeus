package com.imdeus.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.NotNull;

import com.imdeus.model.Grupo;
import com.imdeus.model.Pessoa;
import com.imdeus.model.StatusGrupo;
import com.imdeus.repository.StatusGrupoRepository;
import com.imdeus.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroPessoaBean implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private StatusGrupoRepository statusGrupoRepository;
	
	private List<StatusGrupo> statusGrupoRaizes;
	
	private StatusGrupo statusGrupoSelecionado;
	
	private List<Grupo> grupos;
	
	private Pessoa pessoa;
	
	private Grupo grupo;
	
	private StatusGrupo statusGrupoPai;
	
	
	public CadastroPessoaBean() {
		pessoa = new Pessoa();
	}
	
	public void consultaStatusGrupo() {
		if(FacesUtil.isNotPostback()) {
			statusGrupoRaizes = statusGrupoRepository.consultaStatusGrupoPessoa();
		}
	}
	
	public void carregarNomeGrupo() {
		grupos = statusGrupoRepository.carregarNomeGrupoDe(statusGrupoSelecionado);
	}
	
	public void salvar() {
		System.out.println("Categoria pai selecionada: " + statusGrupoPai.getNomeStatus());
		//System.out.println("Nome Grupo: " + grupo.getNome().length();
	}
	
//*********** GET E SET *****************************************************************
	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
	@NotNull
	public StatusGrupo getStatusGrupoPai() {
		return statusGrupoPai;
	}

	public void setStatusGrupoPai(StatusGrupo statusGrupoPai) {
		this.statusGrupoPai = statusGrupoPai;
	}

	public List<StatusGrupo> getStatusGrupoRaizes() {
		return statusGrupoRaizes;
	}

	public void setStatusGrupoRaizes(List<StatusGrupo> statusGrupoRaizes) {
		this.statusGrupoRaizes = statusGrupoRaizes;
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}
	
	public void setStatusGrupoSelecionado(StatusGrupo statusGrupoSelecionado) {
		this.statusGrupoSelecionado = statusGrupoSelecionado;
	}
	
	public StatusGrupo getStatusGrupoSelecionado() {
		return statusGrupoSelecionado;
	}
	
	public List<Grupo> getGrupos() {
		return grupos;
	}
	
}
