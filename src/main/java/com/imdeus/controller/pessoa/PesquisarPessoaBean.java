package com.imdeus.controller.pessoa;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;

import com.imdeus.model.Grupo;
import com.imdeus.model.Pessoa;
import com.imdeus.repository.filter.PessoaFilter;
import com.imdeus.service.GrupoService;
import com.imdeus.service.PessoaService;

@Named
@ViewScoped
public class PesquisarPessoaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private PessoaService pessoaService;
	@Inject
	private GrupoService grupoService;

	private PessoaFilter filtro;

	private List<Pessoa> pessoasFiltrados;

	@PostConstruct
	public void init() {
		filtro = new PessoaFilter();
	}

	//TODO: realizar pesquisa ao banco mas performatica
	//Esta retornando uma consulta com pessoas
	//E outra consulta com os enderecos, tem que ser tudo junto
	public void consultaPessoa() {
		pessoasFiltrados = pessoaService.todas(filtro);
	}

	//TODO: realizar consulta no banco apenas quando o usuario apagou o que escreveu de inicio
	//tipo: digitou a, traz todos os resultados comecado com a, 
	//e a partir da ai, trabalhar apenas nesta lista que foi retornada
	//mas se apagou todo o valor do campo, e iniciou uma nova busca por exemplo com b
	//fara o mesmo processo acima
	public List<Grupo> grupoAutoComplete(String query) {
		List<Grupo> filteredThemes = new ArrayList<Grupo>();
		if (StringUtils.isNotBlank(query)) {
			List<Grupo> allThemes = grupoService.comecadosCom(query);

			for (int i = 0; i < allThemes.size(); i++) {
				Grupo skin = allThemes.get(i);
				if (skin.getNome().toLowerCase().startsWith(query)) {
					filteredThemes.add(skin);
				}
			}
		}

		return filteredThemes;
	}

	public PessoaFilter getFiltro() {
		return filtro;
	}

	public void setFiltro(PessoaFilter filtro) {
		this.filtro = filtro;
	}

	public List<Pessoa> getTodasPessoas() {
		return pessoasFiltrados;
	}
}
