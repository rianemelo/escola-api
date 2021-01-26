package br.melo.dto;


import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ProvaDto implements Serializable {

	@NotNull(message="Gabarito obrigatorio!")
	@NotBlank(message="Nao permitido gabarito vazio!")
	private String gabarito;
	
	@NotNull(message="Peso obrigatorio!")
	@NotBlank(message="Nao permitido peso vazio!")
	private String peso;

	
	//GETTERS AND SETTERS
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
	
	
}
