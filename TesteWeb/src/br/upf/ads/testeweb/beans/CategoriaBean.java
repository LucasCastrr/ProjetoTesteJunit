package br.upf.ads.testeweb.beans;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;


import br.upf.ads.testejpa.beans.Categoria;
import br.upf.ads.testejpa.utils.FactorySingleton;
import br.upf.ads.testejpa.utils.TrataException;


@ManagedBean
@SessionScoped
public class CategoriaBean {
	  private List<Categoria> lista; // Vinculado com o datatable para listar as grupos
	    private Categoria obj; // Vinculado com o formulário para edição dos atributos

		
	
		
		public CategoriaBean() {
			super();
		}

		public String incluir() { // vinculado como action do botão incluir
			obj = new Categoria();
			return "CategoriaForm.xhtml";
		}
		
		public String alterar() { // vinculado como action do botão alterar
			if (obj != null){
			    return "CategoriaAtualizaForm.xhtml";
			}else {
				FacesContext context = FacesContext.getCurrentInstance();
		        context.addMessage(null, new FacesMessage("Atenção",  "Selecione uma categoria primeiro!") );
				return "";
			}
		}	
		
		public String cancelar() { // vinculado como action do botão cancelar
			obj = null;
			return "CategoriaList.xhtml";
		}	
		
		public String gravar() {
			try {
				EntityManager em = FactorySingleton.getEntityManager();
				em.getTransaction().begin();
				em.merge(obj);
				em.getTransaction().commit();
				em.close();
				obj = null;
				FacesContext context = FacesContext.getCurrentInstance();
				context.addMessage(null, new FacesMessage("",  "Categoria cadastrada com sucesso!") );
				return "CategoriaList.xhtml";
			} catch (Exception e) {
				e.printStackTrace();
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(TrataException.getMessage(e), "Não é permitido valores duplicados"));
			}
			return "";	
		}

		
		public String atualizar() {
			try {
				EntityManager em = FactorySingleton.getEntityManager();
				em.getTransaction().begin();
				em.merge(obj);
				em.getTransaction().commit();
				em.close();
				obj = null;
				FacesContext context = FacesContext.getCurrentInstance();
				context.addMessage(null, new FacesMessage("",  "Categoria alterada com sucesso!") );
				return "CategoriaList.xhtml";
			} catch (Exception e) {
				e.printStackTrace();
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(TrataException.getMessage(e), "Não é permitido valores duplicados"));
			}
			return "";	
		}
		
		public String excluir() { // vinculado como action do botão alterar
			if (obj != null){
				try {
					EntityManager em = FactorySingleton.getEntityManager();
					em.getTransaction().begin();
					em.remove(em.merge(obj)); 
					em.getTransaction().commit();
					em.close();
					obj = null;
					FacesContext context = FacesContext.getCurrentInstance();
					context.addMessage(null, new FacesMessage("",  "Categoria excluida com sucesso!") );
				    return "CategoriaList.xhtml"; 
				} catch (Exception e) {
					e.printStackTrace();
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(TrataException.getMessage(e), ""));
				}			
			}else {
				FacesContext context = FacesContext.getCurrentInstance();
		        context.addMessage(null, new FacesMessage("Atenção",  "Selecione uma categoria primeiro!") );
			}
			return "";
		}	
		
		public void carregarLista() {
			EntityManager em = FactorySingleton.getEntityManager();
			lista = em.createQuery("from Categoria").getResultList();
			em.close();		
		}	
		
		public List<Categoria> getLista() {
			return lista;
		}

		public void setLista(List<Categoria> lista) {
			this.lista = lista;
		}

		public Categoria getObj() {
			return obj;
		}

		public void setObj(Categoria obj) {
			this.obj = obj;
		}
	    

}
