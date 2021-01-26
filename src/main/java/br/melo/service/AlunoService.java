package br.melo.service;


import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import javax.transaction.Transactional;

import br.melo.dao.AlunoDao;
import br.melo.dto.AlunoDto;
import br.melo.exception.EscolaException;
import br.melo.model.Aluno;
import br.melo.model.parser.AlunoParser;


@RequestScoped
public class AlunoService {
	@Inject
	AlunoDao dao;

	public List<Aluno> listar() {
		return dao
				.listar()
				.stream()
				.collect(Collectors.toList());
	}
	
	public Aluno buscarAluno(String matricula) throws EscolaException{
		Aluno aluno = dao.buscarAluno(matricula);
		if ( aluno == null ) {
			throw new EscolaException("Aluno não consta em nossos registros!");
		}
		return aluno;
    }

	public List<Aluno> listarAprov() {
		return dao.listarAprov();
	}
	
	@Transactional(rollbackOn = Exception.class) 
	public void cadastrar(AlunoDto alunoDto) throws EscolaException {
		Aluno aluno = AlunoParser.get().entidade(alunoDto);
		aluno.setMedia(-1F);
		dao.cadastrar(aluno);
	}
	
	@Transactional(rollbackOn = Exception.class) 
	public void atualizarMedia(Float nota, String matricula) throws EscolaException {
		Aluno aluno = buscarAluno(matricula);
		Float media = aluno.getMedia();
		if ( media == -1F ) {
			aluno.setMedia( nota );
		} else {
			aluno.setMedia( (media + nota) / 2 );
		}
		
		dao.atualizarMedia(aluno);
	}
	
}
