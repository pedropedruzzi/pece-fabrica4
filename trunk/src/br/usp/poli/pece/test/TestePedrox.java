package br.usp.poli.pece.test;

import org.hibernate.Session;

import br.usp.poli.pece.bl.Curso;
import br.usp.poli.pece.bl.Disciplina;
import br.usp.poli.pece.bl.Professor;
import br.usp.poli.pece.bl.Turma;
import br.usp.poli.pece.db.CursoDAO;
import br.usp.poli.pece.db.DataBaseUtil;
import br.usp.poli.pece.db.DisciplinaDAO;
import br.usp.poli.pece.db.UsuarioDAO;

public class TestePedrox {

	
	public static void criatudo() {
		Session dbs = DataBaseUtil.getSessionFactory().getCurrentSession();
		dbs.beginTransaction();
		
		Professor p = new Professor();
		p.setNome("Jorge Risco");
		p.setEmail("jrisco@poli.usp.br");
		p.setLogin("jrisco");
		p.setSenha("1234");
		p.setCelular(1234);
		p.setTelefone(12345);
		
		dbs.save(p);

		Curso c = new Curso();
		c.setCargaHoraria((short)480);
		c.setCodCurso("1234");
		c.setNome("12345678");
		c.setCoordenador(p);
		
		dbs.save(c);
		
		Disciplina d = new Disciplina();
		d.setCodDisciplina("XYZ1234");
		d.setCargaHoraria((short)240);
		d.setNome("Discplina XYZ");
		d.setCurso(c);
		
		dbs.save(d);
		
		Turma t = new Turma();
		t.setDisciplina(d);
		
		dbs.save(t);
	    
	    dbs.getTransaction().commit();
	}
	
	public static void old() {
		Session dbs = DataBaseUtil.getSessionFactory().getCurrentSession();
		dbs.beginTransaction();
		
		dbs.get(Turma.class, new Long(0));
		
		Professor risco = (Professor) dbs.createQuery("from Professor as p where p.login=?")
	    	.setString(0, "jrisco").uniqueResult();
		
		System.out.println(risco.getNome());

	}
	
	public static void main(String[] args) {
		Professor risco = (Professor) UsuarioDAO.getUsuarioByLogin("jrisco");
		Curso c = CursoDAO.getCursoByCodigo("1234");
		Disciplina d = DisciplinaDAO.getDisciplinaByCodigo("XYZ1234");
		
		System.out.println(risco.getNome());
		System.out.println(c.getNome());
		System.out.println(d.getNome());
		
		Turma t2 = new Turma();
		t2.setDisciplina(d);
		

		Session dbs = DataBaseUtil.getSessionFactory().getCurrentSession();
		dbs.beginTransaction();
		dbs.save(t2);
		dbs.getTransaction().commit();
		
		
		/*
		Professor x = new Professor();
		x.setId(risco.getId());
		x.setNome("Jorge Risco");
		x.setEmail("jrisco@poli.usp.br");
		x.setLogin("jrisco");
		x.setSenha("4321");
		x.setCelular(1234);
		x.setTelefone(12345);
		
		UsuarioDAO.updateUsuario(x);*/
	}
}
