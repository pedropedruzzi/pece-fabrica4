package br.usp.poli.pece.db;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Expression;

import br.usp.poli.pece.bl.Curso;

public class CursoDAO extends GenericDAO<Curso> {
	
	protected CursoDAO() {
		
	}
	
	public Curso findByCodigo(String codigo) {
		Criterion c = Expression.eq("codCurso", codigo);
	    
	    return findUniqueResultByCriteria(c);
	}
}
