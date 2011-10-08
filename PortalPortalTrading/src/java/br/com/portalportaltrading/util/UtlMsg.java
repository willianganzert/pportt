package br.com.portalportaltrading.util;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import javax.faces.context.FacesContext;

public class UtlMsg {
	private static Locale locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();
	
	public UtlMsg() {		
	}
	
	public static String msg(String sMensagem) {
		
		String sMsg;
		
		sMsg = getMsgBoundle(sMensagem, "br.com.portaltrading.entidades.labels.messages"); // Entities
		if (sMsg == null) {
			sMsg = getMsgBoundle(sMensagem, "br.com.portalportaltrading.labels.messages"); // Api
		}
		return sMsg;
	}  
	
	private static String getMsgBoundle(String sMensagem, String sBundle) {
		String sMsg = null;
		try {
			ResourceBundle bundle = ResourceBundle.getBundle(sBundle, locale);
			sMsg = bundle.getString(sMensagem);
			
		} catch (MissingResourceException ex) {}
		return sMsg;
	}
	
	public String getMsg(String sMensagem) {
		String sMsg = msg(sMensagem);
		return sMsg;
	}
}
