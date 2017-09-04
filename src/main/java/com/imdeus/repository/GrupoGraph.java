package com.imdeus.repository;

public class GrupoGraph {
	
	private String nomeStatus;
	
	private long qtdeGrupos;
	
	public GrupoGraph() { }
	
	public GrupoGraph(String nomeStatus, long qtdeGrupos) {
		this.nomeStatus = nomeStatus;
		this.qtdeGrupos = qtdeGrupos;
	}

	public String getNomeStatus() {
		return nomeStatus;
	}

	public void setNomeStatus(String nomeStatus) {
		this.nomeStatus = nomeStatus;
	}

	public long getQtdeGrupos() {
		return qtdeGrupos;
	}

	public void setQtdeGrupos(long qtdeGrupos) {
		this.qtdeGrupos = qtdeGrupos;
	}
	
}
