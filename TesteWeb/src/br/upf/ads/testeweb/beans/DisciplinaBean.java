package br.upf.ads.testeweb.beans;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;

import br.upf.ads.testejpa.beans.Disciplina;
import br.upf.ads.testejpa.utils.FactorySingleton;
import br.upf.ads.testejpa.utils.TrataException;



@ManagedBean
@SessionScoped
public class DisciplinaBean {
	
	private List<Disciplina> lista; // Vinculado com o datatable para listar as grupos
    private Disciplina obj; // Vinculado com o formulário para edição dos atributos

	
	
	public DisciplinaBean() {
		super();
	}

	public String incluir() { // vinculado como action do botão incluir
		obj = new Disciplina();
		return "DisciplinaForm.xhtml";
	}
	
	public String alterar() { // vinculado como action do botão alterar
		if (obj != null){
		    return "DisciplinaAtualizaForm.xhtml";
		}else {
			FacesContext context = FacesContext.getCurrentInstance();
	        context.addMessage(null, new FacesMessage("Atenção",  "Selecione uma disciplina primeiro!") );
			return "";
		}
	}	
	
	public String cancelar() { // vinculado como action do botão cancelar
		obj = null;
		return "DisciplinaList.xhtml";
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
			context.addMessage(null, new FacesMessage("",  "Disciplina cadastrada com sucesso!") );
			return "DisciplinaList.xhtml";
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
			context.addMessage(null, new FacesMessage("",  "Disciplina alterada com sucesso!") );
			return "DisciplinaList.xhtml";
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
				context.addMessage(null, new FacesMessage("",  "Disciplina excluida com sucesso!") );
			    return "DisciplinaList.xhtml"; 
			} catch (Exception e) {
				e.printStackTrace();
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(TrataException.getMessage(e), ""));
			}			
		}else {
			FacesContext context = FacesContext.getCurrentInstance();
	        context.addMessage(null, new FacesMessage("Atenção",  "Selecione uma disciplina primeiro!") );
		}
		return "";
	}	
	
	public void carregarLista() {
		EntityManager em = FactorySingleton.getEntityManager();
		lista = em.createQuery("from Disciplina").getResultList();
		em.close();		
	}	
	
	public List<Disciplina> getLista() {
		return lista;
	}

	public void setLista(List<Disciplina> lista) {
		this.lista = lista;
	}

	public Disciplina getObj() {
		return obj;
	}

	public void setObj(Disciplina obj) {
		this.obj = obj;
	}

}
