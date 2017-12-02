package br.com.caelum.ingresso.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.caelum.ingresso.model.Sessao;

@Repository
public class SessaoDao {

	@PersistenceContext
	private EntityManager manager;

	public void save(Sessao sessao) {
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		
		try {
			manager.persist(sessao);
			tx.commit();
			
		} catch(Exception ex) {
			tx.rollback();
			throw new RuntimeException("Erro ao inserir sessão.", ex);
		}
	}
	
	
	
	
	

}
