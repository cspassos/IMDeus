package com.imdeus.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.imdeus.model.StatusGrupo;
import com.imdeus.repository.StatusGrupoRepository;
import com.imdeus.util.cdi.CDIServiceLocator;

@FacesConverter(forClass = StatusGrupo.class)
public class StatusGrupoConverter implements Converter{
	
	private StatusGrupoRepository statusGrupoRepository;
	
	public StatusGrupoConverter(){
		statusGrupoRepository = CDIServiceLocator.getBean(StatusGrupoRepository.class);
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		StatusGrupo retorno = null;
		
		if(value != null){
			Long id = new Long(value);
			retorno = statusGrupoRepository.porId(id);
		}
		
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		
		if(value != null){
			return ((StatusGrupo) value).getId().toString();
		}
		return "";
	}
}
