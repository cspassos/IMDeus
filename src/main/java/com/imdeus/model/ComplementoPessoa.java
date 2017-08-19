package com.imdeus.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	private String qualMedicamento;
	private String qualAlergia;
	private Pessoa pessoa;
	
	protected ComplementoPessoa() {
	}

	public ComplementoPessoa(String nomeMae, String nomePai, String observacao) {
		this.nomeMae = nomeMae;
		this.nomePai = nomePai;
		this.observacao = observacao;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) // id auto-incremento
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	// @NotBlank @Size(max = 100)
	@Column(name = "nome_mae", nullable = false, length = 100)
	public String getNomeMae() {
		return nomeMae;
	}

	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}

	// @NotBlank @Size(max = 17)
	@Column(name = "celular_mae", length = 17)
	public String getCelularMae() {
		return celularMae;
	}

	public void setCelularMae(String celularMae) {
		this.celularMae = celularMae;
	}

	// @NotBlank @Size(max = 100)
	@Column(name = "nome_pai", nullable = false, length = 100)
	public String getNomePai() {
		return nomePai;
	}

	public void setNomePai(String nomePai) {
		this.nomePai = nomePai;
	}

	// @NotBlank @Size(max = 17)
	@Column(name = "celular_pai", length = 17)
	public String getCelularPai() {
		return celularPai;
	}

	public void setCelularPai(String celularPai) {
		this.celularPai = celularPai;
	}

	// @Size(max = 300)
	@Column(length = 300)
	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	// @Size(max = 300)
	@Column(length = 255)
	public String getQualMedicamento() {
		return qualMedicamento;
	}

	public void setQualMedicamento(String qualMedicamento) {
		this.qualMedicamento = qualMedicamento;
	}

	// @Size(max = 300)
	@Column(length = 255)
	public String getQualAlergia() {
		return qualAlergia;
	}

	public void setQualAlergia(String qualAlergia) {
		this.qualAlergia = qualAlergia;
	}

	@OneToOne
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
