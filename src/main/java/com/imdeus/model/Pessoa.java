package com.imdeus.model;

import java.io.Serializable;
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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Entity
@Table(name = "pessoa")
public class Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String nome;
	private Integer idade;
	private String email;
	private String celular;
	
	private Endereco endereco;
	private ComplementoPessoa complementoPessoa;
	private Set<GrupoPessoa> gruposPessoas;

	protected Pessoa() {
	}

	public Pessoa(String nome, Integer idade, String email, String celular, Endereco endereco,
			ComplementoPessoa complementoPessoa) {
		this(nome, idade, email, celular);
		this.endereco = endereco;
		this.complementoPessoa = complementoPessoa;
	}

	public Pessoa(String nome, Integer idade, String email, String celular) {
		this.nome = nome;
		this.idade = idade;
		this.email = email;
		this.celular = celular;
	}

	public static Pessoa newInstance() {
		Pessoa pessoa = new Pessoa();
		pessoa.setComplementoPessoa(new ComplementoPessoa());
		pessoa.setEndereco(new Endereco());
		pessoa.setGruposPessoas(new HashSet<>());
		return pessoa;
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

	@NotNull
	@Column(nullable = false, length = 11)
	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	@NotBlank
	@Size(max = 255)
	@Column(nullable = false, length = 255)
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

	// uma pessoa possui muitos endereços
	// mappedBy -> esse relacionamento que criei é o inverso do que mapiei na
	// entidade endereço.
	// cascade -> quando salvar uma pessoa automaticamente vai persistir os
	// endereços do cliente
	@NotNull
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "pessoa", fetch = FetchType.LAZY)
	public Endereco getEndereco() {
		return endereco;
	}

	// Usa-se o endereco.setPessoa(this); -> para persistir o pessoa_id na
	// tabela de
	// endereco.
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
		// endereco.setPessoa(this);
	}

	@NotNull
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "pessoa", fetch = FetchType.LAZY)
	public ComplementoPessoa getComplementoPessoa() {
		return complementoPessoa;
	}

	// Usa-se o complementoPessoa.setPessoa(this); -> para persistir o pessoa_id
	// na
	// tabela de complementoPessoa.
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
		if(gruposPessoas == null)
			return Collections.emptyList();
		return gruposPessoas.stream().map(GrupoPessoa::getGrupo).collect(Collectors.toList());
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}

}
