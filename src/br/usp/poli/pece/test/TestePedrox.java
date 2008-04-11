package br.usp.poli.pece.test;

import org.hibernate.Session;

import br.usp.poli.pece.bl.Aluno;
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
		p.setNome("Jorge Risco Becerra");
		p.setEmail("jrisco@poli.usp.br");
		p.setLogin("jrisco");
		p.setSenha("1234");
		p.setCelular(1234);
		p.setTelefone(12345);
		
		dbs.save(p);

		Curso c = new Curso();
		c.setCargaHoraria((short)480);
		c.setCodCurso("COMPCOOP");
		c.setNome("Engenharia de Computacao (Curso Cooperativo)");
		c.setCoordenador(p);
		
		dbs.save(c);
		
		Disciplina d = new Disciplina();
		d.setCodDisciplina("PCS204");
		d.setCargaHoraria((short)240);
		d.setNome("Laboratorio de Engenharia de Software II");
		d.setCurso(c);
		
		dbs.save(d);
		
		Turma t = new Turma();
		t.setDisciplina(d);
		
		dbs.save(t);
	    
	    dbs.getTransaction().commit();
	}
	
	public static void criatudo2() {
		Session dbs = DataBaseUtil.getSessionFactory().getCurrentSession();
		dbs.beginTransaction();
		
		Aluno a = new Aluno();
		a.setNome("Pedro Pedruzzi");
		a.setEmail("pedro.pedruzzi@poli.usp.br");
		a.setLogin("pedro.pedruzzi");
		a.setSenha("1234");
		a.setCelular(1234);
		a.setTelefone(12345);
		
		dbs.save(a);
	    
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
		criatudo();
		
		if (true) return;
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
	}
}
