package br.melo.dao;


import javax.enterprise.context.RequestScoped;
import javax.transaction.Transactional;

import br.melo.model.Resposta;

import java.util.List;


@RequestScoped
public class RespostaDao {

    public List<Resposta> listar() {
        return Resposta.listAll();
    }
    
    @Transactional
	public void cadastrar(Resposta resposta) {
    	resposta.persistAndFlush();
	}
    
    
}
