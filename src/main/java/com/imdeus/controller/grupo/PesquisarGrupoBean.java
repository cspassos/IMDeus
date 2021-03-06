package com.imdeus.controller.grupo;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;

import com.imdeus.model.Grupo;
import com.imdeus.model.StatusGrupo;
import com.imdeus.repository.StatusGrupoRepository;
import com.imdeus.repository.filter.GrupoFilter;
import com.imdeus.service.GrupoService;
import com.imdeus.util.jsf.FacesUtil;

@Named
@ViewScoped
public class PesquisarGrupoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private StatusGrupoRepository statusGrupoRepository;

	@Inject
	private GrupoService grupoService;

	private List<StatusGrupo> statusGrupoRaizes;

	private StatusGrupo statusGrupoSelecionado;

	private List<Grupo> grupos;

	private List<Grupo> pesquisaStatusGrupoFiltrados;

	private Grupo grupo;

	private StatusGrupo statusGrupoPai;

	@Inject
	private GrupoFilter filtro;

	public void pesquisar() {
		pesquisaStatusGrupoFiltrados = statusGrupoRepository.pesquisarGrupo(filtro);
	}

	public void todosStatusGrupos() {
		if (FacesUtil.isNotPostback()) {
			statusGrupoRaizes = statusGrupoRepository.todosStatusGrupos();
		}
	}

	public void carregarNomeGrupo() {
		if(StringUtils.isNotBlank(filtro.getNomeStatus()))
			grupos = statusGrupoRepository.carregarNomeGrupoDe(filtro);
	}

	public void excluirGrupo() {
		grupoService.deletar(grupo);
		pesquisaStatusGrupoFiltrados.remove(grupo);
		FacesUtil.addInfoMessage("Grupo removido com sucesso!");
	}

	public StatusGrupoRepository getStatusGrupoRepository() {
		return statusGrupoRepository;
	}

	public void setStatusGrupoRepository(StatusGrupoRepository statusGrupoRepository) {
		this.statusGrupoRepository = statusGrupoRepository;
	}

	public StatusGrupo getStatusGrupoSelecionado() {
		return statusGrupoSelecionado;
	}

	public void setStatusGrupoSelecionado(StatusGrupo statusGrupoSelecionado) {
		this.statusGrupoSelecionado = statusGrupoSelecionado;
	}

	public List<StatusGrupo> getStatusGrupoRaizes() {
		return statusGrupoRaizes;
	}

	public void setStatusGrupoRaizes(List<StatusGrupo> statusGrupoRaizes) {
		this.statusGrupoRaizes = statusGrupoRaizes;
	}

	public List<Grupo> getGrupos() {
		return grupos;
	}

	public void setGrupos(List<Grupo> grupos) {
		this.grupos = grupos;
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	public StatusGrupo getStatusGrupoPai() {
		return statusGrupoPai;
	}

	public void setStatusGrupoPai(StatusGrupo statusGrupoPai) {
		this.statusGrupoPai = statusGrupoPai;
	}

	public List<Grupo> getPesquisaStatusGrupoFiltrados() {
		return pesquisaStatusGrupoFiltrados;
	}

	public void setPesquisaStatusGrupoFiltrados(List<Grupo> pesquisaStatusGrupoFiltrados) {
		this.pesquisaStatusGrupoFiltrados = pesquisaStatusGrupoFiltrados;
	}

	public GrupoFilter getFiltro() {
		return filtro;
	}

	public void setFiltro(GrupoFilter filtro) {
		this.filtro = filtro;
	}

}
