package com.imdeus.controller.pessoa;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.NotNull;

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

	public CadastroPessoaBean() {
		limparFormulario();
	}

	private void limparFormulario() {
		pessoa = Pessoa.newInstance();
		gruposDaPessoa = pessoa.getGrupos();
	}

	public void consultaStatusGrupo() {
		statusGrupoRaizes = statusGrupoRepository.todosStatusGrupos();
	}

	public void carregarNomeGrupo() {
		grupos = statusGrupoRepository.carregarNomeGrupo(statusGrupoSelecionado);
	}

	public void salvar() {
		pessoa = pessoaService.salvar(pessoa);
		limparFormulario();
		FacesUtil.addInfoMessage("Pessoa cadastrada com sucesso!");
	}

	public void adicionarGrupo() {
		pessoa.adicionar(grupo);
		if (gruposDaPessoa == null)
			gruposDaPessoa = new ArrayList<>();

		atualizarGruposPessoa();
		grupo = new Grupo();
		FacesUtil.addInfoMessage("addGrupoMsg", "Grupo adicionado com sucesso!");
	}

	private void atualizarGruposPessoa() {
		gruposDaPessoa.clear();
		gruposDaPessoa.addAll(pessoa.getGrupos());
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
