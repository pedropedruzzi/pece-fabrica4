package br.usp.poli.pece.test;

import org.hibernate.Session;

import br.usp.poli.pece.bl.Aluno;
import br.usp.poli.pece.bl.Curso;
import br.usp.poli.pece.bl.Disciplina;
import br.usp.poli.pece.bl.Professor;
import br.usp.poli.pece.bl.Turma;
import br.usp.poli.pece.db.DAOFactory;
import br.usp.poli.pece.db.DataBaseUtil;

public class TestePedrox {

	
	public static void criatudo(Session dbs) {
		Professor p = new Professor();
		p.setNome("Jorge Risco Becerra");
		p.setEmail("jrisco@poli.usp.br");
		p.setLogin("jrisco");
		p.setSenha("1234");
		dbs.save(p);

		Curso c = new Curso();
		c.setCargaHoraria((short)480);
		c.setCodCurso("COMPCOOP");
		c.setNome("Engenharia de Computacao (Curso Cooperativo)");
		c.setCoordenador(p);
		dbs.save(c);
		
		Disciplina d = new Disciplina();
		d.setCodDisciplina("PCS2039");
		d.setCargaHoraria((short)240);
		d.setNome("Modelagem e Simulação de Sistemas Computacionais");
		d.setCurso(c);
		dbs.save(d);
		
		d = new Disciplina();
		d.setCodDisciplina("PRO2273");
		d.setCargaHoraria((short)240);
		d.setNome("Introdução à Economia");
		d.setCurso(c);
		dbs.save(d);
		
		d = new Disciplina();
		d.setCodDisciplina("PCS2044");
		d.setCargaHoraria((short)240);
		d.setNome("Laboratorio de Engenharia de Software II");
		d.setCurso(c);
		dbs.save(d);
		
		Turma t = new Turma();
		t.setDisciplina(d);
		
		dbs.save(t);
	    
	}
	
	public static void criaAlunos(Session dbs) {
		Aluno a = new Aluno();
		a.setNome("Pedro Rodrigues Nacione Pedruzzi");
		a.setEmail("pedro.pedruzzi@poli.usp.br");
		a.setLogin("pedro.pedruzzi");
		a.setSenha("1234");
		dbs.save(a);
		
		a = new Aluno();
		a.setNome("Grabiel Augusto de Resende");
		a.setEmail("gabriel.resende@poli.usp.br");
		a.setLogin("gabriel.resende");
		a.setSenha("1234");
		dbs.save(a);
		
		a = new Aluno();
		a.setNome("Virgílio Vettorazzo");
		a.setEmail("virgilio.vettorazzo@poli.usp.br");
		a.setLogin("virgilio.vettorazzo");
		a.setSenha("1234");
		dbs.save(a);
	}
	
	public static void populate() {
		Session dbs = DataBaseUtil.getSessionFactory().getCurrentSession();
		dbs.beginTransaction();
		
		criatudo(dbs);
		criaAlunos(dbs);
		
	    dbs.getTransaction().commit();
	}
	
	public static void main(String[] args) {
		populate();
		
		if (true) return;
		Session dbs = DataBaseUtil.getSessionFactory().getCurrentSession();
		dbs.beginTransaction();
		
		Professor risco = (Professor) DAOFactory.getUsuarioDAO().findByLogin("jrisco");
		Curso c = DAOFactory.getCursoDAO().findByCodigo("1234");
		Disciplina d = DAOFactory.getDisciplinaDAO().findByCodigo("XYZ1234");
		
		System.out.println(risco.getNome());
		System.out.println(c.getNome());
		System.out.println(d.getNome());
	}
}
