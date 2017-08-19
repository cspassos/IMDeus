package com.imdeus.controller.grupo;

import java.io.Serializable;
import java.util.List;

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

	private Grupo grupo;

	private List<StatusGrupo> statusGrupo;
	
//*********** METODOS **************************************************************************************************************************//

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
		grupo = cadastroProdutoService.salvar(grupo);
		FacesUtil.addInfoMessage("Grupo salvo com sucesso!");
		limparFormulario();
	}
	
//************* GET E SET ************************************************************************************************************************//

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
