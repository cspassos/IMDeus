package com.imdeus.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "complemento_pessoa")
public class ComplementoPessoa implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String nomeMae;
	private String nomePai;
	private String celularMae;
	private String celularPai;
	private String observacao;
	private Pessoa pessoa;

	@Id
	@GeneratedValue //id auto-incremento
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name = "nome_mae",nullable = false, length = 100)
	public String getNomeMae() {
		return nomeMae;
	}

	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}
	
	@Column(name = "celular_mae", length = 17)
	public String getCelularMae() {
		return celularMae;
	}
	
	public void setCelularMae(String celularMae) {
		this.celularMae = celularMae;
	}
	
	@Column(name = "nome_pai", nullable = false, length = 100)
	public String getNomePai() {
		return nomePai;
	}

	public void setNomePai(String nomePai) {
		this.nomePai = nomePai;
	}
	
	@Column(name = "celular_pai", length = 17)
	public String getCelularPai() {
		return celularPai;
	}

	public void setCelularPai(String celularPai) {
		this.celularPai = celularPai;
	}
	
	@Column(length = 300)
	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	
	@OneToOne
	@JoinColumn(nullable = false)
	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ComplementoPessoa other = (ComplementoPessoa) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
