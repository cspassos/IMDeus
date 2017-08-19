package com.imdeus.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import com.imdeus.model.Pessoa;
import com.imdeus.repository.PessoaRepository;

@FacesConverter(managed = true, value = "pessoaConverter")
public class PessoaConverter implements Converter<Pessoa> {

	@Inject
	private PessoaRepository pessoaRepository;

	@Override
	public Pessoa getAsObject(FacesContext context, UIComponent component, String value) {
		Pessoa retorno = null;

		if (value != null) {
			Long id = new Long(value);
			retorno = pessoaRepository.porId(id);
		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Pessoa value) {

		if (value != null) {
			return value.getId().toString();
		}
		return "";
	}

}
