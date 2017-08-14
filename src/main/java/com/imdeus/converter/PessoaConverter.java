package com.imdeus.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.imdeus.model.Pessoa;
import com.imdeus.repository.PessoaRepository;
import com.imdeus.util.cdi.CDIServiceLocator;

@FacesConverter(forClass = Pessoa.class)
public class PessoaConverter implements Converter{
	
	private PessoaRepository pessoaRepository;
	
	public PessoaConverter(){
		pessoaRepository = CDIServiceLocator.getBean(PessoaRepository.class);
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Pessoa retorno = null;
		
		if(value != null){
			Long id = new Long(value);
			retorno = pessoaRepository.porId(id);
		}
		
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		
		if(value != null){
			Pessoa pessoa = (Pessoa) value;
			return pessoa.getId() == null ? null: pessoa.getId().toString();
		}
		return "";
	}

}
