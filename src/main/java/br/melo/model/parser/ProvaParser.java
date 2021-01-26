package br.melo.model.parser;


import br.melo.dto.ProvaDto;
import br.melo.model.Prova;

public class ProvaParser {

	public static ProvaParser get(){
		return  new ProvaParser();
	}

	public ProvaDto dto(Prova entidade){
		ProvaDto dto = new ProvaDto();
		
		dto.setGabarito(entidade.getGabarito());
		dto.setPeso(entidade.getPeso());
		
		return dto;
	}

	public Prova entidade(ProvaDto dto){
		Prova entidade = new Prova();

		entidade.setGabarito(dto.getGabarito());
		entidade.setPeso(dto.getPeso());
		
		return entidade;
	}    

}
