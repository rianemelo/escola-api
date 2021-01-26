package br.melo.service;


import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import br.melo.dao.RespostaDao;
import br.melo.dto.RespostaDto;
import br.melo.exception.EscolaException;
import br.melo.model.Prova;
import br.melo.model.Resposta;
import br.melo.model.parser.RespostaParser;


@RequestScoped
public class RespostaService {
	@Inject
	RespostaDao dao;

	@Inject
	ProvaService provaService;
	
	@Inject
	AlunoService alunoService;

	public List<RespostaDto> listar() {
		return dao
				.listar()
				.stream()
				.map(RespostaParser.get()::dto)
				.collect(Collectors.toList());
	}

	@Transactional(rollbackOn = Exception.class) 
	public void cadastrar(RespostaDto respostaDto) throws EscolaException {
		Float nota = calcularNota(respostaDto);
		Resposta resposta = RespostaParser.get().entidade(respostaDto);
		resposta.setNota(nota);
		
		dao.cadastrar(resposta);
		
		alunoService.atualizarMedia(nota, respostaDto.getMatricula());
		
	}

	
	public Float calcularNota(RespostaDto respostaDto) throws EscolaException { 
		Prova prova = provaService.buscarProva(respostaDto.getIdProva());
		
		Long alunos = prova.getAlunos();
		
		if ( alunos > 100 ) {
			throw new EscolaException("Máximo de 100 alunos por prova!");
		}
		
		provaService.atualizarAlunos(prova);
		
		String[] gabarito = prova.getGabarito().split(",");
		String[] peso = prova.getPeso().split(",");
		
		String solucaoStr = respostaDto.getSolucao().replaceAll("\\s", "").toUpperCase();
		respostaDto.setSolucao(solucaoStr);
		String[] solucao = solucaoStr.split(",");

		if ( gabarito.length != solucao.length ) {
			throw new EscolaException("Resposta inválida!");
		}

		float nota = 0f; 
		try {
			for (int i=0; i<solucao.length; i++) {
				int p = Integer.parseInt(peso[i]);
				if ( gabarito[i].equals(solucao[i]) ) {
					nota = nota + p;
				}
			}
		} catch (Exception e) {
			throw new EscolaException("Resposta inválida!");
		}
		
		
		return Float.valueOf(nota);
	}


}
