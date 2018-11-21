package br.upf.ads.testejpa.beans;

import javax.persistence.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import br.upf.ads.testejpa.beans.Categoria;
import br.upf.ads.testejpa.beans.Disciplina;


@Entity
public class Conteudo {
	
	
	@Id
	@Column(nullable = false, unique=true)
	@NotNull(message="O id é obrigatório")
	private Long id;
	
	@Column(length=60, nullable = false, unique=true)
	@NotEmpty(message="O titulo  é obrigatório!")
    private String titulo;
	
	@Column(length=60, nullable = false, unique=true)
	@NotEmpty(message="O texto é obrigatória!")
	private String texto;
	
	@ManyToOne(optional = false)
	@NotNull(message="A disciplina deve ser informado!")
	private Disciplina disciplina;
	
	@ManyToOne(optional = false)
	@NotNull(message="A categoria deve ser informada!")
	private Categoria categoria;

	private static final long serialVersionUID = 1L;

	public Conteudo() {
		super();
	}

	

	public Conteudo(Long id, String titulo, String texto, Disciplina disciplina, Categoria categoria) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.texto = texto;
		this.disciplina = disciplina;
		this.categoria = categoria;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	
	
	

}
