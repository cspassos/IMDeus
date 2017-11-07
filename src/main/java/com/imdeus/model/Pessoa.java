package com.imdeus.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.validator.constraints.br.CPF;

@Entity
@Table(name = "pessoa")
public class Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private String nome;

	private String email;

	private String celular;

	private String cpf;

	private LocalDate nascimento;

	private Endereco endereco;

	private ComplementoPessoa complementoPessoa;

	private Set<GrupoPessoa> gruposPessoas;

	private LocalDateTime criacao;

	protected Pessoa() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@NotBlank
	@Size(max = 100)
	@Column(nullable = false, length = 100)
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Email
	@NotBlank
	@Column(nullable = false, length = 150)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@NotBlank
	@Size(max = 17)
	@Column(nullable = false, length = 17)
	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	@NotNull
	@Column(nullable = false)
	public LocalDate getNascimento() {
		return nascimento;
	}

	public void setNascimento(LocalDate nascimento) {
		this.nascimento = nascimento;
	}

	@CPF
	@Column(nullable = false, length = 20)
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@NotNull
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "pessoa", fetch = FetchType.LAZY)
	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
		// endereco.setPessoa(this);
	}

	@NotNull
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "pessoa", fetch = FetchType.LAZY)
	public ComplementoPessoa getComplementoPessoa() {
		return complementoPessoa;
	}

	public void setComplementoPessoa(ComplementoPessoa complementoPessoa) {
		this.complementoPessoa = complementoPessoa;
		// complementoPessoa.setPessoa(this);
	}

	@NotNull
	@OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL, orphanRemoval = true)
	public Set<GrupoPessoa> getGruposPessoas() {
		return gruposPessoas;
	}

	public void setGruposPessoas(Set<GrupoPessoa> gruposPessoas) {
		this.gruposPessoas = gruposPessoas;
	}

	public LocalDateTime getCriacao() {
		return criacao;
	}

	public void setCriacao(LocalDateTime criacao) {
		this.criacao = criacao;
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
		Pessoa other = (Pessoa) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}

	public static Pessoa newInstance() {
		Pessoa pessoa = new Pessoa();
		pessoa.setComplementoPessoa(new ComplementoPessoa());
		pessoa.setEndereco(new Endereco());
		pessoa.setGruposPessoas(new HashSet<>());
		return pessoa;
	}

	public void adicionar(Grupo grupo) {
		GrupoPessoa grupoPessoa = new GrupoPessoa(grupo, this);
		gruposPessoas.add(grupoPessoa);
		grupo.getGruposPessoas().add(grupoPessoa);
	}

	public void remover(Grupo grupo) {
		for (Iterator<GrupoPessoa> iterator = gruposPessoas.iterator(); iterator.hasNext();) {
			GrupoPessoa grupoPessoa = iterator.next();

			if (grupoPessoa.getPessoa().equals(this) && grupoPessoa.getGrupo().equals(grupo)) {
				iterator.remove();
				grupoPessoa.getGrupo().getGruposPessoas().remove(grupoPessoa);
				grupoPessoa.setPessoa(null);
				grupoPessoa.setGrupo(null);
			}
		}
	}

	@Transient
	public List<Grupo> getGrupos() {
		if (gruposPessoas == null)
			return Collections.emptyList();
		return gruposPessoas.stream().map(GrupoPessoa::getGrupo).collect(Collectors.toList());
	}

}
