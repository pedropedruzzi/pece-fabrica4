package br.usp.poli.pece.db;

import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Expression;

import br.usp.poli.pece.bl.Usuario;

public class UsuarioDAO extends GenericDAO<Usuario> {
	
	protected UsuarioDAO() {
		
	}
	
	/**
	 * Lista usuarios dado um filtro de nome
	 */
	public List<Usuario> findByNameFilter(String filtro) {
		Criterion c = Expression.like("nome", filtro);
	    
	    return findByCriteria(c);
	}
	
	public Usuario findByLogin(String login) {
		Criterion c = Expression.eq("login", login);
	    
	    return findUniqueResultByCriteria(c);
	}
}
