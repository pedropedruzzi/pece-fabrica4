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

	public static Integer getSeqNumber() {
		// TODO Auto-generated method stub
		// fornecer o seq number para a turma nova que acabou de ser criada
		return null;
	}
	
	
}
