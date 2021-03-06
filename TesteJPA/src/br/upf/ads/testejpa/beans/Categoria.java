package br.upf.ads.testejpa.beans;
import javax.persistence.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Categoria {
	
	
	@Id
	@Column(nullable = false, unique=true)
	@NotNull(message="O id � obrigat�rio")
	private Long id;
	
	@Column(length=60, nullable = false, unique=true)
	@NotEmpty(message="A descri��o  � obrigat�ria!")
	private String descricao;

	private static final long serialVersionUID = 1L;
	
	
	
	
	
	public Categoria(Long id, String descricao) {
		super();
		this.id = id;
		this.descricao = descricao;
	}

	public Categoria() {
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
