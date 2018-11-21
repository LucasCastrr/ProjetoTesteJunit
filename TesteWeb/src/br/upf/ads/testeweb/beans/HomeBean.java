package br.upf.ads.testeweb.beans;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.faces.bean.ManagedBean;

import org.primefaces.context.RequestContext;

@ManagedBean
public class HomeBean implements Serializable {

	public void abrirPopup(String url, int largura, int altura, boolean modal) {
		Map<String, Object> options = new HashMap<String, Object>();
		options.put("modal", modal);
		options.put("width", largura);
		options.put("height", altura);
		options.put("contentWidth", "100%");
		options.put("contentHeight", "100%");
		options.put("headerElement", "customheader");
		options.put("resizable", false);
		options.put("minimizable", true);
		options.put("maximizable", true);
		RequestContext.getCurrentInstance().openDialog(url, options, null);
	}

}
