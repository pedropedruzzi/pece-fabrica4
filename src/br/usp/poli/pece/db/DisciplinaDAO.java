package br.usp.poli.pece.db;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Expression;

import br.usp.poli.pece.bl.Disciplina;

public class DisciplinaDAO extends GenericDAO<Disciplina> {
	
	protected DisciplinaDAO() {
		
	}

	public Disciplina findByCodigo(String codigo) {
		Criterion c = Expression.eq("codigo", codigo);
	    
	    return findUniqueResultByCriteria(c);
	}

}
