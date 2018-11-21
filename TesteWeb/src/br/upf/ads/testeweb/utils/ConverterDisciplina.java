package br.upf.ads.testeweb.utils;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import javax.persistence.EntityManager;

import br.upf.ads.testejpa.beans.Disciplina;
import br.upf.ads.testejpa.utils.FactorySingleton;

@FacesConverter(value = "disciplinaConverter")
public class ConverterDisciplina implements Converter{

	public Disciplina getAsObject(FacesContext fc, UIComponent uic, String value) {
		if (value != null && value.trim().length() > 0) {
			try {
				EntityManager em = FactorySingleton.getEntityManager();
				Disciplina ret = em.find(Disciplina.class, Long.parseLong(value));
				em.close();
				return ret;
			} catch (NumberFormatException e) {
				throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"Erro de Conversão do Disciplina", "Disciplina inválido."));
			}
		} else
			return null;
	}

	public String getAsString(FacesContext fc, UIComponent uic, Object object) {
		if (object != null) {
			return String.valueOf(((Disciplina) object).getId());
		} else
			return null;
	}
}
