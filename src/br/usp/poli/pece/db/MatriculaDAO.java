package br.usp.poli.pece.db;

import java.util.List;

import org.hibernate.Session;

import br.usp.poli.pece.bl.Matricula;

public class MatriculaDAO {

	public static void cadastroMatricula(Matricula matricula) {
		Session dbs = DataBaseUtil.getSessionFactory().getCurrentSession();
		
		dbs.beginTransaction();
		dbs.save(matricula);
		dbs.getTransaction().commit();
	}
	
	/**
	 * Lista todas as matriculas do sistema de determinado tipo
	 * 
	 * @return		List<Aluno>		Lista de todos os alunos cadastrados
	 */
	@SuppressWarnings("unchecked")
	public static List<Matricula> getMatriculaByStatus(Matricula.Status status) {
		Session dbs = DataBaseUtil.getSessionFactory().getCurrentSession();
		dbs.beginTransaction();
		
	    List<Matricula> result = (List<Matricula>)dbs.createQuery("from Matricula where status=?").setInteger(0, status.ordinal()).list();
	    
	    dbs.getTransaction().commit();
	    
	    return result;
	}

	@SuppressWarnings("unchecked")
	public static List<Matricula> getMatriculaByStatus(Matricula.Status status, int idCoordenador) {
		Session dbs = DataBaseUtil.getSessionFactory().getCurrentSession();
		dbs.beginTransaction();
		
	    List<Matricula> result = (List<Matricula>)dbs.createQuery("from Matricula where status=? and curso.coordenador.id=?")
	    	.setInteger(0, status.ordinal())
	    	.setInteger(1, idCoordenador).list();
	    
	    dbs.getTransaction().commit();
	    
	    return result;
	}
	
	public static void main(String[] args) {
		List<Matricula> matriculas = MatriculaDAO.getMatriculaByStatus(Matricula.Status.PAGO);
		
		System.out.println(matriculas.size());
		
		for (Matricula m : matriculas) {
			System.out.println("nome aluno=" + m.getAluno().getNome());
		}
		
		
		List<Matricula> matriculas2 = MatriculaDAO.getMatriculaByStatus(Matricula.Status.PAGO, 0);
		
		System.out.println(matriculas2.size());
		
		for (Matricula m : matriculas2) {
			System.out.println("nome aluno=" + m.getAluno().getNome());
		}
		
	}
	
}
