package br.melo.model.parser;


import br.melo.dto.AlunoDto;
import br.melo.model.Aluno;

public class AlunoParser {

	public static AlunoParser get(){
		return  new AlunoParser();
	}

	public AlunoDto dto(Aluno entidade){
		AlunoDto dto = new AlunoDto();
		
		dto.setMatricula(entidade.getMatricula());
		dto.setNome(entidade.getNome());
		
		return dto;
	}

	public Aluno entidade(AlunoDto dto){
		Aluno entidade = new Aluno();

		entidade.setMatricula(dto.getMatricula());
		entidade.setNome(dto.getNome());
		
		return entidade;
	}    

}
