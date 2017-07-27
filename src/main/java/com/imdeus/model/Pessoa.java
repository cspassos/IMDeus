package com.imdeus.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name = "pessoa")
public class Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String nome;
	private String email;
	private String celular;
	private List<Endereco> enderecos = new ArrayList<>();
	private List<Grupo> grupo = new ArrayList<>();
	private ComplementoPessoa complementoPessoa;
	
	
	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(nullable = false, length = 100)
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Column(nullable = false, length = 255)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column(nullable = false, length = 17)
	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}
	
	//uma pessoa possui muitos endereços
	//mappedBy -> esse relacionamento que criei é o inverso do que mapiei na entidade endereço.
	//cascade -> quando salvar uma pessoa automaticamente vai persistir os endereços do cliente
	@OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL)
	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}
	
	@ManyToMany
	public List<Grupo> getGrupo() {
		return grupo;
	}

	public void setGrupo(List<Grupo> grupo) {
		this.grupo = grupo;
	}
	
	@OneToOne
	public ComplementoPessoa getComplementoPessoa() {
		return complementoPessoa;
	}

	public void setComplementoPessoa(ComplementoPessoa complementoPessoa) {
		this.complementoPessoa = complementoPessoa;
	}

	// Define que o pessoa é unico pelo id
	// botato direito/source/generete hashcode...
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	// Define que a pessoa é unico pelo id
	// botato direito/source/generete hashcode...
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
