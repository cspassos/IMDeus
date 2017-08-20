package com.imdeus.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.imdeus.model.StatusGrupo;
import com.imdeus.repository.StatusGrupoRepository;

@FacesConverter(managed = true, value = "statusGrupoConverter")
public class StatusGrupoConverter implements Converter<StatusGrupo> {
	
	public static final Logger logger = Logger.getLogger(StatusGrupoConverter.class);

	@Inject
	private StatusGrupoRepository statusGrupoRepository;

	@Override
	public StatusGrupo getAsObject(FacesContext context, UIComponent component, String value) {
		StatusGrupo retorno = null;

		if (value != null) {
			Long id = new Long(value);
			logger.info("Converter getAsObject: " + getClass().getSimpleName());
			retorno = statusGrupoRepository.porId(id);
		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, StatusGrupo value) {

		if (value != null) {
			logger.info("Converter getAsString: " + getClass().getSimpleName());
			return value.getId().toString();
		}
		return "";
	}
}
