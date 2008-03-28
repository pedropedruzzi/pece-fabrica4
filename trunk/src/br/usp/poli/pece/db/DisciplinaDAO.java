package br.usp.poli.pece.db;

import org.hibernate.Session;

import br.usp.poli.pece.bl.Disciplina;

public class DisciplinaDAO {

	
	public static void cadastroDisciplina(Disciplina disciplina) {
		Session dbs = DataBaseUtil.getSessionFactory().getCurrentSession();
		
		dbs.beginTransaction();
		dbs.save(disciplina);
		dbs.getTransaction().commit();
	}

	public static Disciplina getDisciplinaByCodigo(String codigo) {
		Session dbs = DataBaseUtil.getSessionFactory().getCurrentSession();
		dbs.beginTransaction();
		
		Disciplina d = (Disciplina) dbs.createQuery("from Disciplina as d where d.codDisciplina=?")
	    	.setString(0, codigo).uniqueResult();
		
		dbs.getTransaction().commit();
		
		return d;
	}

}
