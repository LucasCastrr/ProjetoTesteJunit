package br.upf.ads.testejpa.utils;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.upf.ads.testejpa.beans.Categoria;

public class FactorySingleton {
   private static final EntityManagerFactory factory = 
		                Persistence.createEntityManagerFactory("TesteJPA");
   
   public static EntityManager getEntityManager() {
	   return factory.createEntityManager();
   }
   
   
   public String findCategoriaByDescricao(String descricao)
	{
		EntityManager em = FactorySingleton.getEntityManager();
	    List<Categoria> dcat = em.createQuery("Select descricao From Categoria where descricao:descricao ",
	                                                        Categoria.class).getResultList();
	    return descricao;
	}
    
}
