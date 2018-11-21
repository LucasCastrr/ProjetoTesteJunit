package br.upf.ads.testeweb.beans;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;

import br.upf.ads.testejpa.beans.Disciplina;
import br.upf.ads.testejpa.beans.Categoria;
import br.upf.ads.testejpa.beans.Conteudo;
import br.upf.ads.testejpa.utils.FactorySingleton;
import br.upf.ads.testejpa.utils.TrataException;



@ManagedBean
@SessionScoped
public class ConteudoBean {
	private List<Conteudo> lista; // Vinculado com o datatable para listar as grupos
	private Conteudo obj; // Vinculado com o formulário para edição dos atributos

	public ConteudoBean() {
		super();
	}
	

	//método para busca os objetos ao digitar para mostrar no cadastro de conteudo
	public List<Categoria> completeCategoria(String query) {
		EntityManager em = FactorySingleton.getEntityManager();
		List<Categoria> results = em.createQuery(
				"from Categoria where upper(descricao) like " + "'" + query.trim().toUpperCase() + "%' " + "order by descricao")
				.getResultList();
		em.close();
		return results;
	}
	

	//método para busca os objetos ao digitar para mostrar no cadastro de conteudo
		public List<Disciplina> completeDisciplina(String query) {
			EntityManager em = FactorySingleton.getEntityManager();
			List<Disciplina> results = em.createQuery(
					"from Disciplina where upper(descricao) like " + "'" + query.trim().toUpperCase() + "%' " + "order by descricao")
					.getResultList();
			em.close();
			return results;
		}

	
	
	
	public String incluir() { // vinculado como action do botão incluir
		obj = new Conteudo();
		return "ConteudoForm.xhtml";
	}

	public String alterar() { // vinculado como action do botão alterar
		if (obj != null) {
			return "ConteudoAtualizaForm.xhtml";
		} else {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage("Atenção", "Selecione um objeto primeiro!"));
			return "";
		}
	}

	public String cancelar() { // vinculado como action do botão cancelar
		obj = null;
		return "ConteudoList.xhtml";
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
			context.addMessage(null, new FacesMessage("",  "Conteudo cadastrado com sucesso!") );
			return "ConteudoList.xhtml";
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
			context.addMessage(null, new FacesMessage("",  "Conteudo alterado com sucesso!") );
			return "ConteudoList.xhtml";
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
				context.addMessage(null, new FacesMessage("",  "Conteudo excluido com sucesso!") );
			    return "ConteudoList.xhtml"; 
			} catch (Exception e) {
				e.printStackTrace();
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(TrataException.getMessage(e), ""));
			}			
		}else {
			FacesContext context = FacesContext.getCurrentInstance();
	        context.addMessage(null, new FacesMessage("Atenção",  "Selecione um objeto primeiro!") );
		}
		return "";
	}

	public void carregarLista() {
		EntityManager em = FactorySingleton.getEntityManager();
		lista = em.createQuery("from Conteudo").getResultList();
		em.close();
	}

	public List<Conteudo> getLista() {
		return lista;
	}

	public void setLista(List<Conteudo> lista) {
		this.lista = lista;
	}

	public Conteudo getObj() {
		return obj;
	}

	public void setObj(Conteudo obj) {
		this.obj = obj;
	}

}
