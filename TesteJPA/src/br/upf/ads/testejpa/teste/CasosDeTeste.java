package br.upf.ads.testejpa.teste;


import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

import br.upf.ads.testejpa.beans.Categoria;
import br.upf.ads.testejpa.beans.Disciplina;


import br.upf.ads.testejpa.beans.Conteudo;


public class CasosDeTeste  {

	EntityManagerFactory factory = Persistence.createEntityManagerFactory("TesteJPA");
	

	
	
	
	/*CT-006 Verificar se a funcionalidade de incluir categoria esta funcionando                                    
	 * 
	 */
    @Test
	public void testeIncluirCategoria() throws Exception{
		Categoria c = new Categoria();
		c.setId(1L);
		c.setDescricao("Ciências Exatas");
        EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		em.persist(c);
		em.getTransaction().commit();
		
		Categoria cat = em.find(Categoria.class, 1L);
		String ResultadoEsperado = "Ciências Exatas";
		
		String assertionError = null;
        try {
        	assertEquals(ResultadoEsperado, cat.getDescricao());
        	System.out.println("Categoria cadastrada com sucesso!");
        }
        catch (AssertionError ae) {
            assertionError = ae.toString();
            System.out.println(assertionError);
        }
        
		
		
		
		
		//if (cat.getDescricao() == "Ciências Exatas") { System.out.println("Categoria cadastrada com sucesso! "); }else { System.out.println("Erro encontrado");}
		
	}
    
    /*CT-007 Verificar se a funcionalidade de alterar  categoria esta funcionando
     * 
     */
    @Test
	public void testeAlterarCategoria() throws Exception{
        EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		Categoria c = em.find(Categoria.class, 1L);
		c.setDescricao("Ciências");
		em.persist(c);
		em.getTransaction().commit();
		
		Categoria cat = em.find(Categoria.class, 1L);
	    String ResultadoEsperado = "Ciências";
		
		String assertionError = null;
        try {
        	assertEquals(ResultadoEsperado, cat.getDescricao());
            System.out.println("Categoria alterada com sucesso!");
        }
        catch (AssertionError ae) {
            assertionError = ae.toString();
            System.out.println(assertionError);
        }
     
		
		
		//if (cat.getDescricao() != "Ciências Exatas") {System.out.println("Categoria alterada com sucesso! ");}else {;System.out.println("Erro encontrado");}
		
		
	}
   
    
    /*CT-001 Verificar se a funcionalidade de incluir  disciplina esta funcionando
     * 
     */
    @Test
	public void testeIncluirDisciplina() throws Exception {
		Disciplina d = new Disciplina();
		d.setId(1L);
		d.setDescricao("Matematica");
        EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		em.persist(d);
		em.getTransaction().commit();
		
		Disciplina disc = em.find(Disciplina.class, 1L);
		String ResultadoEsperado = "Matematica";
		
		String assertionError = null;
        try {
        	assertEquals(ResultadoEsperado, disc.getDescricao());
        	System.out.println("Disciplina cadastrada com sucesso!");
        }
        catch (AssertionError ae) {
            assertionError = ae.toString();
            System.out.println(assertionError);
        }
        
		
		
		
		/* if (disc.getDescricao() == "Matemática") { System.out.println("Disciplina cadastrada com sucesso! "); }else { System.out.println("Erro encontrado");}*/
		
	}
    
    /*CT-002 Verificar se a funcionalidade de alterar  disciplina esta funcionando
     * 
     */
    @Test
	public void testeAlterarDisciplina() throws Exception {
    	EntityManager em = factory.createEntityManager();
    	em.getTransaction().begin();
		Disciplina d = em.find(Disciplina.class, 1L);
		d.setDescricao("Portugues");
		em.persist(d);
		em.getTransaction().commit();
		
		
		Disciplina disc = em.find(Disciplina.class, 1L);
	    String ResultadoEsperado = "Portugues";
		
		String assertionError = null;
        try {
        	assertEquals(ResultadoEsperado, disc.getDescricao());
        	System.out.println("Disciplina alterada com sucesso!");
        }
        catch (AssertionError ae) {
            assertionError = ae.toString();
            System.out.println(assertionError);
        }
		
		
		//if (disc.getDescricao() != "Matemática)") { System.out.println("Disciplina alterada com sucesso! ");}else {System.out.println("Erro encontrado");}
		
	}
    
   
    /*CT-011 Verificar se a funcionalidade de incluir  conteudo esta funcionando
     * 
     */
	@Test
	public void testeIncluirConteudo() throws Exception {
		EntityManager em = factory.createEntityManager();
		Conteudo c = new Conteudo();
	    c.setId(1L);
		c.setTitulo("titulo1");
		c.setTexto("texto1");
		c.setCategoria(em.find(Categoria.class, 1L));
        c.setDisciplina(em.find(Disciplina.class, 1L));
        em.getTransaction().begin();
		em.persist(c);
		em.getTransaction().commit();
		
        Conteudo cont = em.find(Conteudo.class, 1L);
        
     	String ResultadoEsperado = "titulo1";
     	String ResultadoEsperado2 = "texto1";
		
		String assertionError = null;
        try {
        	assertEquals(ResultadoEsperado, cont.getTitulo());
    		assertEquals(ResultadoEsperado2, cont.getTexto());
    		System.out.println("Conteudo cadastrado com sucesso!");
        }
        catch (AssertionError ae) {
            assertionError = ae.toString();
            System.out.println(assertionError);
        }
      
		
		//if (cont.getTitulo() == "titulo1") { System.out.println("Conteudo cadastrada com sucesso! "); }else {System.out.println("Erro encontrado");}
				
	}
	  /*CT-012 Verificar se a funcionalidade de alterar  conteudo esta funcionando
     * 
     */
	@Test
	public void testeAlterarConteudo() throws Exception {
		EntityManager em = factory.createEntityManager();
	    em.getTransaction().begin();
	    Conteudo c = em.find(Conteudo.class, 1L);
		c.setTitulo("titulo2");
		c.setTexto("texto2");
		c.setCategoria(em.find(Categoria.class, 1L));
        c.setDisciplina(em.find(Disciplina.class, 1L));
		em.persist(c);
		em.getTransaction().commit();
		
        Conteudo cont = em.find(Conteudo.class, 1L);
        
        
      	String ResultadoEsperado = "titulo2";
     	String ResultadoEsperado2 = "texto2";
		
     	String assertionError = null;
        try {
        	assertEquals(ResultadoEsperado, cont.getTitulo());
    		assertEquals(ResultadoEsperado2, cont.getTexto());
    		System.out.println("Conteudo alterado com sucesso!");
        }
        catch (AssertionError ae) {
            assertionError = ae.toString();
            System.out.println(assertionError);
        }
		
		
		//if (cont.getTitulo() != "titulo1" ) {System.out.println("Conteudo alterado com sucesso! ");}else {System.out.println("Erro encontrado");}
		
		
	}
	  /*CT-013 Verificar se a funcionalidade de excluir  categoria esta funcionando
     * 
     */
	@Test
	public void testeExcluirConteudo() throws Exception{
	  	EntityManager em = factory.createEntityManager();
			em.getTransaction().begin();
			Conteudo c = em.find(Conteudo.class, 1L);
			em.remove(c);
			em.getTransaction().commit();
			
			Conteudo cont = em.find(Conteudo.class, 1L);
			
			
			String assertionError = null;
	        try {
	        	/*Assertiva verifica se o Objeto é nulo, senão retorna AssertError*/
				assertNull(cont);
				System.out.println("Conteudo excluido com sucesso!");
	        }
	        catch (AssertionError ae) {
	            assertionError = ae.toString();
	            System.out.println(assertionError);
	        }
	        
			
	}
	
	 /*CT-008 Verificar se a funcionalidade de excluir categoria esta funcionando
     * 
     */
	
	@Test
	public void testeExcluirCategoria() throws Exception{
    	
    	EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		Categoria c = em.find(Categoria.class, 1L);
		em.remove(c);
		em.getTransaction().commit();
		
		Categoria cat = em.find(Categoria.class, 1L);
		
		String assertionError = null;
        try {
        	/*Assertiva verifica se o Objeto é nulo, senão retorna AssertError*/
			assertNull(cat);
			System.out.println("Categoria excluida com sucesso!");
        }
        catch (AssertionError ae) {
            assertionError = ae.toString();
            System.out.println(assertionError);
        }
		
		
	}
	
	 /*CT-003 Verificar se a funcionalidade de excluir  disciplina esta funcionando
     * 
     */
	
    @Test
	public void testeExcluirDisciplina() throws Exception {
    	EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		Disciplina d = em.find(Disciplina.class, 1L);
		em.remove(d);
		em.getTransaction().commit();
		
		Disciplina disc = em.find(Disciplina.class, 1L);
		
		String assertionError = null;
        try {
        	/*Assertiva verifica se o Objeto é nulo, senão retorna AssertError*/
			assertNull(disc);
			System.out.println("Disciplina excluida com sucesso!");
        }
        catch (AssertionError ae) {
            assertionError = ae.toString();
            System.out.println(assertionError);
        }
		
		
	}
	
	
	
}
