package br.melo.dto;


import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


public class RespostaDto implements Serializable {

	private Long id;
	
	@NotNull(message="Matricula obrigatoria!")
	@NotBlank(message="Nao permitido matricula vazia!")
	private String matricula;
	
	@NotNull(message="Id da prova obrigatorio!") 
	@NotBlank(message="Nao permitido id da prova vazio!")
	private Long idProva;
	
	private Float nota;
	
	@NotNull(message="Solucao obrigatoria!") 
	@NotBlank(message="Nao permitido solucao vazia!")
	private String solucao;
	
	
	//GETTERS AND SETTERS	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public Long getIdProva() {
		return idProva;
	}
	public void setIdProva(Long idProva) {
		this.idProva = idProva;
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
