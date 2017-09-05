package com.imdeus.repository;

import java.time.LocalDateTime;
import java.util.Map;

public class GrupoPessoaGraph {

	private long qtdePessoas;

	private String nomeGrupo;

	private LocalDateTime ano;

	private Map<String, Map<Long, Long>> gruposGrafico;
	private Map<Long, Long> gruposGrafico2;

	public GrupoPessoaGraph() {
	}

	public GrupoPessoaGraph(Map<String, Map<Long, Long>> gruposGrafico) {
		this.gruposGrafico = gruposGrafico;
	}

	// public GrupoPessoaGraph(String nomeGrupo, Map<Long, Long> gruposGrafico2) {
	// this.nomeGrupo = nomeGrupo;
	// this.gruposGrafico2 = gruposGrafico2;
	// }

	public GrupoPessoaGraph(long qtdePessoas, String nomeGrupo) {
		this.qtdePessoas = qtdePessoas;
		this.nomeGrupo = nomeGrupo;
	}

	public GrupoPessoaGraph(long qtdePessoas, String nomeGrupo, LocalDateTime ano) {
		this.qtdePessoas = qtdePessoas;
		this.nomeGrupo = nomeGrupo;
		this.ano = ano;
	}

	public Map<String, Map<Long, Long>> getGruposGrafico() {
		return gruposGrafico;
	}

	public void setGruposGrafico(Map<String, Map<Long, Long>> gruposGrafico) {
		this.gruposGrafico = gruposGrafico;
	}

	public Map<Long, Long> getGruposGrafico2() {
		return gruposGrafico2;
	}

	public void setGruposGrafico2(Map<Long, Long> gruposGrafico2) {
		this.gruposGrafico2 = gruposGrafico2;
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

	public LocalDateTime getAno() {
		return ano;
	}

	public void setAno(LocalDateTime ano) {
		this.ano = ano;
	}

}
