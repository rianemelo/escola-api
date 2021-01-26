package br.melo.service;


import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import br.melo.dao.ProvaDao;
import br.melo.dto.ProvaDto;
import br.melo.exception.EscolaException;
import br.melo.model.Prova;
import br.melo.model.parser.ProvaParser;


@RequestScoped
public class ProvaService {
	@Inject
	ProvaDao dao;

	public List<Prova> listar() {
		return dao
				.listar()
				.stream()
				.collect(Collectors.toList());
	}
	
	public Prova buscarProva(Long id) throws EscolaException {
		Prova prova = dao.buscarProva(id);
		if ( prova == null ) {
			throw new EscolaException("Prova não consta em nossos registros!");
		}
		return prova;
    }

	@Transactional(rollbackOn = Exception.class) 
	public void atualizarAlunos(Prova prova) {
		dao.atualizarAlunos(prova);
	}
	
	@Transactional(rollbackOn = Exception.class) 
	public void cadastrar(ProvaDto provaDto) throws EscolaException {
		validar(provaDto);
		
		Prova prova = ProvaParser.get().entidade(provaDto);
		prova.setAlunos(0L);

		dao.cadastrar(prova);
	}

	public void validar(ProvaDto provaDto) throws EscolaException {
		if ( provaDto.getGabarito().length() == 0 || provaDto.getPeso().length() == 0) {
			throw new EscolaException("Formato inválido! Preencha todos os campos.");
		}

		provaDto.setGabarito(provaDto.getGabarito().replaceAll("\\s","").toUpperCase());
		provaDto.setPeso(provaDto.getPeso().replaceAll("\\s",""));
		
		String[] gabaritoArray = provaDto.getGabarito().split(",");		
		String[] pesoArray = provaDto.getPeso().split(",");
		
		Float soma = 0F;

		try {
			for (int i=0; i<pesoArray.length; i++) {
				int p = Integer.parseInt(pesoArray[i]); 
				if ( p >= 0 ) {
					soma = soma + p;
				} 
			}
		} catch (NumberFormatException e) {
			throw new EscolaException("Formato inválido! peso e valor devem conter apenas inteiros positivos.");
		}

		if ( soma != 10F ) {
			throw new EscolaException("Formato inválido! "
						+ "A soma dos pesos deve ser 10 e todos os pesos devem ser maiores do que zero.");
		}

		if ( gabaritoArray.length != pesoArray.length ) {
			throw new EscolaException("Formato inválido! gabarito , peso e valor devem ter o mesmo tamanho.");
		}

	}


}
