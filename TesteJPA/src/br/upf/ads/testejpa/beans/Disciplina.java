package br.upf.ads.testejpa.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;
import javax.persistence.*;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;


@Entity
public class Disciplina {
	
	
	@Id
	@Column(nullable = false, unique=true)
	@NotNull(message="O id é obrigatório")
	private Long id;
	
	@Column(length=60, nullable = false, unique=true)
	@NotEmpty(message="A descrição  é obrigatória!")
	private String descricao;
	
	private static final long serialVersionUID = 1L;
	
	
	

	

	public Disciplina(Long id, String descricao) {
		super();
		this.id = id;
		this.descricao = descricao;
	}

	public Disciplina() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	

}
