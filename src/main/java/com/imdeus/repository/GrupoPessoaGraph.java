package com.imdeus.repository;

public class GrupoPessoaGraph {

	private long qtdePessoas;

	private Integer criacao;

	private String nomeGrupo;

	public GrupoPessoaGraph() {
	}

	public GrupoPessoaGraph(long qtdePessoas, Integer criacao, String nomeGrupo) {
		this.qtdePessoas = qtdePessoas;
		this.criacao = criacao;
		this.nomeGrupo = nomeGrupo;
	}

	public GrupoPessoaGraph(long qtdePessoas, String nomeGrupo) {
		this.qtdePessoas = qtdePessoas;
		this.nomeGrupo = nomeGrupo;
	}

	public Integer getCriacao() {
		return criacao;
	}

	public void setCriacao(Integer criacao) {
		this.criacao = criacao;
	}

	public long getQtdePessoas() {
		return qtdePessoas;
	}

	public void setQtdePessoas(long qtdePessoas) {
		this.qtdePessoas = qtdePessoas;
	}

	public String getNomeGrupo() {
		return nomeGrupo;
	}

	public void setNomeGrupo(String nomeGrupo) {
		this.nomeGrupo = nomeGrupo;
	}

}
