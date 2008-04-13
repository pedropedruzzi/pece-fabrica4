package br.usp.poli.pece.db;

import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Expression;

import br.usp.poli.pece.bl.Matricula;

public class MatriculaDAO extends GenericDAO<Matricula> {
	
	protected MatriculaDAO() {
		
	}
	
	/**
	 * Lista todas as matriculas do sistema em determinado status
	 */
	@SuppressWarnings("unchecked")
	public List<Matricula> findByStatus(Matricula.Status status) {
		Criterion c = Expression.eq("status", status);
	    
	    return findByCriteria(c);
	}

	@SuppressWarnings("unchecked")
	public List<Matricula> findByStatus(Matricula.Status status, int idCoordenador) {

		Criterion cStatus = Expression.eq("status", status);
		Criterion cCoord = Expression.eq("curso.coordenador.id", idCoordenador);
		
		// se isso não der certo, dá uma olhada em:
		// http://www.hibernate.org/hib_docs/v3/reference/en/html/querycriteria.html
	    
	    return findByCriteria(cStatus, cCoord);
	}
	
	public static void main(String[] args) {
		
		// TODO: TESTARR!!
		
		List<Matricula> matriculas = DAOFactory.getMatriculaDAO().findByStatus(Matricula.Status.PAGO);
		
		System.out.println(matriculas.size());
		
		for (Matricula m : matriculas) {
			System.out.println("nome aluno=" + m.getAluno().getNome());
		}
		
		
		List<Matricula> matriculas2 = DAOFactory.getMatriculaDAO().findByStatus(Matricula.Status.PAGO, 0);
		
		System.out.println(matriculas2.size());
		
		for (Matricula m : matriculas2) {
			System.out.println("nome aluno=" + m.getAluno().getNome());
		}
		
	}
	
}
