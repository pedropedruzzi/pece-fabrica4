package br.usp.poli.pece.db;

import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Expression;

import br.usp.poli.pece.bl.Aluno;

public class AlunoDAO extends GenericDAO<Aluno> {
	
	protected AlunoDAO() {
		
	}
	
	/**
	 * Lista alunos dado um filtro de nome
	 */
	public List<Aluno> findByNameFilter(String filtro) {
		Criterion c = Expression.like("nome", filtro);
	    
	    return findByCriteria(c);
	}
}
