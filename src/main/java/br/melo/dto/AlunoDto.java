package br.melo.dto;


import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class AlunoDto implements Serializable {

	@NotNull(message="Matricula obrigatoria!")
	@NotBlank(message="Nao permitido matricula vazia!")
	private String matricula;
	
	@NotNull(message="Nome obrigatorio!")
	@NotBlank(message="Nao permitido nome vazio!")
	private String nome;

	
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

	
}
