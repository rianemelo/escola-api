package br.melo.dao;


import javax.enterprise.context.RequestScoped;
import javax.transaction.Transactional;

import br.melo.model.Prova;

import java.util.List;


@RequestScoped
public class ProvaDao {

    public List<Prova> listar() {
        return Prova.listAll();
    }
    
    public Prova buscarProva(Long id) {
        return Prova.findById(id);
    }
    
    @Transactional
	public void cadastrar(Prova prova) {
    	Prova.persist(prova);
	}
    
    @Transactional
	public void atualizarAlunos(Prova prova) {
    	Long id = prova.getId();
    	Long alunos = prova.getAlunos();
    	alunos = alunos + 1;
    	Prova.update("alunos = " + alunos + "where id = ?1", id);
	}

    
}
