package com.imdeus.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.imdeus.model.Grupo;
import com.imdeus.repository.GrupoRepository;
import com.imdeus.util.cdi.CDIServiceLocator;

@FacesConverter(forClass = Grupo.class)
public class GrupoConverter implements Converter{
	
	private GrupoRepository grupoRepository;
	
	public GrupoConverter(){
		grupoRepository = CDIServiceLocator.getBean(GrupoRepository.class);
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Grupo retorno = null;
		
		if(value != null){
			Long id = new Long(value);
			retorno = grupoRepository.porId(id);
		}
		
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		
		if(value != null){
			Grupo grupo = (Grupo) value;
			return grupo.getId() == null ? null: grupo.getId().toString();
		}
		return "";
	}
}
