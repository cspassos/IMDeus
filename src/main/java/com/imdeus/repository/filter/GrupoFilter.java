//VAI SER UTILIZADO PARA O FILTRO DE PESQUISA DE Grupo

package com.imdeus.repository.filter;

import java.io.Serializable;


public class GrupoFilter implements Serializable {

	private static final long serialVersionUID = 1L;

	private String nomeStatus;
	private String nomeGrupo;
	
	public String getNomeStatus() {
		return nomeStatus;
	}
	public void setNomeStatus(String nomeStatus) {
		this.nomeStatus = nomeStatus;
	}
	public String getNomeGrupo() {
		return nomeGrupo;
	}
	public void setNomeGrupo(String nomeGrupo) {
		this.nomeGrupo = nomeGrupo;
	}
	@Override
	public String toString() {
		return "GrupoFiltro [nomeStatus=" + nomeStatus + ", nomeGrupo=" + nomeGrupo + "]";
	}
	
}
