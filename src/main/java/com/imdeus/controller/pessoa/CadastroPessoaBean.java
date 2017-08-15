package com.imdeus.controller.pessoa;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.imdeus.model.ComplementoPessoa;
import com.imdeus.model.Endereco;
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
	
	@Inject
	private PessoaService pessoaService;
	
	private List<StatusGrupo> statusGrupoRaizes;
	
	private StatusGrupo statusGrupoSelecionado;
	
	private List<Grupo> grupos;
	
	private Pessoa pessoa;
	
	private Grupo grupo;
	
	private boolean tipoCadastroMedicamento = true;
	
	private boolean tipoCadastroIntolerancia = true;
	
//*********** METODOS **************************************************************************************************************************//
	
	public CadastroPessoaBean() {
		pessoa = new Pessoa();
		pessoa.setComplementoPessoa(new ComplementoPessoa());
		pessoa.setEndereco(new Endereco());
	}
	
	public void consultaStatusGrupo() {
		if(FacesUtil.isNotPostback()) {
			statusGrupoRaizes = statusGrupoRepository.consultaStatusGrupo();
		}
	}
	
	public void carregarNomeGrupo() {
		grupos = statusGrupoRepository.carregarNomeGrupo(statusGrupoSelecionado);
	}
	
	public void salvar() {
		this.pessoa = pessoaService.salvar(this.pessoa);
		FacesUtil.addInfoMessage("Pessoa cadastrada com sucesso!");
	}
	
//************* GET E SET ************************************************************************************************************************//
	
	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
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

	public boolean isTipoCadastroMedicamento() {
		return tipoCadastroMedicamento;
	}

	public void setTipoCadastroMedicamento(boolean tipoCadastroMedicamento) {
		this.tipoCadastroMedicamento = tipoCadastroMedicamento;
	}

	public boolean isTipoCadastroIntolerancia() {
		return tipoCadastroIntolerancia;
	}

	public void setTipoCadastroIntolerancia(boolean tipoCadastroIntolerancia) {
		this.tipoCadastroIntolerancia = tipoCadastroIntolerancia;
	}
	
}
