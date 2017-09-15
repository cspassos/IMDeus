package com.imdeus.util.jsf;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class FacesUtil {

	public static boolean isPostback(){
		return FacesContext.getCurrentInstance().isPostback();
	}
	 
	public static boolean isNotPostback(){
		return !isPostback();
	}
	
	public static void addErrorMessage(String message) {
		addErrorMessage(message);
	}
	
	public static void addErrorMessage(String key, String message) {
		FacesContext.getCurrentInstance().addMessage(key, 
				new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message));
	}
	
	public static void addInfoMessage(String message) {
		addInfoMessage(null, message);
	}
	
	public static void addInfoMessage(String key, String message) {
		FacesContext.getCurrentInstance().addMessage(key, 
				new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
	}
	
	
}
