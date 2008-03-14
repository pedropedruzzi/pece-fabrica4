package br.usp.poli.pece.db;

import org.hibernate.Session;

import br.usp.poli.pece.bl.Turma;

public class TurmaDAO {

	public static void cadastroTurma(Turma turma) {
		Session dbs = DataBaseUtil.getSessionFactory().getCurrentSession();
		
		dbs.beginTransaction();
		dbs.save(turma);
		dbs.getTransaction().commit();
	}
	
	
}
