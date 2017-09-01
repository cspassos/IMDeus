package com.imdeus.converter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.apache.log4j.Logger;

@FacesConverter(value = "localDateConverter")
public class DateConverter implements Converter<LocalDate> {

	public static final Logger logger = Logger.getLogger(DateConverter.class);

	@Override
	public LocalDate getAsObject(FacesContext context, UIComponent component, String value) {
		LocalDate localDate = LocalDate.parse(value, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		logger.info(localDate);
		return localDate;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, LocalDate value) {
		LocalDate data = (LocalDate) value;

		String dataFormatada = data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		logger.debug(dataFormatada);
		return dataFormatada;
	}

}
