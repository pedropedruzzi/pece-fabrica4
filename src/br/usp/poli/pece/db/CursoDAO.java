package br.usp.poli.pece.db;

import org.hibernate.Session;

import br.usp.poli.pece.bl.Curso;

public class CursoDAO {

	public static void cadastroCurso(Curso curso) {
		Session dbs = DataBaseUtil.getSessionFactory().getCurrentSession();
		
		dbs.beginTransaction();
		dbs.save(curso);
		dbs.getTransaction().commit();
	}
	
}
