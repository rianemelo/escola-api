package br.melo.dao;


import javax.enterprise.context.RequestScoped;
import javax.transaction.Transactional;

import br.melo.model.Aluno;

import java.util.List;


@RequestScoped
public class AlunoDao {

    public List<Aluno> listar() {
        return Aluno.listAll();
    }
    
    public Aluno buscarAluno(String matricula) {
    	return Aluno.findById(matricula);
    }
    
    public List<Aluno> listarAprov() {  	
    	Float media = 7F;
    	return Aluno.list("media > ?1", media);
	}
    
    @Transactional
	public void cadastrar(Aluno aluno) {
    	Aluno.persist(aluno);
	}
    
    @Transactional
	public void atualizarMedia(Aluno aluno) {
    	Float media = aluno.getMedia();
    	String matricula = aluno.getMatricula();
    	
    	Aluno.update("media = " + media + "where matricula = ?1", matricula);
	}
    
    
}
