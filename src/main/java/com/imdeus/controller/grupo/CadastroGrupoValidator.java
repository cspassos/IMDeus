package com.imdeus.controller.grupo;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;

import com.imdeus.repository.GrupoRepository;

@FacesValidator(value = "CadastroGrupoValidator", managed = true)
public class CadastroGrupoValidator implements Validator {

	@Inject
	private GrupoRepository repository;

	@Override
	public void validate(FacesContext arg0, UIComponent arg1, Object arg2) throws ValidatorException {
		FacesMessage message = new FacesMessage();
		if (StringUtils.isBlank((String) arg2)) {
			message.setSummary("Nome obrigatório: ");
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(message);
		}

		if (StringUtils.isNotBlank((String) arg2)) {
			repository.porNome((String) arg2).ifPresent(g -> {
				message.setSummary("Nome do Grupo " + g.getNome() + " já existe!");
				message.setSeverity(FacesMessage.SEVERITY_ERROR);
				throw new ValidatorException(message);
			});
		}

	}

}
