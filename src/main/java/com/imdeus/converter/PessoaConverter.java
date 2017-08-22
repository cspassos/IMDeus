package com.imdeus.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.imdeus.model.Pessoa;
import com.imdeus.repository.PessoaRepository;

@FacesConverter(managed = true, value = "pessoaConverter")
public class PessoaConverter implements Converter<Pessoa> {
	
	public static final Logger logger = Logger.getLogger(PessoaConverter.class);

	@Inject
	private PessoaRepository pessoaRepository;

	@Override
	public Pessoa getAsObject(FacesContext context, UIComponent component, String value) {
		Pessoa retorno = null;

		if (value != null) {
			Long id = new Long(value);
			retorno = pessoaRepository.porId(id);
			logger.info("value: " + retorno);
		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Pessoa value) {

		if (value != null) {
			logger.info("value: " + value);
			return value.getId().toString();
		}
		return "";
	}

}
