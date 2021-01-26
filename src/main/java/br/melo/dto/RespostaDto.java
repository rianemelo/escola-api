package br.melo.dto;


import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


public class RespostaDto implements Serializable {

	@NotNull(message="Matricula obrigatoria!")
	@NotBlank(message="Nao permitido matricula vazia!")
	private String matricula;
	
	@NotNull(message="Id da prova obrigatorio!") 
	@NotBlank(message="Nao permitido id da prova vazio!")
	private Long idProva;
		
	@NotNull(message="Solucao obrigatoria!") 
	@NotBlank(message="Nao permitido solucao vazia!")
	private String solucao;
	
	
	//GETTERS AND SETTERS	
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
	public String getSolucao() {
		return solucao;
	}
	public void setSolucao(String solucao) {
		this.solucao = solucao;
	}


}
