package com.imdeus.controller.grupo;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;

import com.imdeus.repository.PessoaRepository;

@FacesValidator(value = "CadastroPessoaValidator", managed = true)
public class CadastroGrupoValidator implements Validator {

	@Inject
	private PessoaRepository repository;

	@Override
	public void validate(FacesContext arg0, UIComponent arg1, Object cpf) throws ValidatorException {
		FacesMessage message = new FacesMessage();
		String cpfConvertido = (String) cpf;
		if (StringUtils.isBlank(cpfConvertido)) {
			message.setSummary("CPF obrigatório: ");
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(message);
		}

		if (StringUtils.isNotBlank(cpfConvertido)) {
			repository.porCpf(cpfConvertido).ifPresent(p -> {
				message.setSummary("CPF " + cpfConvertido + " já existe!");
				message.setSeverity(FacesMessage.SEVERITY_ERROR);
				throw new ValidatorException(message);
			});
		}

	}

}
