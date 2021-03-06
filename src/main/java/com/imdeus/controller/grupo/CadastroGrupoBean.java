package com.imdeus.controller.grupo;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.imdeus.model.Grupo;
import com.imdeus.model.StatusGrupo;
import com.imdeus.repository.StatusGrupoRepository;
import com.imdeus.service.GrupoService;
import com.imdeus.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroGrupoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private StatusGrupoRepository statusGrupoRepository;
	@Inject
	private GrupoService cadastroProdutoService;

	private List<StatusGrupo> statusGrupo;

	private Grupo grupo;
	
	@PostConstruct
	public void inicializar() {
		limparFormulario();
		statusGrupo = statusGrupoRepository.todosStatusGrupos();
	}

	private void limparFormulario() {
		grupo = new Grupo();
	}

	public void salvar() {
		cadastroProdutoService.salvar(grupo);
		FacesUtil.addInfoMessage("Grupo salvo com sucesso!");
		limparFormulario();
	}

	public Grupo getGrupo() {
		return grupo;
	}

	// Por causa da edicao
	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	public List<StatusGrupo> getStatusGrupo() {
		return statusGrupo;
	}

}
