package br.usp.poli.pece.db;

import java.util.List;

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
	
	@SuppressWarnings("unchecked")
	public static List<Curso> getAllCursos() {
		Session dbs = DataBaseUtil.getSessionFactory().getCurrentSession();
		dbs.beginTransaction();
		
		List<Curso> cursos = (List<Curso>) dbs.createQuery("from Curso").list();
		
		dbs.getTransaction().commit();
		
		return cursos;
	}

	public static void cadastroCurso(Curso curso) {
		Session dbs = DataBaseUtil.getSessionFactory().getCurrentSession();
		
		dbs.beginTransaction();
		dbs.save(curso);
		dbs.getTransaction().commit();
	}
}
