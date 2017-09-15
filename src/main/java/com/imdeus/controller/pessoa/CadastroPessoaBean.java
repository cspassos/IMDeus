package com.imdeus.controller.pessoa;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.log4j.Logger;

import com.imdeus.model.Grupo;
import com.imdeus.model.Pessoa;
import com.imdeus.model.StatusGrupo;
import com.imdeus.repository.StatusGrupoRepository;
import com.imdeus.service.PessoaService;
import com.imdeus.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroPessoaBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(CadastroPessoaBean.class);

	@Inject
	private StatusGrupoRepository statusGrupoRepository;
	@Inject
	private PessoaService pessoaService;

	private List<StatusGrupo> statusGrupoRaizes;

	private StatusGrupo statusGrupoSelecionado;

	private List<Grupo> grupos;

	private Pessoa pessoa;

	private Grupo grupo;

	private List<Grupo> gruposDaPessoa;

	private boolean tipoCadastroMedicamento = true;

	private boolean tipoCadastroIntolerancia = true;
	
	private int tabIndex = 0;

	public CadastroPessoaBean() {
		iniciarTela();
	}

	private void iniciarTela() {
		pessoa = Pessoa.newInstance();
		atualizarGruposPessoa();
	}

	public void consultaStatusGrupo() {
		statusGrupoRaizes = statusGrupoRepository.todosStatusGrupos();
	}

	public void carregarNomeGrupo() {
		grupos = statusGrupoRepository.carregarNomeGrupo(statusGrupoSelecionado);
	}

	public void salvar() {
		pessoa = pessoaService.salvar(pessoa);
		iniciarTela();
		FacesUtil.addInfoMessage("Pessoa cadastrada com sucesso!");
	}

	public void adicionarGrupo() {
		boolean anyMatch = gruposDaPessoa.stream().anyMatch(g -> Objects.equals(g, grupo));
		if(anyMatch) {
			FacesUtil.addErrorMessage("addGrupoMsg", "Grupo já adicionado!");
		}else {
			pessoa.adicionar(grupo);
			atualizarGruposPessoa();
			atualizaTab();
			grupo = new Grupo();
			FacesUtil.addInfoMessage("addGrupoMsg", "Grupo adicionado com sucesso!");
		}
	}

	private void atualizaTab() {
		int tabGrupoPessoa = 4;
		tabIndex = tabGrupoPessoa;
	}

	private void atualizarGruposPessoa() {
		gruposDaPessoa = pessoa.getGrupos();
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public List<StatusGrupo> getStatusGrupoRaizes() {
		return statusGrupoRaizes;
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
	
	public int getTabIndex() {
		return tabIndex;
	}
	
	public void setTabIndex(int tabIndex) {
		this.tabIndex = tabIndex;
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

	public List<Grupo> getGruposDaPessoa() {
		return gruposDaPessoa;
	}

}
