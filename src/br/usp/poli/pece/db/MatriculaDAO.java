package br.usp.poli.pece.db;

import org.hibernate.Session;

import br.usp.poli.pece.bl.Matricula;

public class MatriculaDAO {

	public static void cadastroMatricula(Matricula matricula) {
		Session dbs = DataBaseUtil.getSessionFactory().getCurrentSession();
		
		dbs.beginTransaction();
		dbs.save(matricula);
		dbs.getTransaction().commit();
	}

	
	public static int getSeqNumber() {
		// TODO Auto-generated method stub
		// retronar um seq number para identificar a matricula
		return 0;
	}
	
}
