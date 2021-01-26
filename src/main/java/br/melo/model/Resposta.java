package br.melo.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Range;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
@Table(name = "resposta")
public class Resposta extends PanacheEntity {

	@ManyToOne(optional=false)
	@JoinColumn(name="aluno", updatable=false)
	private Aluno aluno;

	@ManyToOne(optional=false)
	private Prova prova;

	@Column(name="nota", nullable=false)
	@Range(min=0, max=10)
	private Float nota;

	@Column(name="solucao", nullable=false)
	private String solucao;

	//CONSTRUCTORS
	public Resposta() {
		super();

	}
	public Resposta(Long id) {
		super();
		this.id = id;
	}


	//GETTERS AND SETTERS
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Aluno getAluno() {
		return aluno;
	}
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	public Prova getProva() {
		return prova;
	}
	public void setProva(Prova prova) {
		this.prova = prova;
	}
	public Float getNota() {
		return nota;
	}
	public void setNota(Float nota) {
		this.nota = nota;
	}
	public String getSolucao() {
		return solucao;
	}
	public void setSolucao(String solucao) {
		this.solucao = solucao;
	}


}
