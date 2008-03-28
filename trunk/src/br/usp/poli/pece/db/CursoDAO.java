package br.usp.poli.pece.db;

import org.hibernate.Session;

import br.usp.poli.pece.bl.Curso;

public class CursoDAO {

	public static Curso getCursoByCodigo(String codigo) {
		Session dbs = DataBaseUtil.getSessionFactory().getCurrentSession();
		dbs.beginTransaction();
		
		Curso c = (Curso) dbs.createQuery("from Curso as c where c.codCurso=?")
	    	.setString(0, codigo).uniqueResult();
		
		dbs.getTransaction().commit();
		
		return c;
	}

	public static void cadastroCurso(Curso curso) {
		Session dbs = DataBaseUtil.getSessionFactory().getCurrentSession();
		
		dbs.beginTransaction();
		dbs.save(curso);
		dbs.getTransaction().commit();
	}
}
