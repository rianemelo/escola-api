package br.melo.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;


@Entity
@Table(name="aluno")
public class Aluno extends PanacheEntityBase {

	@Id
	private String matricula;

	@Column(name="nome", nullable=false)
	private String nome;

	@Column(name="media")
	private Float media;

	
	//CONSTRUCTORS
	public Aluno() {
		super();
	}
	public Aluno(String matricula) {
		super();
		this.matricula = matricula;
	}


	//GETTERS AND SETTERS
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Float getMedia() {
		return media;
	}
	public void setMedia(Float media) {
		this.media = media;
	}
	

}
