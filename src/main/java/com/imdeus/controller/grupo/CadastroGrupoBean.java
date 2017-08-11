package com.imdeus.controller.grupo;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.imdeus.model.Grupo;
import com.imdeus.model.StatusGrupo;
import com.imdeus.repository.GrupoRepository;
import com.imdeus.repository.StatusGrupoRepository;
import com.imdeus.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroGrupoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private StatusGrupoRepository statusGrupoRepository;
	
	@Inject
	private GrupoRepository grupoRepository;

	private Grupo grupo;

	private List<StatusGrupo> statusGrupo;

	public CadastroGrupoBean() {
		limparFormulario();
	}

	private void limparFormulario() {
		grupo = new Grupo();
	}

	public void inicializar() {
		if (FacesUtil.isNotPostback()) {
			statusGrupo = statusGrupoRepository.consultaStatusGrupo();
		}
	}

	public void salvar() {
		grupoRepository.salvar(grupo);
		limparFormulario();
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	public List<StatusGrupo> getStatusGrupo() {
		return statusGrupo;
	}

}
