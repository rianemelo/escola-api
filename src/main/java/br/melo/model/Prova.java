package br.melo.model;


import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Range;


@Entity
@Table(name = "prova")
public class Prova extends PanacheEntity {

	@Column(name = "gabarito", nullable = false)
	private String gabarito;

	@Column(name = "peso", nullable = false)
	private String peso;

	@Column(name = "alunos", nullable = false)
	@Range(min=0, max=100)
	private Long alunos;


	//CONSTRUCTORS
	public Prova() {
		super();

	}
	public Prova(Long id) {
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
	public String getGabarito() {
		return gabarito;
	}
	public void setGabarito(String gabarito) {
		this.gabarito = gabarito;
	}
	public String getPeso() {
		return peso;
	}
	public void setPeso(String peso) {
		this.peso = peso;
	}
	public Long getAlunos() {
		return alunos;
	}
	public void setAlunos(Long alunos) {
		this.alunos = alunos;
	}


}
