package br.melo.model.parser;


import br.melo.dto.RespostaDto;
import br.melo.model.Aluno;
import br.melo.model.Prova;
import br.melo.model.Resposta;

public class RespostaParser {

	public static RespostaParser get(){
		return  new RespostaParser();
	}

	public RespostaDto dto(Resposta entidade){
		RespostaDto dto = new RespostaDto();

		dto.setId(entidade.getId());
		dto.setIdProva(entidade.getProva().getId());
		dto.setMatricula(entidade.getAluno().getMatricula());
		dto.setNota(entidade.getNota());
		dto.setSolucao(entidade.getSolucao());
		
		return dto;
	}

	public Resposta entidade(RespostaDto dto){
		Resposta entidade = new Resposta();

		entidade.setId(dto.getId());
		entidade.setProva(new Prova(dto.getIdProva()));
		entidade.setAluno(new Aluno(dto.getMatricula()));
		entidade.setNota(dto.getNota());
		entidade.setSolucao(dto.getSolucao());
		
		return entidade;
	}    

}
