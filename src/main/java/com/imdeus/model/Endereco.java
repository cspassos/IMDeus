package com.imdeus.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Entity
@Table(name = "endereco")
public class Endereco implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String logradouro;
	private String numero;
	private String cidade;
	private String uf;
	private String cep;
	private String complemento;
	private Pessoa pessoa;

	protected Endereco() {
	}

	public Endereco(String numero, String logradouro, String cidade, String uf) {
		this.numero = numero;
		this.logradouro = logradouro;
		this.cidade = cidade;
		this.uf = uf;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // id auto-incremento
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	// @NotBlank @Size(max = 150)
	@Column(nullable = false, length = 150)
	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	// @NotBlank @Size(max = 10)
	@Column(nullable = false, length = 10)
	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	// @NotBlank @Size(max = 60)
	@Column(nullable = false, length = 60)
	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	// @NotBlank @Size(max = 10)
	@Column(nullable = false, length = 10)
	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	// @NotBlank @Size(max = 9)
	@Column(length = 9)
	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	// @Size(max = 150)
	@Column(length = 150)
	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	// muitos endereços possui um cliente
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_pessoa", foreignKey=@ForeignKey(name = "fk_endereco_id_pessoa"))
	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	// Define que o endereço é unico pelo id
	// botato direito/source/generete hashcode...
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	// Define que o endereço é unico pelo id
	// botato direito/source/generete hashcode...
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Endereco other = (Endereco) obj;
		if (id != other.id)
			return false;
		return true;
	}

	public void add(Endereco endereco) {
		// TODO Auto-generated method stub

	}
	
	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
				.append(id)
				.append(cep).toString();
	}

}
