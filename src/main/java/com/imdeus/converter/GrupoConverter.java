package com.imdeus.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import com.imdeus.model.Grupo;
import com.imdeus.repository.GrupoRepository;

@FacesConverter(managed = true, value = "grupoConverter")
public class GrupoConverter implements Converter<Grupo> {

	@Inject
	private GrupoRepository grupoRepository;

	@Override
	public Grupo getAsObject(FacesContext context, UIComponent component, String value) {
		Grupo retorno = null;

		if (value != null) {
			Long id = new Long(value);
			retorno = grupoRepository.porId(id);
		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Grupo value) {

		if (value != null) {
			return value.getId().toString();
		}
		return "";
	}

}
