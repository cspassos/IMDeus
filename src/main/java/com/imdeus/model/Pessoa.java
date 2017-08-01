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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Cascade;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "pessoa")
public class Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String nome;
	private String idade;
	private String email;
	private String celular;
	private Endereco endereco;
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
	
	@NotBlank @Size(max = 100)
	@Column(nullable = false, length = 100)
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Size(max = 2)
	@Column(nullable = false, length = 2)
	public String getIdade() {
		return idade;
	}
	
	public void setIdade(String idade) {
		this.idade = idade;
	}
	
	@NotBlank @Size(max = 255)
	@Column(nullable = false, length = 255)
	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
	
	@NotBlank @Size(max = 17)
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
	@OneToOne
	public Endereco getEndereco() {
		return endereco;
	}
	
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
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
